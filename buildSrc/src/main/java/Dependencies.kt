object Plugins {
    val androidApplication by lazy {"com.android.application"}
    val kotlinAndroid by lazy {"kotlin-android"}
}

object Deps {
    val gradleBuild by lazy{ "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}" }
    val ktx by lazy { "androidx.core:core-ktx:${Versions.ktx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinGradlePlugin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
}

object Test {
    val testjUnit by lazy { "androidx.test.ext:junit:${Versions.testjUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core::${Versions.espresso}" }
}