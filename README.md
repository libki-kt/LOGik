# LOGik

[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg)](code_of_conduct.md)

the code of conduct is made by the [Contributor covenant project](https://www.contributor-covenant.org/).

Simple and customizable logging library for kotlin

features:
- [X] Logger class
- [X] Logger singleton
- [ ] Time format localization for ConsoleLoggingBehaviour
- [ ] Logger holders–allowing to pre-define logging information
- [ ] Automatic loggerables (interfaces with logging functions) generation
- [X] add `internal` modifier to stuff that shouldn't be accessible to a normal user

Version: **1**

*the library is mostly alpha, everything is annotated with the appropriate stability status

= **40%**

# THIS LIBRARY IS USING **MORDANT** → https://github.com/ajalt/mordant, it is using apache 2.0, and you need to include a notice
# THIS LIBRARY IS USING **KOTLINX.DATETIME** → https://github.com/Kotlin/kotlinx-datetime, it is using apache 2.0, and you need to include a notice
if you see any problem for ex.
with licensing, or a security vulnerability, then message me via matrix → rebok@matrix.org.

Platforms:
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

= **38,46%**

**[P]** —planned as of right now

*1—partial support, blocked by another library.

WARNING!: kotlin native requires you to include
https://kotlinlang.org/docs/native-binary-licenses.html
in the final binaries

*no apple targets are planned to be supported, as
I don't own any Apple hardware, feel free to
help with the port to the apple platforms.