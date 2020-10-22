plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")

    // for custom plugins
    implementation(gradleApi())
    implementation(localGroovy())
}
