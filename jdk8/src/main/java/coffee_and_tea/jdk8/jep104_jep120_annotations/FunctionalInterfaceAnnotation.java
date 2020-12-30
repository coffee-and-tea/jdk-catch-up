package coffee_and_tea.jdk8.jep104_jep120_annotations;

public class FunctionalInterfaceAnnotation {

    public static void main(String[] args) {
        Functional functional = () -> {
            System.out.println("Signal abstract function interface is functional");
        };
        functional.doSomething();
        functional.run();
        Functional.staticMethod();
    };
}

@FunctionalInterface
interface Functional {
    void doSomething();

    default void run() {
        doSomething();
    }

    static void staticMethod(){
        System.out.println("static method");
    }
}
