
plugins {
    id("org.jetbrains.kotlin.multiplatform") version "2.0.20" apply false
    alias(libs.plugins.mavenPublish) apply false
}
group = "me.jens"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

