from .base import *

# SECURITY WARNING: keep the secret key used in production secret!
environments_file = os.path.join(BASE_DIR, 'envs.json')
with open(environments_file) as f:
    environments = json.loads(f.read())

SECRET_KEY = get_secret("SECRET_KEY", environments)

# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = False

ALLOWED_HOSTS = []

# Database
# https://docs.djangoproject.com/en/1.11/ref/settings/#databases

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    }
}
