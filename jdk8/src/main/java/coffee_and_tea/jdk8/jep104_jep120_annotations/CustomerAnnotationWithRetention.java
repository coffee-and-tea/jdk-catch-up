package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class CustomerAnnotationWithRetention {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Use javap -v CustomerAnnotationWithRetention.class " +
                "to view annotations retented within class file");

        CustomerAnnotationWithRetention customerAnnotationWithRetention
                = new CustomerAnnotationWithRetention();

        Method[] methods = CustomerAnnotationWithRetention.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName() + " with annotations "
                    + Arrays.toString(method.getDeclaredAnnotations()));
            if(!Modifier.isStatic(method.getModifiers())) {
                method.invoke(customerAnnotationWithRetention);
            }
        }
    }

    @RetentionClass
    public void classRetentionAnnotatedMethod() {
        System.out.println("RetentionPolicy.CLASS does not retain annotation for runtime");
    }

    @RetentionSource
    public void sourceRetentionAnnotatedMethod() {
        System.out.println("RetentionPolicy.SOURCE does not retain annotation for runtime");
    }

    @RetentionRuntime
    public void runtimeRetentionAnnotatedMethod() {
        System.out.println("RetentionPolicy.RUNTIME retain annotation for runtime");
    }

    @RetentionDefault
    public void defaultRetentionAnnotatedMethod() {
        System.out.println("Default equivalent to RetentionPolicy.CLASS does not retain annotation for runtime");
    }
}

@Retention(RetentionPolicy.CLASS)
@interface RetentionClass {

}

@Retention(RetentionPolicy.SOURCE)
@interface RetentionSource {

}

@Retention(RetentionPolicy.RUNTIME)
@interface RetentionRuntime {

}

@interface RetentionDefault {

}