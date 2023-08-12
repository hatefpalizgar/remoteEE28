package annotations;

import java.lang.reflect.Method;

public class Student {
    private String firstname;
    private String lastname;
    private int age;

    public Student(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @MyCustomAnnotation({"first value", "second value"})
    @Deprecated
    public void methodWithAnnotation(@Deprecated int someNumber) {
        // ...
    }


    // now, let's see how we can process the @MyCustomAnnotation
    public void processMyCustomAnnotation() {
        // We are using Reflection API to get the method with @MyCustomAnnotation
        // Reflection API is a powerful tool that allows us to get information about the class, method, field, etc.
        // It's a bit more advanced tool and needs a separate lecture BUT
        // you rarely need to use it in your projects, and it would be a bit risky to use it in your projects
        // if you don't know how to use it properly. So, let's skip it for now

        // Steps to process @MyCustomAnnotation:
        // 1. Get the array of all methods in Student class
        Method[] methods = this.getClass().getMethods();
        // 2. we check if there is a method with @MyCustomAnnotation
        for(Method m: methods) {
            if (m.isAnnotationPresent(MyCustomAnnotation.class)) {
                // 3. print out the first and second index of Element called 'value'
                MyCustomAnnotation annotation = m.getAnnotation(MyCustomAnnotation.class);
                System.out.println(annotation.value()[0]);
                System.out.println(annotation.value()[1]);
            }
        }

    }

    // now, let's see how we can process @Deprecated
    public void processDeprecatedAnnotation() {
        Method[] methods = this.getClass().getMethods();
        for(Method m: methods) {
            if (m.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Method: " + m.getName() + " is deprecated");
            }
        }
    }



    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

}
