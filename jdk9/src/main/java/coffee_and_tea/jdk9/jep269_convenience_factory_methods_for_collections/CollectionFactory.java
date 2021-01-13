package coffee_and_tea.jdk9.jep269_convenience_factory_methods_for_collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 2, 3);
        List<String> strings = List.of("1", "2", "3");

        // unmodifiable list below will throw exception
        // strings.add("4");

        Set.of(1, 2, 3);

        // IllegalArgumentException below
        // Set.of(1, 2, 3, 3);

        Map<Integer, String> integerStringMap = Map.of(1, "1", 2, "2", 3, "3");
        // IllegalArgumentException below
        // Map<Integer, String> integerStringMap2 = Map.of(1, "1", 2, "2", 3, "3", 3, "4");
    }
}
