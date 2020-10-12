## Dagger with dynamic args passing to ViewModel

DaggerAndroid does not allow to pass dynamic args to @Inject ctors of classes
that will be injected with it. Thus, in *dagger* sample subcomponents were instantiated
manually and *Fragments* were injected explicitly in *onAttach()* method.

If we allow passing dynamic args to *ViewModel*, we can make use the power of DaggerAndroid
and inject *ViewModel* implicitly into *Fragment*. We can even get rid of code duplication
for *ViewModelFactory* that also get instantiated each time the *Fragment* recreates,
and have one single and generic *ViewModelFactory* able to provide some *Fragment* with an
instance of *ViewModel* it needs, based on key-value map (multibinding).

Multibinding is an early binding, so the map entries should be configured at compile time
and hence there is no way to configure them using dynamic args.

https://medium.com/chili-labs/android-viewmodel-injection-with-dagger-f0061d3402ff
