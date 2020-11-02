package coffee_and_tea.jdk8.jep126_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {

    public static void main(String[] args) {

        List<String> alph = Arrays.asList("a", "b", "c");


        String list = alph.stream()
                .map(String::toUpperCase) // instance method by type
                .map(x -> x.length())    // instance method by object
                .map(Integer::toHexString) // static method
                .map(String::new) // constructor
                .collect(Collectors.joining());

        System.out.println(list);
    }
}
