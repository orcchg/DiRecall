## Manual Di

Dependencies are provided manually without using any DI framework.
Objects are instantiated exactly at places where they're needed, and
there is no global storage, so the objects are not reused. This incures
excess objects to be created even there already exists instance of the
same class.
