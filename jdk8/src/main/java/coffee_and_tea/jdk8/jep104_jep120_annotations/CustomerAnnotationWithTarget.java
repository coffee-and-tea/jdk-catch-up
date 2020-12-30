package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@TargetTypeType("annotation on a type ")
@TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
        "you can use it here, but recommand to use when it's actually used")
@TargetTypeDefault("Default can be used anywhere exception for type use and type parameter")
public class CustomerAnnotationWithTarget
        extends @TargetTypeTypeUse("intended usage") Object
        implements @TargetTypeTypeUse("intended usage") Serializable {

    public static void main(String[] args) {

    }

    @TargetTypeField
    @TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
            "you can use it here, but recommand to use when it's actually used")
    @TargetTypeDefault("Default can be used anywhere exception for type use")
    private String annotatedField;

    @TargetTypeConstructor
    @TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
            "you can use it here, but recommand to use when it's actually used")
    @TargetTypeDefault("Default can be used anywhere exception for type use")
    public CustomerAnnotationWithTarget() {
        @TargetTypeLocalVariable
        @TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
                "you can use it here, but recommand to use when it's actually used")
        @TargetTypeDefault("Default can be used anywhere exception for type use")
        int localVarialbeAnnotated;
    }

    @TargetTypeMethod
    @TargetTypeDefault("Default can be used anywhere exception for type use")
    public  @TargetTypeTypeUse("intented for type use")
    String AnnotatedMethod(
            @TargetTypeParameter
            @TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
            "you can use it here, but recommand to use when it's actually used")
            @TargetTypeDefault("Default can be used anywhere exception for type use")
                    String  annotatedParameter) {
        return new String();
    }

    public  <
            @TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
            "you can use it here, but recommand to use when it's actually used")
            @TargetTypeTypeParameter
            T> void annotatedTypeParameterMethod() {

    }

    public void typeUseAnnotation() throws @TargetTypeTypeUse("intented usage") Exception{
        new @TargetTypeTypeUse("intented usage") String();
    }
}

@TargetTypeAnnotationType
@TargetTypeTypeUse("Annotation for type use, when a type is actually used, " +
        "you can use it here, but recommand to use when it's actually used")
@TargetTypeDefault("Default can be used anywhere exception for type use")
@interface TargetTypeAnnotationTypeUsage {

}

@Target(ElementType.ANNOTATION_TYPE)
@interface TargetTypeAnnotationType {

}

@Target(ElementType.CONSTRUCTOR)
@interface  TargetTypeConstructor {

}

@Target(ElementType.FIELD)
@interface TargetTypeField {

}

@Target(ElementType.LOCAL_VARIABLE)
@interface TargetTypeLocalVariable {

}
@Target(ElementType.PACKAGE)
@interface TargetTypePackageTypeAnnotation {

}

@Target(ElementType.METHOD)
@interface TargetTypeMethod {

}

@Target(ElementType.PARAMETER)
@interface TargetTypeParameter {

}

@Target(ElementType.TYPE)
@interface TargetTypeType {
    String value();
}

@Target(ElementType.TYPE_PARAMETER)
@interface TargetTypeTypeParameter {

}

@Target(ElementType.TYPE_USE)
@interface TargetTypeTypeUse {
    String value();
}

@interface TargetTypeDefault {
    String value();
}