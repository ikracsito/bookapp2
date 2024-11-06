plugins {
    id("com.android.application")
    id("kotlin-android") // Lo dejamos para la compatibilidad con Android, pero usaremos solo Java
    id("org.jetbrains.kotlin.plugin.serialization") // Si usas alguna característica de Kotlin como Serialization
    id("kotlin-kapt") // Solo si usas Kapt
    id("kotlin-android-extensions") // Esto es para trabajar con Views si lo deseas (se usa a veces en Android)
    id("kotlin") // Para Kotlin si en algún punto se necesita.
    id("androidx.room") // Si usas Room
}

android {
    compileSdkVersion(33)  // Ajusta a la versión de tu proyecto

    defaultConfig {
        applicationId = "com.stevdza_san.demo"
        minSdk = 21   // Ajusta esto a la versión mínima que quieras soportar
        targetSdk = 33  // Ajusta esto según sea necesario
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // Habilitar o deshabilitar minificación
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true // Si usas ViewBinding
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.room:room-runtime:2.3.0") // Si usas Room
    implementation("androidx.room:room-ktx:2.3.0") // Si usas Room con KTX

    // Dependencias de UI
    implementation("androidx.compose.ui:ui:1.0.0")
    implementation("androidx.compose.material:material:1.0.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.0")

    // Dependencias adicionales
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22") // Versión de Kotlin actualizada
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Koin o cualquier otro framework que estés usando
    implementation("org.koin:koin-android:2.2.2")
}
