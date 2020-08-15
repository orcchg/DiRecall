package com.orcchg.direcall.build

object Versions {
    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.1"
    const val espresso = "3.2.0"
    const val gradleAndroid = "4.0.1"
    const val junit = "4.13"
    const val junitAndroidExt = "1.1.1"
    const val ktStdLib = "1.3.72"
    const val moshi = "1.9.3"
    const val retrofit = "2.9.0"
    const val rx = "2.2.19"
    const val rxKt = "2.4.0"
}

object Dependencies {

    object AndroidX {
        @JvmStatic val appCompat = dependency("androidx.appcompat:appcompat:${Versions.appCompat}")
        @JvmStatic val coreKtx = dependency("androidx.core:core-ktx:${Versions.coreKtx}")
    }

    object Gradle {
        @JvmStatic val androidGradle = dependency("com.android.tools.build:gradle:${Versions.gradleAndroid}")
        @JvmStatic val ktGradle = dependency("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.ktStdLib}")
    }

    object Lib {
        @JvmStatic val ktStdLib = dependency("org.jetbrains.kotlin:kotlin-stdlib:${Versions.ktStdLib}")
        @JvmStatic val ktStdLibJdk7 = dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.ktStdLib}")
    }

    object Network {
        @JvmStatic val retrofit = dependency("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        @JvmStatic val retrofitMoshi = dependency("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
        @JvmStatic val retrofitRx = dependency("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}")
    }

    object Parser {
        @JvmStatic val moshi = dependency("com.squareup.moshi:moshi-adapters:${Versions.moshi}")
    }

    object Rx {
        @JvmStatic val rx = dependency("io.reactivex.rxjava2:rxjava:${Versions.rx}")
        @JvmStatic val rxKt = dependency("io.reactivex.rxjava2:rxkotlin:${Versions.rxKt}")
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
