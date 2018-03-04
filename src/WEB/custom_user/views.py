from django.http import HttpResponse
from django.shortcuts import render
from django.contrib.auth import login, get_user_model
from .forms import SignupForm
from django.contrib.sites.shortcuts import get_current_site
from django.utils.encoding import force_bytes, force_text
from django.utils.http import urlsafe_base64_encode, urlsafe_base64_decode
from django.template.loader import render_to_string
from .tokens import account_activation_token
from django.core.mail import EmailMessage


def signup(request):
    if request.method == 'POST':
        form = SignupForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.is_active = False
            user.save()
            current_site = get_current_site(request)
            mail_subject = '계정의 이메일 주소를 인증해 주십시오'
            message = render_to_string('custom_user/acc_active_email.html', {
                'user': user.nickname,
                'domain': current_site.domain,
                'uid': urlsafe_base64_encode(force_bytes(user.pk)),
                'token': account_activation_token.make_token(user),
            })
            to_email = form.cleaned_data.get('email')
            email = EmailMessage(
                mail_subject, message, to=[to_email]
            )
            email.send()
            return HttpResponse('등록을 완료하기 위해 이메일 인증을 해주십시오.')
    else:
        form = SignupForm()
    return render(request, 'custom_user/signup.html', {'form': form})


def activate(request, uidb64, token):
    User = get_user_model()
    try:
        uid = force_text(urlsafe_base64_decode(uidb64))
        user = User.objects.get(pk=uid)
    except(TypeError, ValueError, OverflowError, User.DoesNotExist):
        user = None
    if user is not None and account_activation_token.check_token(user, token):
        user.is_active = True
        user.save()
        login(request, user)
        # return redirect('home')
        return HttpResponse('이메일 인증이 완료되었습니다. 이제 로그인하실 수 있습니다.')
    else:
        return HttpResponse('올바르지 않은 인증 링크입니다.')


def join(request):
    if request.method == 'POST':
        form = SignupForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.is_active = False
            user.save()
            current_site = get_current_site(request)
            mail_subject = '계정의 이메일 주소를 인증해 주십시오'
            message = render_to_string('custom_user/acc_active_email.html', {
                'user': user.nickname,
                'domain': current_site.domain,
                'uid': urlsafe_base64_encode(force_bytes(user.pk)),
                'token': account_activation_token.make_token(user),
            })
            to_email = form.cleaned_data.get('email')
            email = EmailMessage(
                mail_subject, message, to=[to_email]
            )
            email.send()
            return HttpResponse('등록을 완료하기 위해 이메일 인증을 해주십시오.')
    else:
        form = SignupForm()
    return render(request, 'custom_user/join.html', {'form': form})