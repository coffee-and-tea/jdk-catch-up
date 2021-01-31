## jdk15 sub project

### Catching up changes in Java SE 15, following JEP are listed in original JSR-390: Java SE 15 Release Contents:

- 339:	Edwards-Curve Digital Signature Algorithm (EdDSA)
- 360:	Sealed Classes (Preview)
- 371:	Hidden Classes
- 372:	Remove the Nashorn JavaScript Engine
- 373:	Reimplement the Legacy DatagramSocket API
- 374:	Disable and Deprecate Biased Locking
- 375:	Pattern Matching for instanceof (Second Preview)
- 377:	ZGC: A Scalable Low-Latency Garbage Collector
- 378:	Text Blocks
- 379:	Shenandoah: A Low-Pause-Time Garbage Collector
- 381:	Remove the Solaris and SPARC Ports
- 383:	Foreign-Memory Access API (Second Incubator)
- 384:	Records (Second Preview)
- 385:	Deprecate RMI Activation for Removal

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 339 | Not picked | Edwards-Curve Digital Signature Algorithm (EdDSA), catch up security in separate topic |
| 360 | Picked     | Sealed Classes (Preview)                                                 |
| 371 | Picked     | Hidden Classes                                                           |
| 372 | Not picked | Remove the Nashorn JavaScript Engine, deprecation removal                |
| 373 | Not picked | Reimplement the Legacy DatagramSocket API, replace underline implementation |
| 374 | Not picked | Disable and Deprecate Biased Locking, deprecating                        |
| 375 | Picked     | Pattern Matching for instanceof (Second Preview)                         |
| 377 | Not picked | ZGC: A Scalable Low-Latency Garbage Collector, catch up GC as a separate topic |
| 378 | Picked     | Text Blocks                                                              |
| 379 | Not picked | Shenandoah: A Low-Pause-Time Garbage Collector, catch up GC as a separate topic |
| 381 | Not picked | Remove the Solaris and SPARC Ports, not API change                       |
| 383 | Not picked | Foreign-Memory Access API (Second Incubator), learning when standardized |
| 384 | Picked     | Records (Second Preview)                                                 |
| 385 | Not picked | Deprecate RMI Activation for Removal, deprecation                        |
