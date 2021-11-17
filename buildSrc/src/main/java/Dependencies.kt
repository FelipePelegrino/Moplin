object Plugins {
    val androidApplication by lazy { "com.android.application" }
    val kotlinAndroid by lazy { "kotlin-android" }
    val navigationSafeArgs by lazy { "androidx.navigation.safeargs" }
    val kapt by lazy { "kotlin-kapt" }
}

object Deps {
    // General
    val gradleBuild by lazy { "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val ktx by lazy { "androidx.core:core-ktx:${Versions.ktx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinGradlePlugin}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacy}" }

    // Layout
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    //Navigation
    val navigation by lazy { "androidx.navigation:navigation-fragment:${Versions.navigation}" }
    val navigationSafeArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }

    //ViewModel
    val liveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}" }

    //Retrofit
    val retrofit by lazy {"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val gson by lazy {"com.squareup.retrofit2:converter-gson:${Versions.retrofit}"}
    val adapterRxJava by lazy {"com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"}

    //Glide
    val glide by lazy {"com.github.bumptech.glide:glide:${Versions.glide}"}
    val annotationGlide by lazy {"com.github.bumptech.glide:compiler:${Versions.glide}" }

    //Test
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
}

object Test {
    val testjUnit by lazy { "androidx.test.ext:junit:${Versions.testjUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core::${Versions.espresso}" }
}