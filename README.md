## Architecture Playground

This repo contains various samples of Android App Architecture based on Clean Arch + MVVM (using Android Arch Components).
Switch the branch to see how these samples are implemented. Master branch does not implement working App because of lack of DI.
Also, README.md changes upon branch switching, describing each approach in deep details.

master - models, layers, screens, no di (not working App)
manual - manual di, dependencies are provided explicitly, no scoping (objects are not reused)
dagger - dagger di with scoping
sber - Sberbank's SuperApp architecture with separated features (dagger components and feature holders)

// to be continued...
