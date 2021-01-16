### JEP 328 Flight Recorder

JEP link: https://openjdk.java.net/jeps/328

#### Learning resource:
- https://openjdk.java.net/jeps/328


#### Practice on:
Flight recorder start, dump and stop, program to read recording data.
- start recording: `jcmd <pid> JFR.start`
- dump to file `jcmd <pid> JFR.dump filename=recording.jfr`
- stop recording `jcmd <pid> JFR.stop`