package coffee_and_tea.jdk8.jep104_jep120_annotations;

import java.lang.annotation.Documented;

public class CustomerAnnotationWithDocumented {

    @DocumentedAnnotation
    public void methodAnnotatedWithDocumentedAnnotation() {
        System.out.println("Annotation also can be seen on Javadoc generated API file.");
    }

    @NoneDocumentedAnnotation
    public void methodAnnotatedWithNoneDocumentedAnnotation() {

    }
}

@Documented
@interface DocumentedAnnotation {

}

@interface NoneDocumentedAnnotation {

}
