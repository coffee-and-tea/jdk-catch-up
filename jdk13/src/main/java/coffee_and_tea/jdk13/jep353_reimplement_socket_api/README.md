### JEP 353 Reimplement Socket API

JEP link: https://openjdk.java.net/jeps/353

#### Learning resource:
- https://openjdk.java.net/jeps/353

#### Practice on:
java.net.Socket and java.net.ServerSocket API delegates all socket operations to
implementation class. This jep will use NioSocketImpl instead of existing PlainSocketImpl
