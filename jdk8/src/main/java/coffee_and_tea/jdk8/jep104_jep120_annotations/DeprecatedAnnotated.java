package coffee_and_tea.jdk8.jep104_jep120_annotations;

public class DeprecatedAnnotated {

    public static void main(String[] args) {
        System.out.println("No warning when compile this, declare @Deprecated does not create warning, only when using it will");

        // Calling @Deprecated method within the same class shall not cause warning"
        DeprecatedAnnotated deprecatedAnnotated = new DeprecatedAnnotated();
        deprecatedAnnotated.deprecatedMethod();
    }

    /**
     * @deprecated
     * Compiler will not warn when annotate something with @Deprecated using it will
     */
    @Deprecated
    public void deprecatedMethod(){
        System.out.println("Deprecated method doing nothing");
    }
}
