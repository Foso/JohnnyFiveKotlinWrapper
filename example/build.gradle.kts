plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

group = "me.jens"

repositories {
    mavenCentral()
}



kotlin {
    js(IR) {
        binaries.executable()
        nodejs {}
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":wrapper"))
            }
        }
    }
}
