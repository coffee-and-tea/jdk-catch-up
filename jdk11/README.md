## jdk11 sub project

### Catching up changes in Java SE 11, following JEP are listed in original JSR-384: Java SE 11 Release Contents:

- 181: Nest-Based Access Control
- 309: Dynamic Class-File Constants
- 315: Improve Aarch64 Intrinsics
- 318: Epsilon: A No-Op Garbage Collector
- 320: Remove the Java EE and CORBA Modules
- 321: HTTP Client (Standard)
- 323: Local-Variable Syntax for Lambda Parameters
- 324: Key Agreement with Curve25519 and Curve448
- 327: Unicode 10
- 328: Flight Recorder
- 329: ChaCha20 and Poly1305 Cryptographic Algorithms
- 330: Launch Single-File Source-Code Programs
- 331: Low-Overhead Heap Profiling
- 332: Transport Layer Security (TLS) 1.3
- 333: ZGC: A Scalable Low-Latency Garbage Collector(Experimental)
- 335: Deprecate the Nashorn JavaScript Engine
- 336: Deprecate the Pack200 Tools and API

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 181 | Picked     | Nest-Based Access Control                                                |
| 309 | Not picked | Dynamic Class-File Constants, JVM featuer, not API change                |
| 315 | Not picked | Improve Aarch64 Intrinsics, not API change                               |
| 318 | Not picked | Epsilon: A No-Op Garbage Collector, catch up GC in separate topic        |
| 320 | Not picked | Remove the Java EE and CORBA Modules, deprecation removal                |
| 321 | Picked     | HTTP Client (Standard)                                                   |
| 323 | Picked     | Local-Variable Syntax for Lambda Parameters                              |
| 324 | Not picked | Key Agreement with Curve25519 and Curve448, catch up security in separate topic |
| 327 | Not picked | Unicode 10, unicode support                                              |
| 328 | Picked     | Flight Recorder                                                          |
| 329 | Not picked | ChaCha20 and Poly1305 Cryptographic Algorithms, catch up security in separate topic |
| 330 | Picked     | Launch Single-File Source-Code Programs                                  |
| 331 | Picked     | Low-Overhead Heap Profiling                                              |
| 332 | Not picked | Transport Layer Security (TLS) 1.3, catch up security in separate topic  |
| 333 | Not picked | ZGC: A Scalable Low-Latency Garbage Collector(Experimental), catch up GC in separate topic |
| 335 | Not picked | Deprecate the Nashorn JavaScript Engine, deprecation                     |
| 336 | Not picked | Deprecate the Pack200 Tools and API                                      |
