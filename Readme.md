# JohnnyFiveKotlinWrapper
[![Maven Central](https://img.shields.io/maven-central/v/de.jensklingenberg.kotlin-wrappers/johnny-five)](https://central.sonatype.com/artifact/de.jensklingenberg.kotlin-wrappers/johnny-five)
<p align="center">
  <img src ="https://github.com/Foso/JohnnyFiveKotlinWrapper/blob/main/docs/arduino2.jpg"  />
</p>

## Introduction
For a hobby project with my Arduino, i tried to use [Johnny-Five](https://johnny-five.io/). Because i wanted to use Kotlin, i created some KotlinJs wrapper.

The wrappers are not 100% complete, because i can't test all components. 
These are some components that i tried:
- Piezo
- Servo
- Led
- Button

When you have ideas for improvements, please write a GitHub issue.

## Show some :heart: and star the repo to support the project

[![GitHub stars](https://img.shields.io/github/stars/Foso/JohnnyFiveKotlinWrapper.svg?style=social&label=Star)](https://github.com/Foso/JohnnyFiveKotlinWrapper) [![Twitter Follow](https://img.shields.io/twitter/follow/jklingenberg_.svg?style=social)](https://twitter.com/jklingenberg_)

# How to use
1) Prepare your Board
   
   You need to install StandardFirmataPlus firmware to your board.
   
   Check the johnny-five [documentation](https://johnny-five.io/platform-support/) for more information

   Here is the instruction for Arduino:
   * Install and open Arduino IDE
   * Verify correct port and board
   * Navigate to File > Examples > Firmata > StandardFirmataPlus
   * Load sketch onto board.
   * If the upload was successful, the board is now prepared and you can close the Arduino IDE.

3) Create a new KotlinJS Project with NodeJs
   
```kotlin
kotlin {
   js(IR) {
         binaries.executable()
         nodejs {}
       }
   
       sourceSets {
           val jsMain by getting {
               dependencies {
                   implementation("de.jensklingenberg.kotlin-wrappers:johnny-five:0.8.3")
               }
           }
       }
   }
}
```

You also need to add this to your build.gradle.kts, otherwise you will get compile errors: "Error: Could not locate the bindings file"
```kotlin
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().ignoreScripts = false
}
```

3) Create a new Kotlin file and write your code
```kotlin
fun main() {
   val LED_BUILTIN = 13
   val board = Board()

   board.onReady {
      println("READY")
      val led = Led(LED_BUILTIN)

      led.blink()

      onExit {
         println("EXIT")
         led.off()
      }
   }
}
```

4) You can then run build to compile the code
```shell
./gradlew build
```

5) You will find the compiled code in your build folder
e.g. for the demo (https://github.com/Foso/JohnnyFiveKotlinWrapper/tree/main/demo) project it would be ./build/compileSync/js/main/productionExecutable/kotlin/demo

Use Node to run the compiled code:
```shell
node ./build/compileSync/js/main/productionExecutable/kotlin/demo
```
You should see something like this in your terminal:
<p align="center">
  <img src ="https://github.com/Foso/JohnnyFiveKotlinWrapper/blob/main/docs/run.png"  />
</p>

   ## 👷 Development Project Structure
 	
* <kbd>wrapper</kbd> - contains the KotlinJs wrappers for johnny-five
* <kbd>demo</kbd> - Demo project using johnny-five with Kotlin/JS
