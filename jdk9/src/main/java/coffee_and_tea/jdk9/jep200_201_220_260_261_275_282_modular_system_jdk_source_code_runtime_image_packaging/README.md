### JEP 200, 201, 220, 260, 261, 275, 282 Modular related changes

JEP link: 
- https://openjdk.java.net/jeps/200
- https://openjdk.java.net/jeps/201
- https://openjdk.java.net/jeps/220
- https://openjdk.java.net/jeps/260
- https://openjdk.java.net/jeps/261
- https://openjdk.java.net/jeps/275
- https://openjdk.java.net/jeps/282

#### Learning resource:
- https://openjdk.java.net/jeps/200
- https://openjdk.java.net/jeps/201
- https://openjdk.java.net/jeps/220
- https://openjdk.java.net/jeps/260
- https://openjdk.java.net/jeps/261
- https://openjdk.java.net/jeps/275
- https://openjdk.java.net/jeps/282
- https://bugs.openjdk.java.net/secure/attachment/72525/jdk.png
- https://www.oracle.com/corporate/features/understanding-java-9-modules.html
- http://openjdk.java.net/projects/jigsaw/quick-start
- https://docs.gradle.org/current/samples/sample_java_modules_multi_project.html
- https://www.baeldung.com/java-9-modularity

#### Practice on:
Reorganized java into different modulues, especially jdk related code source are separated from APIs.

Jep201 focus on reorganize jdk source code into modular structure. 
Change current structured as `src/{share, $os}/{class, native}/$PACKAGE/*.{java, c, h, cpp, hpp}` into
`src/$MODULE/{shre, $os}/{class, native}/$PACKAGE/*.{java, c, h, cpp, hpp}`.

Jep220 restructured runtime image, especially removed rt.jar and tools.jar. 
Created new jrt URL `jrt:/[$MODULE[/$PATH]]` for example: `jrt:/java.base/java/lang/Class.class`.

Jep260 encapsulate most internal APIs, to use encapsulated APIs: compile with `javac --add-exports` and 
run with `java --illegal-access=permit`.

Jep261 introduces new command line options `--add-modules`, `--limit-modules` for `java` and `javac`
Also introduce jmod files to package modules, which can only be used in compile and link time (mainly package jdk).

Jep275 update `javapackager` updates for module system

Jep282 introduce jlink tool to assemble and optimize modules and dependencies into a custom runtime-image.

- create module depend on another module
- replace log module logger with logback implementation (ServiceLoader example)

See module project (https://docs.gradle.org/current/samples/sample_java_modules_multi_project.html) for demo, module demo will not fit in a package structure.
