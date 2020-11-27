package coffee_and_tea.jdk8.jep107_jep126_lambda_collection_map_filter_reduce;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalUtil {

    public static void main(String[] args) {

        Optional<String> stringOptional = Optional.of("optional string");
        System.out.println(stringOptional.get());

        stringOptional = Optional.empty();
        try {
            System.out.println(stringOptional.get());
        }catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        System.out.println(stringOptional.orElse("else string"));

        System.out.println(stringOptional.orElseGet( () -> "string supplier"));

        System.out.println(stringOptional.isPresent());
    }
}
