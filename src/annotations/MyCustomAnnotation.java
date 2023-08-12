package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Month;

// The order of annotations is not important
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    // Although value() is written like a method, but it's not.
    // It's rather called an 'Element' of the annotation.
    // 'Element' defined this way becomes the argument of the annotation.

    // There are certain limitations around 'Element':
    // 1. Return type of the 'Element' must be:
    //  - simple types (int, float, double etc.) and their object-oriented counterparts (e.g. Integer, Double...)
    //  - String class
    //  - Enum types
    //  - other annotation classes
    //  - arrays of the types as mentioned above
    // 2. 'Element' cannot take any arguments (i.e. look like method declaration with no argument)
    String[] value();

    // You can define 'default' values for every 'Element'
    String[] dates() default {};

    Month month() default Month.JANUARY;
}
