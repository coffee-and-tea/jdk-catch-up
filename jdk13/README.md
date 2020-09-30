## jdk13 sub project

### Catching up changes in Java SE 13, following JEP are listed in original JSR-388: Java SE 13 Release Contents:

- 350:	Dynamic CDS Archives
- 351:	ZGC: Uncommit Unused Memory
- 353:	Reimplement the Legacy Socket API
- 354:	Switch Expressions (Preview)
- 355:	Text Blocks (Preview)

### Not all of changes will be studied in details, only priority ones will be studied in this project. 
### Here's the notes and reasoning for the selection:

| JEP | Selection  | Reason                                                                   |
| --- | ---------- | ------------------------------------------------------------------------ |
| 350 | Picked     | Dynamic CDS Archives                                                     |
| 351 | Not picked | ZGC: Uncommit Unused Memory, catch up GC in separate topic               | 
| 353 | Picked     | Reimplement the Legacy Socket API                                        |
| 354 | Not picked | Switch Expressions (Preview), catch up in later version                  |
| 355 | Not picked | Text Blocks (Preview), catch up in later version                         |