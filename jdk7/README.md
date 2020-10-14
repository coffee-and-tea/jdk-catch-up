## coffee_and_tea.jdk7 sub project

### Catching up changes in Java SE 7, following JSR are listed in original JSR-336: Java SE 7 Release Contents:

- JSR 203: More New I/O APIs for the Java Platform ("NIO.2")
- JSR 292: Supporting Dynamically Typed Languages on the Java Platform
- JSR 334: Small Enhancements to the Java Programming Language (OpenJDK Project Coin)
- JSR 260: Javadoc Tag Technology Update
- JSR 295: Beans Binding
- JSR 296: Swing Application Framework
- JSR 305: Annotations for Software Defect Detection
- JSR 308: Annotations on Java Types
- JSR 310: Date and Time API
- JSR 901: Java Language Specification — Maintenance Review to incorporate fixes since Java SE 5.0 and changes from the above JSRs
- JSR 924: JVM Specification — Maintenance Review to incorporate changes made in Java SE 6.0 and JSR 292
- Java SE APIs — Maintenance Review to incorporate changes made by routine maintenance and small-scale enhancement
- JSR 199: Java Compiler API
- JSR 206: Java API for XML Processing (JAXP)
- JSR 222: Java Architecture for XML Binding (JAXB)
- JSR 224: Java API for XML-Based Web Services (JAX-WS)
- JSR 269: Pluggable Annotation-Processing API
- In addition to the JSRs listed above, a number of smaller enhancements are planned:
    * Thread-safe concurrent class loaders
    * Unicode 6.0
    * Enhanced locale support (IETF BCP 47 and UTR 35)
    * TLS 1.2
    * Elliptic-curve cryptography
    * JDBC 4.1
    * Translucent and shaped windows
    * Heavyweight/lightweight component mixing
    * Swing Nimbus look-and-feel
    * Swing JLayer component

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JSR     | Selection  | Reason                                                                   |
| ------- | ---------- | ------------------------------------------------------------------------ |
| JSR 203 | Picked     | Catch up on  New IO package                                              |
| JSR 292 | Not picked | Prep work for lambda express, will catch up lambda express later         |
| JSR 334 | Picked     | String in switch, try with resources and other improvements              |
| JSR 260 | Not picked | JSR withdraw                                                             |
| JSR 295 | Not picked | JSR withdraw                                                             |
| JSR 296 | Not picked | JSR withdraw                                                             |
| JSR 305 | Not picked | JSR dormant                                                              |
| JSR 308 | Not picked | Annotations on Java Types, catch up with JDK8                            |
| JSR 310 | Not picked | Improved Date and Time API features, catch up in JDK8                    | 
| JSR 901 | Not picked | JSR for maintenance                                                      |
| JSR 924 | Not picked | JSR for maintenance                                                      |
| JSR 199 | Not picked | JSR for maintenance                                                      |
| JSR 206 | Not picked | JSR withdraw                                                             |
| JSR 222 | Not picked | Java SE 11 removed JAXB, obsolete module                                 |
| JSR 224 | Not picked | Java SE 11 removed JAX-WS module, considering this as Java EE learning path | 
| JSR 269 | Not picked | Annotation, catch up with JDK8                                           |
| Other   | Not picked | Features not including major language changes                            |

