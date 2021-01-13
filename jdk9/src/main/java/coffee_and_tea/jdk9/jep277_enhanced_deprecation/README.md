### JEP 277 Enhanced deprecation

JEP link: https://openjdk.java.net/jeps/277

#### Learning resource:
- https://openjdk.java.net/jeps/277

#### Practice on:
@Deprecated provides 2 methods:
- forRemoval() which returns a boolean value to indicate if marked element is for future removal
- since() which returns a String for which version or release of the element is deprecated
 
@SuppressWarnings also updated, for deprecations with forRemove() returns true to suppress the warning needs to use "removal"