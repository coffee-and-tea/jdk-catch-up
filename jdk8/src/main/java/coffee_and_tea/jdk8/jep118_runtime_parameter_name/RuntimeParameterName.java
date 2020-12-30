package coffee_and_tea.jdk8.jep118_runtime_parameter_name;

import java.util.Arrays;
import java.util.List;

public class RuntimeParameterName {

    private String field;

    public RuntimeParameterName(String runtimeField) {
        this.field = runtimeField;
    }

    public void methodForRuntimeParameterName(String stringParam, List listParam){

    }

    public static void main(String[] args) {
        Arrays.stream(RuntimeParameterName.class.getConstructors()).forEach(
                constructor -> {
                    System.out.println("Constructor: "+ constructor.getName() + "with parameters:");
                    Arrays.stream(constructor.getParameters()).forEach(
                            parameter -> {
                                System.out.println("parameter of name: " + parameter.getName() + " type: " + parameter.getType());
                            }
                    );
                }
        );

        Arrays.stream(RuntimeParameterName.class.getMethods()).forEach(
                method -> {
                    System.out.println("Method: "+ method.getName() + "with parameters:");
                    Arrays.stream(method.getParameters()).forEach(
                            parameter -> {
                                System.out.println("parameter of name: " + parameter.getName() + " type: " + parameter.getType());
                            }
                    );
                }
        );
    }
}
