import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

plugins {
    kotlin("multiplatform") version "2.0.20"
}

repositories {
    mavenLocal()
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
                implementation("de.jensklingenberg.kotlin-wrappers:johnny-five:0.8.1")
            }
        }
    }
}

tasks.wrapper {
    gradleVersion = "8.5"
    distributionType = Wrapper.DistributionType.ALL
}


rootProject.plugins.withType<YarnPlugin> {
    rootProject.the<YarnRootExtension>().ignoreScripts = false
}