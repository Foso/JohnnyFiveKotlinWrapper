plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.vanniktech.maven.publish")
    //id("maven-publish")
}


val enableSigning = project.hasProperty("signingInMemoryKey")

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        nodejs {
            compilations.all {
                compileKotlinTask.kotlinOptions.freeCompilerArgs += listOf("-Xir-minimized-member-names=false")
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(npm("johnny-five","2.1.0"))
            }
        }
    }
}


rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "20.0.0"
    // "true" for default behavior
}

mavenPublishing {
    coordinates(
        libs.versions.groupId.get(),
        "johnny-five",
        libs.versions.jfw.get(),
    )
    publishToMavenCentral()
    //  publishToMavenCentral(SonatypeHost.S01) // for publishing through s01.oss.sonatype.org
    if (enableSigning) {
        signAllPublications()
    }
}

publishing {
    publications {
        create<MavenPublication>("default") {
            artifact(tasks["sourcesJar"])
            // artifact(tasks["javadocJar"])

            pom {
                name.set(project.name)
                description.set("Kotlin wrapper for johnny-five")
                url.set("https://github.com/Foso/JohnnyFiveKotlinWrapper")

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://github.com/Foso/JohnnyFiveKotlinWrapper/blob/master/LICENSE.txt")
                    }
                }
                scm {
                    url.set("https://github.com/Foso/JohnnyFiveKotlinWrapper")
                    connection.set("scm:git:git://github.com/Foso/JohnnyFiveKotlinWrapper.git")
                }
                developers {
                    developer {
                        name.set("Jens Klingenberg")
                        url.set("https://github.com/Foso")
                    }
                }
            }
        }
    }

    repositories {
        if (
            hasProperty("sonatypeUsername") &&
            hasProperty("sonatypePassword") &&
            hasProperty("sonatypeSnapshotUrl") &&
            hasProperty("sonatypeReleaseUrl")
        ) {
            maven {
                val url =
                    when {
                        "SNAPSHOT" in version.toString() -> property("sonatypeSnapshotUrl")
                        else -> property("sonatypeReleaseUrl")
                    } as String
                setUrl(url)
                credentials {
                    username = property("sonatypeUsername") as String
                    password = property("sonatypePassword") as String
                }
            }
        }
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().ignoreScripts = false
}