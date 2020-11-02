package coffee_and_tea.jdk8.jep126_lambda;

public class DefaultStaticMethod {

    public static void main(String[] args) {
        DefaultStaticInterface helloWorldInterface = (x) -> " from " + x;

        String hello = helloWorldInterface.greeting("Wei");

        System.out.println(hello);

        ImplementationClassOfDefaultStaticInterface hiClass =
                new ImplementationClassOfDefaultStaticInterface();

        String hi = hiClass.greeting("Wei");

        System.out.println(hi);

        ImplementationInterfaceOfDefaultStaticInterface afternoon =
                (x) -> "Afternoon " + x;

        System.out.println(afternoon.greeting("Wei"));

        System.out.println(DefaultStaticInterface.world());
    }
}

interface DefaultStaticInterface {

    String update(String someone);

    // default method will be used if no implementation is provided
    default String greeting(String someone){
        return world() + update(someone);
    }

    static String world(){
        return "Hello World";
    }
}

interface ImplementationInterfaceOfDefaultStaticInterface extends DefaultStaticInterface {

    // Override default method
    default String greeting(String someone) {
        return "Morning " + someone;
    }
}

class ImplementationClassOfDefaultStaticInterface implements DefaultStaticInterface {
    @Override
    public String update(String someone) {
        return "Hi " + someone;
    }

    // override default method with public modifier
    @Override
    public String greeting(String someone) {
        return update(someone);
    }
}
