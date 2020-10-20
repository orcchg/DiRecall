## Dagger Modularized with Component dependencies and Dynamic Features

Use dagger component dependencies for feature gradle-modules rather than aggregating all features' bindings into one single AppComponent.

Component dependencies are useful when it's needed to provide dependencies between sibling features or when Dynamic Features are used.
Here we switch to use Dynamic Features, since sibling features do not depend on each other. Bindings are provided from AppComponent
via multibindings, although feature modules could use other Core-lib components as direct dependencies: this reduces boilerplate.
