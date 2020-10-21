package coffee_and_tea.jdk7.jsr334_small_enhancements_project_coin;

import java.util.Arrays;
import java.util.List;

public class VarargsNonReifiableType {

    public static void main(String[] args) {

        // previously this would have a compiler warning
        // as varaugs in asList(...) is implemented using List,
        // type information is suppression at runtime with erasure
        List<List<String>> nonReifiableTypeAsVarargs =
                Arrays.asList(
                        Arrays.asList("String", "list"),
                        Arrays.asList("another", "string", "list")
                );
    }
}
