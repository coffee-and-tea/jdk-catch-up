package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.util.Collections;
import java.util.List;

public class SafeVarargsAnnotation {

    public static void main(String[] args) {

        playWithVarargsNoWarnings();

        playWithSafeVarags();
    }

    @SafeVarargs
    private static void playWithSafeVarags(List<String>...arrayOfListStrings) {
        System.out.println(arrayOfListStrings.getClass() + " will have warnings");
    }

    public static void playWithVarargsNoWarnings(String... strings) {
        strings = Collections.emptyList().toArray(strings);
        System.out.println(strings.getClass() + " does not cause warnings");
    }


}


