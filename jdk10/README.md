## jdk10 sub project

### Catching up changes in Java SE 10, following JEP are listed in original JSR-383: Java SE 10 Release Contents:

- 286: Local-Variable Type Inference
- 296: Consolidate the JDK Forest into a Single Repository
- 304: Garbage-Collector Interface
- 307: Parallel Full GC for G1
- 310: Application Class-Data Sharing
- 312: Thread-Local Handshakes
- 313: Remove the Native-Header Generation Tool (javah)
- 314: Additional Unicode Language-Tag Extensions
- 316: Heap Allocation on Alternative Memory Devices
- 317: Experimental Java-Based JIT Compiler
- 319: Root Certificates
- 322: Time-Based Release Versioning

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 286 | Picked     | Local-Variable Type Inference                                            |
| 296 | Not picked | Consolidate the JDK Forest into a Single Repository, not API change      |
| 304 | Not picked | Garbage-Collector Interface, not API change                              |
| 307 | Not picked | Parallel Full GC for G1, not API change                                  |
| 310 | Not picked | Application Class-Data Sharing, application sharing data when start up   |
| 312 | Not picked | Thread-Local Handshakes, not API change                                  |
| 313 | Not picked | Remove the Native-Header Generation Tool (javah), javah removal          |
| 314 | Not picked | Additional Unicode Language-Tag Extensions, unicode support              |
| 316 | Not picked | Heap Allocation on Alternative Memory Devices                            |
| 317 | Not picked | Experimental Java-Based JIT Compiler, experimental feature               |
| 319 | Not picked | Root Certificates, keystore update                                       |
| 322 | Picked     | Time-Based Release Versioning                                            |
