# LOGik

Simple and customizable logging library for kotlin

features:
- [X] Logger class
- [X] Logger singleton
- [ ] Time format localization for ConsoleLoggingBehaviour
- [ ] Logger handler
- [ ] add `internal` modifier to stuff that shouldn't be accessible to a normal user

Version: **1**

*the library is mostly alpha, everything is annotated with the appropriate stability status

= **0%**

# THIS LIBRARY IS USING **MORDANT** -> https://github.com/ajalt/mordant, it's using apache 2.0 and you need to include a notice
# THIS LIBRARY IS USING **KOTLINX.DATETIME** -> https://github.com/Kotlin/kotlinx-datetime, it's using apache 2.0 and you need to include a notice
if you see any problem here then message me via matrix -> rebok@matrix.org

platforms:
- [ ] K/N linuxArm64 **[P]** *1
- [X] K/N linuxX64 **[P]**
- [X] K/N mingwX64 **[P]**
- [ ] K/N macosX64
- [ ] K/N macosArm64
- [ ] K/N iosX64
- [ ] K/N iosArm64
- [X] K/JVM **[P]**
- [X] K/JS browser **[P]**
- [X] K/JS node **[P]**
- [ ] K/WASM JS
- [ ] K/WASM WASI
- [ ] Android

= **0%**

**[P]** — planned as of right now
*1 — partial support, blocked by another library

WARNING!: kotlin native requires you to include
https://kotlinlang.org/docs/native-binary-licenses.html
in the final binaries

*no apple targets are planned to be supported, as
I don't own any apple hardware, feel free to
help with the port to the apple platforms