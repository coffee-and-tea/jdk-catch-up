package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CustomerAnnotationWithInherited {

    public static void main(String[] args) {
        // Inherited annotation
        System.out.println(Arrays.toString(InheritedClass.class.getAnnotations()));
        // Annotation declared in class only
        System.out.println(Arrays.toString(InheritedClass.class.getDeclaredAnnotations()));
        // Inherited only from class, here will not inherit anything
        System.out.println(Arrays.toString(InheritedInterfaceClass.class.getAnnotations()));
        // Annotation without declared using @Inherited will not be inherit
        System.out.println(Arrays.toString(NoneInheritedClass.class.getAnnotations()));
        // Annotation on method should not be inherited
        System.out.println(Arrays.toString(MethodWithInheritedClass.class.getDeclaredMethods()[0].getAnnotations()));
    }

}


@InheritedAnnotation
abstract class InheritedClassBase {}

class InheritedClass extends InheritedClassBase {}

@InheritedAnnotation
interface InheritedInterfaceBase {}

class InheritedInterfaceClass implements InheritedInterfaceBase {}

@NoneInheritedAnnotation
abstract class NoneInheritedClassBase {}

class NoneInheritedClass extends NoneInheritedClassBase {}

abstract class MethodWithInheritedBase {

    @InheritedAnnotation
    abstract void inheritedAnnotatedMethod();
}

class MethodWithInheritedClass extends MethodWithInheritedBase {

    @Override
    void inheritedAnnotatedMethod() {}
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnnotation {}

@Retention(RetentionPolicy.RUNTIME)
@interface NoneInheritedAnnotation {}
