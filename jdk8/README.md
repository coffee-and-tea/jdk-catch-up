## jdk8 sub project

### Catching up changes in Java SE 8, following JEP are listed in original JSR-337: Java SE 8 Release Contents:

- 126	Lambda Expressions & Virtual Extension Methods
- 138	Autoconf-Based Build System
- 160	Lambda-Form Representation for Method Handles
- 161	Compact Profiles
- 162	Prepare for Modularization
- 164	Leverage CPU Instructions for AES Cryptography
- 174	Nashorn JavaScript Engine
- 176	Mechanical Checking of Caller-Sensitive Methods
- 179	Document JDK API Support and Stability
- 142	Reduce Cache Contention on Specified Fields
- 122	Remove the Permanent Generation
- 173	Retire Some Rarely-Used GC Combinations
- 136	Enhanced Verification Errors
- 147	Reduce Class Metadata Footprint
- 148	Small VM
- 171	Fence Intrinsics
- 153	Launch JavaFX Applications
- 101	Generalized Target-Type Inference
- 104	Annotations on Java Types
- 105	DocTree API
- 106	Add Javadoc to javax.tools
- 117	Remove the Annotation-Processing Tool (apt)
- 118	Access to Parameter Names at Runtime
- 120	Repeating Annotations
- 139	Enhance javac to Improve Build Speed
- 172	DocLint
- 103	Parallel Array Sorting
- 107	Bulk Data Operations for Collections
- 109	Enhance Core Libraries with Lambda
- 112	Charset Implementation Improvements
- 119	javax.lang.model Implementation Backed by Core Reflection
- 135	Base64 Encoding & Decoding
- 149	Reduce Core-Library Memory Usage
- 150	Date & Time API
- 155	Concurrency Updates
- 170	JDBC 4.2
- 177	Optimize java.text.DecimalFormat.format
- 178	Statically-Linked JNI Libraries
- 180	Handle Frequent HashMap Collisions with Balanced Trees
- 127	Improve Locale Data Packaging and Adopt Unicode CLDR Data
- 128	BCP 47 Locale Matching
- 133	Unicode 6.2
- 184	HTTP URL Permissions
- 113	MS-SFU Kerberos 5 Extensions
- 114	TLS Server Name Indication (SNI) Extension
- 115	AEAD CipherSuites
- 121	Stronger Algorithms for Password-Based Encryption
- 123	Configurable Secure Random-Number Generation
- 124	Enhance the Certificate Revocation-Checking API
- 129	NSA Suite B Cryptographic Algorithms
- 130	SHA-224 Message Digests
- 131	PKCS#11 Crypto Provider for 64-bit Windows
- 140	Limited doPrivileged
- 166	Overhaul JKS-JCEKS-PKCS12 Keystores
- 185	Restrict Fetching of External XML Resources

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 126 |	Picked     | Lambda Expressions & Virtual Extension Methods                           |
| 138 |	Not picked | JDK build, compiler changes, not language feature change                 |
| 160 |	Not picked | Lambda-Form Representation for Method Handles, support for lambda        |
| 161 |	Not picked | Compact Profiles, Java SE 9 introduce modules, focus on modules catch up |
| 162 |	Not picked | Prepare for Modularization, will catch up modulization later             |
| 164 |	Not picked | Leverage CPU Instructions for AES Cryptography, not language change      |
| 174 |	Not picked | Nashorn JavaScript Engine, JEP 372 removed with JDK15                    |
| 176 |	Not picked | Mechanical Checking of Caller-Sensitive Methods, add @CallerSensitive but not public API |
| 179 |	Not picked | Document JDK API Support and Stability, not API changes                  |
| 142 |	Not picked | Reduce Cache Contention on Specified Fields, virtual machine change, not API changes |
| 122 |	Not picked | Remove the Permanent Generation, not API changes                         |
| 173 |	Not picked | Retire Some Rarely-Used GC Combinations, not API changes                 |
| 136 |	Not picked | Enhanced Verification Errors, not API changes                            |
| 147 |	Not picked | Reduce Class Metadata Footprint, not API changes                         |
| 148 |	Not picked | Small VM, not API changes, see more in modulization                      |
| 171 |	Not picked | Fence Intrinsics, not API changes                                        |
| 153 |	Not picked | Launch JavaFX Applications, desktop application GUI library              |
| 101 |	Picked     | Generalized Target-Type Inference, improvement in Generics               |
| 104 |	Picked     | Annotations on Java Types, improvement on type checkers                  |
| 105 |	Picked     | DocTree API, refresh knowledge on javadoc                                |
| 106 |	Picked     | Add Javadoc to javax.tools, refresh knowledge on javadoc                 |
| 117 |	Not picked | Remove the Annotation-Processing Tool (apt), deprecate tool              |
| 118 |	Picked     | Access to Parameter Names at Runtime, reflect to get param name          |
| 120 |	Picked     | Repeating Annotations, annotation improvement                            |
| 139 |	Not picked | Enhance javac to Improve Build Speed, not API change                     |
| 172 |	Picked     | DocLint, javadoc refresh                                                 |
| 103 |	Picked     | Parallel Array Sorting, learn algo for sorting                           |
| 107 |	Picked     | Bulk Data Operations for Collections, filter/map/reduce functions        |
| 109 |	Picked     | Enhance Core Libraries with Lambda, Lambda improvements                  |
| 112 |	Not picked | Charset Implementation Improvements, performance improvement             |
| 119 |	Picked     | javax.lang.model Implementation Backed by Core Reflection, runtime reflection access |
| 135 |	Picked     | Base64 Encoding & Decoding, refresh base64 knowledge                     |
| 149 |	Not picked | Reduce Core-Library Memory Usage, not API changes                        |
| 150 |	Picked     | Date & Time API, date time lib refresh JSR 310                           |
| 155 |	Picked     | Concurrency Updates, catch up concurrency                                |
| 170 |	Not picked | JDBC 4.2, catch up JDBC 4.3 version later                                |
| 177 |	Not picked | Optimize java.text.DecimalFormat.format, JVM change not API change       |
| 178 | Not picked | Statically-Linked JNI Libraries, inner working on how to load native app |
| 180 |	Not picked / Handle Frequent HashMap Collisions with Balanced Trees, performance change not API change |
| 127 |	Not picked | Improve Locale Data Packaging and Adopt Unicode CLDR Data, load local localization data |
| 128 |	Not picked | BCP 47 Locale Matching, matching language and locale support             |
| 133 |	Not picked | Unicode 6.2, unicode changes                                             |
| 184 |	Not picked | HTTP URL Permissions, will catch up in later version HTTP and HTTP/2     |
| 113 |	Not picked | MS-SFU Kerberos 5 Extensions, no planning to learn Kerberos yet          |
| 114 |	Not Picked | TLS Server Name Indication (SNI) Extension, will catch along with HTTP/2 |
| 115 |	Not picked | AEAD CipherSuites, add new CipherSuites, will catch up later on encryption |
| 121 |	Not picked | Stronger Algorithms for Password-Based Encryption, will catch up encryption as separate topic |
| 123 |	Not picked | Configurable Secure Random-Number Generation, catch up encryption separately |
| 124 |	Not picked | Enhance the Certificate Revocation-Checking API, catch up security and encryption separately |
| 129 |	Not picked | NSA Suite B Cryptographic Algorithms, catch up security and encryption separately |
| 130 |	Not picked | SHA-224 Message Digests, catch up security and encryption separately     |
| 131 |	Not picked | PKCS#11 Crypto Provider for 64-bit Windows, catch up security and encryption separately |
| 140 |	Not picked | Limited doPrivileged, catch up security and encryption separately        |
| 166 |	Not picked | Overhaul JKS-JCEKS-PKCS12 Keystores, catch up security and encryption separately |
| 185 |	Picked     | Restrict Fetching of External XML Resources, catch up on XML processing  |

