## jdk9 sub project

### Catching up changes in Java SE 9, following JEP are listed in original JSR-379: Java SE 9 Release Contents:

- 102: Process API Updates
- 110: HTTP 2 Client
- 143: Improve Contended Locking
- 158: Unified JVM Logging
- 165: Compiler Control
- 193: Variable Handles
- 197: Segmented Code Cache
- 199: Smart Java Compilation, Phase Two
- 200: The Modular JDK
- 201: Modular Source Code
- 211: Elide Deprecation Warnings on Import Statements
- 212: Resolve Lint and Doclint Warnings
- 213: Milling Project Coin
- 214: Remove GC Combinations Deprecated in JDK 8
- 215: Tiered Attribution for javac
- 216: Process Import Statements Correctly
- 217: Annotations Pipeline 2.0
- 219: Datagram Transport Layer Security (DTLS)
- 220: Modular Run-Time Images
- 221: Simplified Doclet API
- 222: jshell: The Java Shell (Read-Eval-Print Loop)
- 223: New Version-String Scheme
- 224: HTML5 Javadoc
- 225: Javadoc Search
- 226: UTF-8 Property Files
- 227: Unicode 7.0
- 228: Add More Diagnostic Commands
- 229: Create PKCS12 Keystores by Default
- 231: Remove Launch-Time JRE Version Selection
- 232: Improve Secure Application Performance
- 233: Generate Run-Time Compiler Tests Automatically
- 235: Test Class-File Attributes Generated by javac
- 236: Parser API for Nashorn
- 237: Linux/AArch64 Port
- 238: Multi-Release JAR Files
- 240: Remove the JVM TI hprof Agent
- 241: Remove the jhat Tool
- 243: Java-Level JVM Compiler Interface
- 244: TLS Application-Layer Protocol Negotiation Extension
- 245: Validate JVM Command-Line Flag Arguments
- 246: Leverage CPU Instructions for GHASH and RSA
- 247: Compile for Older Platform Versions
- 248: Make G1 the Default Garbage Collector
- 249: OCSP Stapling for TLS
- 250: Store Interned Strings in CDS Archives
- 251: Multi-Resolution Images
- 252: Use CLDR Locale Data by Default
- 253: Prepare JavaFX UI Controls & CSS APIs for Modularization
- 254: Compact Strings
- 255: Merge Selected Xerces 2.11.0 Updates into JAXP
- 256: BeanInfo Annotations
- 257: Update JavaFX/Media to Newer Version of GStreamer
- 258: HarfBuzz Font-Layout Engine
- 259: Stack-Walking API
- 260: Encapsulate Most Internal APIs
- 261: Module System
- 262: TIFF Image I/O
- 263: HiDPI Graphics on Windows and Linux
- 264: Platform Logging API and Service
- 265: Marlin Graphics Renderer
- 266: More Concurrency Updates
- 267: Unicode 8.0
- 268: XML Catalogs
- 269: Convenience Factory Methods for Collections
- 270: Reserved Stack Areas for Critical Sections
- 271: Unified GC Logging
- 272: Platform-Specific Desktop Features
- 273: DRBG-Based SecureRandom Implementations
- 274: Enhanced Method Handles
- 275: Modular Java Application Packaging
- 276: Dynamic Linking of Language-Defined Object Models
- 277: Enhanced Deprecation
- 278: Additional Tests for Humongous Objects in G1
- 279: Improve Test-Failure Troubleshooting
- 280: Indify String Concatenation
- 281: HotSpot C++ Unit-Test Framework
- 282: jlink: The Java Linker
- 283: Enable GTK 3 on Linux
- 284: New HotSpot Build System
- 285: Spin-Wait Hints
- 287: SHA-3 Hash Algorithms
- 288: Disable SHA-1 Certificates
- 289: Deprecate the Applet API
- 290: Filter Incoming Serialization Data
- 291: Deprecate the Concurrent Mark Sweep (CMS) Garbage Collector
- 292: Implement Selected ECMAScript 6 Features in Nashorn
- 294: Linux/s390x Port
- 295: Ahead-of-Time Compilation
- 297: Unified arm32/arm64 Port
- 298: Remove Demos and Samples
- 299: Reorganize Documentation

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 102 | Picked     | Process API Updates                                                      |
| 110 | Not Picked | HTTP 2 Client, incubating module, will catch up with jep 321 once become standard |
| 143 | Not picked | Improve Contended Locking, performance improvement, not API change       |
| 158 | Picked     | Unified JVM Logging                                                      |
| 165 | Not picked | Compiler Control, not API changes                                        |
| 193 | Picked     | Variable Handles                                                         |
| 197 | Not picked | Segmented Code Cache, JVM and compiler change not API change             |
| 199 | Not picked | Smart Java Compilation, Phase Two, compiler change                       |
| 200 | Picked     | The Modular JDK                                                          |
| 201 | Picked     | Modular Source Code, catch up modularization for Java                    |
| 211 | Not picked | Elide Deprecation Warnings on Import Statements, not warning for import  |
| 212 | Not picked | Resolve Lint and Doclint Warnings, not API changes                       |
| 213 | Picked     | Milling Project Coin, small API changes                                  |
| 214 | Not picked | Remove GC Combinations Deprecated in JDK 8, catch up dedicate topic for GC |
| 215 | Not picked | Tiered Attribution for javac, not API change                             |
| 216 | Not picked | Process Import Statements Correctly, not API change                      |
| 217 | Not picked | Annotations Pipeline 2.0, javac change                                   |
| 219 | Not picked | Datagram Transport Layer Security (DTLS), catch up security in separate topic |
| 220 | Picked     | Modular Run-Time Images                                                  |
| 221 | Not picked | Simplified Doclet API, updates on inner working of how javadoc is generated | 
| 222 | Picked     | jshell: The Java Shell (Read-Eval-Print Loop)                            |
| 223 | Picked     | New Version-String Scheme                                                |
| 224 | Not picked | HTML5 Javadoc, generate javadoc in html5 format                          |
| 225 | Not picked | Javadoc Search, generate a search box in generated javadoc               |
| 226 | Not picked | UTF-8 Property Files, property file encoding change to better support special characters |
| 227 | Not picked | Unicode 7.0, unicode support                                             |
| 228 | Picked     | Add More Diagnostic Commands                                             |
| 229 | Not picked | Create PKCS12 Keystores by Default, catch up security separately         |
| 231 | Not picked | Remove Launch-Time JRE Version Selection, removing feature               |
| 232 | Not picked | Improve Secure Application Performance, performance improvement, not API change |
| 233 | Not picked | Generate Run-Time Compiler Tests Automatically, compiler related, not API change |
| 235 | Not picked | Test Class-File Attributes Generated by javac, compiler related, not API change |
| 236 | Not picked | Parser API for Nashorn, Nashorn is deprecated in later SE version        |
| 237 | Not picked | Linux/AArch64 Port, CPU related JVM, compiler change                     |
| 238 | Not picked | Multi-Release JAR Files, not API changes allow byte code of different version |
| 240 | Not picked | Remove the JVM TI hprof Agent, no API change                             |
| 241 | Not picked | Remove the jhat Tool, no API change                                      |
| 243 | Not picked | Java-Level JVM Compiler Interface, experimental compiler                 |
| 244 | Not picked | TLS Application-Layer Protocol Negotiation Extension, catch up security separately |
| 245 | Not picked | Validate JVM Command-Line Flag Arguments, not API change                 |
| 246 | Not picked | Leverage CPU Instructions for GHASH and RSA, not API change              |
| 247 | Not picked | Compile for Older Platform Versions, javac to compile source code of lower version using option -source, -target, --release |
| 248 | Not picked | Make G1 the Default Garbage Collector, not API change                    |
| 249 | Not picked | OCSP Stapling for TLS, catch up security separately                      |
| 250 | Not picked | Store Interned Strings in CDS Archives, not API change, memory management improvement for String |
| 251 | Not picked | Multi-Resolution Images, awt graphic package update                      |
| 252 | Picked     | Use CLDR Locale Data by Default                                          |
| 253 | Not Picked | Prepare JavaFX UI Controls & CSS APIs for Modularization, JavaFX removed from SE in later version |
| 254 | Not picked | Compact Strings, memory management for Strings, not API change           |
| 255 | Not picked | Merge Selected Xerces 2.11.0 Updates into JAXP, no change to JAXP API    |
| 256 | Not picked | BeanInfo Annotations, mostly used in graphic components to provide information on attributes of a Bean |
| 257 | Not picked | Update JavaFX/Media to Newer Version of GStreamer, JavaFX removed from SE in later version |
| 258 | Not picked | HarfBuzz Font-Layout Engine, font format, not core API                   |
| 259 | Picked     | Stack-Walking API                                                        |
| 260 | Picked     | Encapsulate Most Internal APIs                                           |
| 261 | Picked     | Module System                                                            |
| 262 | Not picked | TIFF Image I/O, image processing api                                     |
| 263 | Not picked | HiDPI Graphics on Windows and Linux, UI changes                          |
| 264 | Picked     | Platform Logging API and Service                                         |
| 265 | Not picked | Marlin Graphics Renderer, not API change                                 |
| 266 | Picked     | More Concurrency Updates                                                 |
| 267 | Not picked | Unicode 8.0, unicode support not core API change                         |
| 268 | Picked     | XML Catalogs                                                             |
| 269 | Picked     | Convenience Factory Methods for Collections                              |
| 270 | Not picked | Reserved Stack Areas for Critical Sections, not API change               |
| 271 | Not picked | Unified GC Logging, catch up GC as separate topic                        |
| 272 | Not picked | Platform-Specific Desktop Features, AWT changes                          |
| 273 | Not picked | DRBG-Based SecureRandom Implementations, catch up security as separate topic |
| 274 | Picked     | Enhanced Method Handles                                                  |
| 275 | Picked     | Modular Java Application Packaging                                       |
| 276 | Not picked | Dynamic Linking of Language-Defined Object Models, Not API change        |
| 277 | Picked     | Enhanced Deprecation                                                     |
| 278 | Not picked | Additional Tests for Humongous Objects in G1, catch up GC in separate topic |
| 279 | Not picked | Improve Test-Failure Troubleshooting, not API change                     |
| 280 | Not picked | Indify String Concatenation, bytecode change not related to api          |
| 281 | Not picked | HotSpot C++ Unit-Test Framework, not API change                          |
| 282 | Picked     | jlink: The Java Linker                                                   |
| 283 | Not picked | Enable GTK 3 on Linux, not API change                                    |
| 284 | Not picked | New HotSpot Build System, not API change                                 |   
| 285 | Picked     | Spin-Wait Hints                                                          |
| 287 | Not picked | SHA-3 Hash Algorithms, catch up security in separate topic               |
| 288 | Not picked | Disable SHA-1 Certificates, catch up security in separate topic          |
| 289 | Not picked | Deprecate the Applet API, deprecation                                    |
| 290 | Not picked | Filter Incoming Serialization Data, security related topic               |
| 291 | Not picked | Deprecate the Concurrent Mark Sweep (CMS) Garbage Collector, deprecation |
| 292 | Not picked | Implement Selected ECMAScript 6 Features in Nashorn, Nashorn deprecated in later SE version |
| 294 | Not picked | Linux/s390x Port, not API change                                         |
| 295 | Not picked | Ahead-of-Time Compilation, experimental feature                          |
| 297 | Not picked | Unified arm32/arm64 Port, not API change                                 |
| 298 | Not picked | Remove Demos and Samples, not API change                                 |
| 299 | Not picked | Reorganize Documentation, generated javadoc structure change             |

https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-EF16133E-F5C2-4DEB-AA4E-A0C73E92E2C3