## Sber

Sber Arch represents a highly modularized approach, where all features are decoupled from each other as possible.
Each feature declares a FeatureApi interface where it exposes a subset of it's entities that could be potentially
in use in other features. FeatureApi is actually implemented by FeatureComponent, and the Arch utilizes Dagger's
component dependencies. The feature and all it's bindings (exposed entities) are instantiated on demand, where
they're actually needed by some another feature. The latter requests a global map for a specific FeatureApi
and that will trigger FeatureComponent to be built and retrieved. It is also stored in a special structure - 
FeatureHolder - that is reference counted and keep alive while requested feature is in use.
