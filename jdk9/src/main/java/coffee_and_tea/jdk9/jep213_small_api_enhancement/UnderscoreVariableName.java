package coffee_and_tea.jdk9.jep213_small_api_enhancement;

public class UnderscoreVariableName {

    public static void main(String[] args) {

        // previously this is ok, but not with java 9
        // String _ = new String("_");

        String _underscore = new String("_");
    }
}
