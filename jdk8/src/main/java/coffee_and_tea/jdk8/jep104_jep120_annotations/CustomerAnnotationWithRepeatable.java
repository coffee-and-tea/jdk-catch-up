package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CustomerAnnotationWithRepeatable {

    public static void main(String[] args) {
        Arrays.stream(CustomerAnnotationWithRepeatable.class.getMethods()).forEach(
                method -> {
                    System.out.println(method.getName()+":"+Arrays.toString(method.getAnnotations()));
                }
        );
    }

    @RepeatableAnnotation("Annotation1")
    @RepeatableAnnotation("Annotation2")
    @RepeatableAnnotation("Annotation3")
    public void repeatAnnotatedMethod() {}
}

@Repeatable(RepeatableAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@interface RepeatableAnnotation {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface RepeatableAnnotations {
    RepeatableAnnotation [] value();
}