package coffee_and_tea.jdk8.jep101_type_inference;


import java.util.Arrays;
import java.util.List;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class InferGenericType {

    public static void main(String[] args) {

        // infer method paramerter
        // method parameter type infer
        boolean disjoint = Collections.disjoint(Arrays.asList("a"), Collections.emptyList());
        // without infer same thing
        disjoint = Collections.disjoint(Arrays.asList("a"), Collections.<String>emptyList());

        // chain method inference, still needs to add <String>
        List<String> empty = Collections.<String>emptyList().subList(0, 0);
    }
}
