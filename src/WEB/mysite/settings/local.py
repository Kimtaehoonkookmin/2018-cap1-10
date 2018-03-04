from .base import *

# SECURITY WARNING: keep the secret key used in production secret!
environments_file = os.path.join(BASE_DIR, 'envs_dev.json')
with open(environments_file) as f:
    environments = json.loads(f.read())

SECRET_KEY = get_secret("SECRET_KEY", environments)

# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = True

ALLOWED_HOSTS = []

# Database
# https://docs.djangoproject.com/en/1.11/ref/settings/#databases

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    }
}

# Email Confirmation Settings
EMAIL_BACKEND = 'django.core.mail.backends.smtp.EmailBackend'
EMAIL_HOST = 'smtp.gmail.com'
EMAIL_HOST_USER = get_secret("EMAIL_HOST_USER", environments)
EMAIL_HOST_PASSWORD = get_secret("EMAIL_HOST_PASSWORD", environments)
EMAIL_PORT = 587
EMAIL_USE_TLS = True
DEFAULT_FROM_EMAIL = EMAIL_HOST_USER
PASSWORD_RESET_TIMEOUT_DAYS = 1
