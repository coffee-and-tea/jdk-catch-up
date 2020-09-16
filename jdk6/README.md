## jdk6 sub project

Catching up changes in Java SE 6, following JSR are listed in original JSR-270: Java SE 6 Release Content:

- JSR 105: XML Digital Signature
- JSR 199: Java Compiler API
- JSR 202: Java Class File Specification Update
- JSR 221: JDBC 4.0
- JSR 222: JAXB 2.0
- JSR 223: Scripting for the Java Platform
- JSR 224: JAX-RPC 2.0
- JSR 260: Javadoc Tag Update
- JSR 268: Java Smart Card I/O API
- JSR 269: Pluggable Annotation Processing API

Not all of changes will be studied in details, only priority ones will be studied in this project. 
Here's the notes and reasoning for the selection:

- JSR 105: XML Digital Signature: Not picked, since current trend using JWT for web encryption
- JSR 199: Java Compiler API: Not picked, Java Compiler API changes mostly in javax.tools package
- JSR 202: Java Class File Specification Update: Not picked, 
            changes related to class file verification(split into 2 phases), 
            increase size limit on class file, class literals, adding additional class file attributes and bit flags 
- JSR 221: JDBC 4.0: Not picked, implements JDBC 4.0 with driver factory, connnection management improvement, etc...
            latest update for JDBC as for today is JDBC 4.3 in Java SE version 9, will catch up the latest version
- JSR 222: JAXB 2.0: Not picked, Java SE 11 removed JAXB, obsolete module
- JSR 223: Scripting for the Java Platform: Not picked, JSR withdrawn
- JSR 224: JAX-RPC 2.0: Not picked, Java SE 11 removed JAX-WS module, considering this as Java EE learning path 
- JSR 260: Javadoc Tag Update: Not picked, JSR withdrawn
- JSR 268: Java Smart Card I/O API: Not picked, card and card terminal specific domain implementation, 
            not focused for initial Java SE catch up
- JSR 269: Pluggable Annotation Processing API: Picked, even though annotation is introduced with Java SE 5,
            it's a major language improvement, probably @Test is the most used annotation that I could think of.
            It's good playground to understand reflection, also different retention and target for annotation.
 
 
