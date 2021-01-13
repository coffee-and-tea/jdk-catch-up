package coffee_and_tea.jdk10.jep286_local_variable_type_inference;

import java.util.List;

public class LocalVariableInference {

    public static void main(String[] args) {

        var list = List.of(1);
        var stream = list.stream();

        for (var i = 0; i < 100; i ++) {
            System.out.println(i);
        }

        for(var item : list) {
            System.out.println(item);
        }
    }
}
