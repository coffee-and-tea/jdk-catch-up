### JEP 341 Default CDS Archives

JEP link: https://openjdk.java.net/jeps/341

#### Learning resource:
- https://openjdk.java.net/jeps/341
- https://dzone.com/articles/39-new-features-and-apis-in-jdk-12

#### Practice on:
From dzone article, not have no observed classes.jsa file generated under jdk12
```
Class Data Sharing (CDS) used to be a commercial feature in the Oracle JDK. 
With the recent move, completed in JDK 11, to eliminate all functional 
differences between the Oracle JDK and the OpenJDK, this is now included in OpenJDK.

To use CDS, an archive is required that has been generated for classes 
that are loaded when an application starts. In JDK 12, for 64-bit platforms, 
there is now a classes.jsa file in the lib/server directory. 
This is the CDS archive for the “default classes.” I assume this means all 
public classes in the JDK modules; I couldn’t find a way to unpack this to check. 
Since CDS is turned on by default, equivalent to the  -Xshare:auto option on the command line, 
users will benefit from improved startup time for applications from this.
```