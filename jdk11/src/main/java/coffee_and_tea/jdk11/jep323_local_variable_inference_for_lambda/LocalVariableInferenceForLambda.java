package coffee_and_tea.jdk11.jep323_local_variable_inference_for_lambda;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;


public class LocalVariableInferenceForLambda {

    public static void main(String[] args) {

        // lambda variable inference can use annotation on variable
        Stream.of(1, 2, 3, 4).forEach(
                (@LocalVariableAnnotation var i) -> System.out.println(i)
        );

    }
}

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface LocalVariableAnnotation {

}