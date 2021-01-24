## jdk12 sub project

### Catching up changes in Java SE 12, following JEP are listed in original JSR-386: Java SE 12 Release Contents:

- 189:	Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)
- 230:	Microbenchmark Suite
- 325:	Switch Expressions (Preview)
- 334:	JVM Constants API
- 340:	One AArch64 Port, Not Two
- 341:	Default CDS Archives
- 344:	Abortable Mixed Collections for G1
- 346:	Promptly Return Unused Committed Memory from G1

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 189 | Not picked | Shenandoah: A Low-Pause-Time Garbage Collector (Experimental), catch up GC in separate topic |
| 230 | Picked     | Microbenchmark Suite                                                     |
| 325 | Not picked | Switch Expressions (Preview), catch in jdk14 standard version            |
| 334 |	Picked     | JVM Constants API                                                        |
| 340 | Not picked | One AArch64 Port, Not Two, not API change                                |              
| 341 | Picked     | Default CDS Archives                                                     |
| 344 | Not picked | Abortable Mixed Collections for G1, catch up GC in separate topic        |
| 346 | Not picked | Promptly Return Unused Committed Memory from G1                          |
