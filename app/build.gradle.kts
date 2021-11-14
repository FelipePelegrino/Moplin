plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.androidJUnitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ConfigData.proGuardFile),
                ConfigData.proGuardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = Versions.jvmTarget
        }
    }
}

dependencies {

    implementation(Deps.ktx)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    testImplementation(Deps.junit)
    androidTestImplementation(Test.testjUnit)
    androidTestImplementation(Test.espresso)
}