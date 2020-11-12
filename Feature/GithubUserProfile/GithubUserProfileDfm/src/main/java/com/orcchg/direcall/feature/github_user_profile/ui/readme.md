Dynamic Feature Module cannot be covered with :demo-app module due to it's
transitive dependency on :app. To test UI and whole feature in standalone
:demo-app we have to extract it to separate :ui library module, leaving DFM
almost empty (only AndroidManifest.xml file). This makes it useless and
impossible to have on-demand loaded dynamic features.
