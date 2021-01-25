### JEP 341 Default CDS Archives

JEP link: https://openjdk.java.net/jeps/341

#### Learning resource:
- https://openjdk.java.net/jeps/341
- https://dzone.com/articles/39-new-features-and-apis-in-jdk-12

#### Practice on:
Command line execution to list class to archive
```
java -Xshare:off -XX:+UseAppCDS -XX:DumpLoadedClassList=hello.lst -cp build/classes/java/main coffee_and_tea.jdk12.jep341_default_cds_archives.CDS 
```

Command line execution to auto share CDS archives (a folder created javasharedresources for this)
```
java -Xshare:auto -XX:+UseAppCDS -XX:DumpLoadedClassList=hello.lst -cp build/classes/java/main coffee_and_tea.jdk12.jep341_default_cds_archives.CDS
```
