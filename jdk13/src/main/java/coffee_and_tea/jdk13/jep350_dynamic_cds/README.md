### JEP 350 Dynamic CDS Archive

JEP link: https://openjdk.java.net/jeps/350

#### Learning resource:
- https://openjdk.java.net/jeps/350

#### Practice on:
From jep, although not able to replicate this in jdk15
```
Archiving classes at exit
A shared archive is dynamically created when an application exits if the -XX:ArchiveClassesAtExit option is specified.

The dynamically-generated archive is created on top of the default system archive packaged with the running JDK image. A separate top-layer archive file is generated for each application. The user can specify the filename of the dynamic archive name as the argument to the -XX:ArchiveClassesAtExit option. For example, the following command creates hello.jsa:

% bin/java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
To run the same application using this dynamic archive:

% bin/java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello
```

