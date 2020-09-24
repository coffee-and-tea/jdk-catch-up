# jdk-catch-up
Project to catch up Java SE API changes from OpenJDK Java SE 6 specification until the latest version.
Limit to API changes only, may discuss or research some of JVM inner changes as well if it's critical to language itself
like important GC changes.

Environment set up:
- sdkman: https://sdkman.io/ for managing JDK versions in the project
- gradle: https://gradle.org/ for building project as needed
- IntilliJ IDEA: https://www.jetbrains.com/idea/ for development enviroment

Methodology:
- Sub projects will be create for each major Java SE version
- For each major Java SE version, original create package structure base on original JSR 