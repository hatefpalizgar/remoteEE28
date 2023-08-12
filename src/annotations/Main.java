package annotations;


/*
* Annotations are a form of metadata that provide information about a program and is NOT part of the program.
* Annotations do NOT directly affect the operation of the code they refer to.
*
* Annotation by itself does NOTHING. It's more about OTHERS who use the annotation to do something.
* */
public class Main {
    public static void main(String[] args) {
        Student student = new Student("fname", "lname", 10);
        student.processMyCustomAnnotation();
        student.processDeprecatedAnnotation();
    }


}
