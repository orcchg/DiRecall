package com.orcchg.direcall.build

object Versions {
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30

    const val appCompat = "1.2.0"
    const val autoDispose = "1.4.0"
    const val buildToolsVersion = "30.0.0"
    const val constraintLayout = "2.0.0-rc1"
    const val coreKtx = "1.3.1"
    const val espresso = "3.2.0"
    const val fragmentKtx = "1.2.5"
    const val glide = "4.11.0"
    const val gradleAndroid = "4.0.1"
    const val junit = "4.13"
    const val junitAndroidExt = "1.1.1"
    const val ktlint = "0.38.0"
    const val ktlintGradle = "9.4.1"
    const val ktStdLib = "1.4.10"
    const val lifecycle = "2.2.0"
    const val lint = "27.0.1"
    const val moshi = "1.9.3"
    const val navigation = "2.3.0"
    const val okHttp = "4.8.1"
    const val recyclerView = "1.1.0"
    const val retrofit = "2.9.0"
    const val rx = "2.2.19"
    const val rxAndroid = "2.1.1"
    const val rxBinding = "3.1.0"
    const val rxKt = "2.4.0"
    const val timber = "4.7.1"
}

object Dependencies {

    object AndroidX {
        @JvmStatic val appCompat = dependency("androidx.appcompat:appcompat:${Versions.appCompat}")
        @JvmStatic val coreKtx = dependency("androidx.core:core-ktx:${Versions.coreKtx}")
        @JvmStatic val fragmentKtx = dependency("androidx.fragment:fragment-ktx:${Versions.fragmentKtx}")
        @JvmStatic val liveData = dependency("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}")
        @JvmStatic val navigation = dependency("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}")
        @JvmStatic val navigationSafeArgs = dependency("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
        @JvmStatic val navigationUi = dependency("androidx.navigation:navigation-ui-ktx:${Versions.navigation}")
    }

    object Gradle {
        @JvmStatic val androidGradle = dependency("com.android.tools.build:gradle:${Versions.gradleAndroid}")
        @JvmStatic val ktGradle = dependency("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.ktStdLib}")
    }

    object Lib {
        @JvmStatic val glide = dependency("com.github.bumptech.glide:glide:${Versions.glide}")
        @JvmStatic val ktStdLib = dependency("org.jetbrains.kotlin:kotlin-stdlib:${Versions.ktStdLib}")
        @JvmStatic val ktStdLibJdk7 = dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.ktStdLib}")
        @JvmStatic val timber = dependency("com.jakewharton.timber:timber:${Versions.timber}")
    }

    object Network {
        @JvmStatic val okHttpLog = dependency("com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}")
        @JvmStatic val retrofit = dependency("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        @JvmStatic val retrofitMoshi = dependency("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
        @JvmStatic val retrofitRx = dependency("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}")
    }

    object Parser {
        @JvmStatic val moshi = dependency("com.squareup.moshi:moshi-adapters:${Versions.moshi}")
        @JvmStatic val moshiAdapters = dependency("com.squareup.moshi:moshi-adapters:${Versions.moshi}")
        @JvmStatic val moshiKotlin = dependency("com.squareup.moshi:moshi-kotlin:${Versions.moshi}")
        @JvmStatic val moshiKotlinCodegen = dependency("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}")
    }

    object Plugin {
        const val androidApp = "com.android.application"
        const val androidLib = "com.android.library"
        const val javaLib = "java-library"
        const val google = "com.google.gms.google-services"
        const val kotlin = "kotlin"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExt = "kotlin-android-extensions"
        const val kotlinAnnotation = "kotlin-kapt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val navSafeArgs = "androidx.navigation.safeargs.kotlin"
    }

    object Rx {
        @JvmStatic val autoDispose = dependency("com.uber.autodispose:autodispose:${Versions.autoDispose}")
        @JvmStatic val autoDisposeAndroidAC = dependency("com.uber.autodispose:autodispose-android-archcomponents:${Versions.autoDispose}")
        @JvmStatic val rx = dependency("io.reactivex.rxjava2:rxjava:${Versions.rx}")
        @JvmStatic val rxKt = dependency("io.reactivex.rxjava2:rxkotlin:${Versions.rxKt}")
        @JvmStatic val rxAndroid = dependency("io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}")
        @JvmStatic val rxBinding = dependency("com.jakewharton.rxbinding3:rxbinding:${Versions.rxBinding}")
        @JvmStatic val rxBindingCore = dependency("com.jakewharton.rxbinding3:rxbinding-core:${Versions.rxBinding}")
    }

    object View {
        @JvmStatic val constraintLayout = dependency("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
        @JvmStatic val recyclerView = dependency("androidx.recyclerview:recyclerview:${Versions.recyclerView}")
    }

    object Lint {
        @JvmStatic val lintApi = dependency("com.android.tools.lint:lint-api:${Versions.lint}")
        @JvmStatic val lintChecks = dependency("com.android.tools.lint:lint-checks:${Versions.lint}")
        @JvmStatic val lintCore = dependency("com.android.tools.lint:lint:${Versions.lint}")
        @JvmStatic val lintTests = dependency("com.android.tools.lint:lint-tests:${Versions.lint}")
    }

    object AndroidTest {
        @JvmStatic val espresso = dependency("androidx.test.espresso:espresso-core:${Versions.espresso}")
        @JvmStatic val junit = dependency("androidx.test.ext:junit:${Versions.junitAndroidExt}")
    }

    object Test {
        @JvmStatic val junit = dependency("junit:junit:${Versions.junit}")
    }

    @Suppress("MemberVisibilityCanBePrivate")
    val allProjectDependencies: MutableSet<String> = mutableSetOf()

    private fun dependency(dependency: String): String {
        allProjectDependencies.add(dependency)
        return dependency
    }
}
