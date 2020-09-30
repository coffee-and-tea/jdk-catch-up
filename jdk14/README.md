## jdk14 sub project

### Catching up changes in Java SE 14, following JEP are listed in original JSR-389: Java SE 14 Release Contents:

- 305:	Pattern Matching for instanceof (Preview)
- 343:	Packaging Tool (Incubator)
- 345:	NUMA-Aware Memory Allocation for G1
- 349:	JFR Event Streaming
- 352:	Non-Volatile Mapped Byte Buffers
- 358:	Helpful NullPointerExceptions
- 359:	Records (Preview)
- 361:	Switch Expressions (Standard)
- 362:	Deprecate the Solaris and SPARC Ports
- 363:	Remove the Concurrent Mark Sweep (CMS) Garbage Collector
- 364:	ZGC on macOS
- 365:	ZGC on Windows
- 366:	Deprecate the ParallelScavenge + SerialOld GC Combination
- 367:	Remove the Pack200 Tools and API
- 368:	Text Blocks (Second Preview)
- 370:	Foreign-Memory Access API (Incubator)

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 305 | Not picked | Pattern Matching for instanceof (Preview), catch up in SE 15 with second preview |
| 343 |	Picked     | Packaging Tool (Incubator)                                               |
| 345 | Not picked | NUMA-Aware Memory Allocation for G1, catch up GC in separate topic       |
| 349 | Picked     | JFR Event Streaming                                                      |
| 352 | Picked     | Non-Volatile Mapped Byte Buffers                                         |
| 358 | Picked     | Helpful NullPointerExceptions                                            |
| 359 | Not picked | Records (Preview), catch up in SE 15 with second preview                 |
| 361 | Picked     | Switch Expressions (Standard)                                            |
| 362 | Not picked | Deprecate the Solaris and SPARC Ports, deprecation                       |
| 363 | Not picked | Remove the Concurrent Mark Sweep (CMS) Garbage Collector, catch up GC in separate topic |
| 364 | Not picked | ZGC on macOS, catch up GC in separate topic                              |
| 365 | Not picked | ZGC on Windows, catch up GC in separate topic                            |
| 366 | Not picked | Deprecate the ParallelScavenge + SerialOld GC Combination, catch up GC in separate topic |
| 367 | Not picked | Remove the Pack200 Tools and API, deprecation                            |
| 368 | Not picked | Text Blocks (Second Preview), catch up in SE 15                          |
| 370 | Not picked | Foreign-Memory Access API (Incubator), catch up in SE 15 with second preview |
