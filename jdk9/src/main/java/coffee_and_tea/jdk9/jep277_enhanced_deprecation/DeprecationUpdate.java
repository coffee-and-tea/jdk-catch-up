package coffee_and_tea.jdk9.jep277_enhanced_deprecation;

public class DeprecationUpdate {

    @SuppressWarnings("removal")
    public static void main(String[] args) {
        new DeprecationTagClass();
    }
}

@Deprecated(forRemoval = true, since = "jdk9")
class DeprecationTagClass {

}
