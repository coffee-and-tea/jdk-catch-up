package coffee_and_tea.jdk8.jep104_jep120_annotations;

public class UseDeprecatedAnnotated {

    public static void main(String[] args) {
        System.out.println("Using deprecated code should have compiler warnings");

        // note if you are using an IDE here, your IDE may not recompile each time, you only see the warning at first time
        DeprecatedAnnotated deprecatedAnnotated = new DeprecatedAnnotated();
        deprecatedAnnotated.deprecatedMethod();
    }
}
