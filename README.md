## Kaspersky

Modularized architecture with isolated Dagger Component within each Feature.
Each Dagger Component has **initAndGet()** static method, that initializes
that component as Singleton and makes it available for Feature's dependee.

This approach forces to duplicate code for **initAndGet()** in pretty much
every component, adds DCL overhead and doesn't give centralized access to
all components: Feature that should use another Feature's component has to
depend on that Feature's :impl module, which breaks feature isolation.

https://habr.com/ru/company/kaspersky/blog/422555/
https://github.com/matzuk/Clean-multimodel-arch/tree/clean_app
