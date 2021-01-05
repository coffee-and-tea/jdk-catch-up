package coffee_and_tea.jdk9.jep213_small_api_enhancement;

public interface InterfaceWithPrivateMethod {

    void print(String s);

    default void reversePrint(String s) {
        this.print(reserve(s));
    }

    // allow private method in interface now, easier for functional interface implementations
    private String reserve(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
