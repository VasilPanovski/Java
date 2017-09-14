package anotations;

import java.lang.annotation.*;

//@Target({ElementType.TYPE, ElementType.FIELD}) // can be used for both classes and fields
@Target(ElementType.METHOD) // without it we can use the annotation everywhere
@Retention(RetentionPolicy.RUNTIME)

public @interface CustomAnnotation {
    String type() default "Enumeration";
    String category();
    String description();
}

class TestCustomAnnotation {

    @CustomAnnotation(category = "Method", description = "Main")
    public static void main(String[] args) {
        Class<TestCustomAnnotation> annotationClass = TestCustomAnnotation.class;
        Annotation annotation = annotationClass.getAnnotation(CustomAnnotation.class);
    }
}
