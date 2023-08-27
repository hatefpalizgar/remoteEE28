package functional_interfaces.built_in_jdk_func_interfaces;

import java.util.function.Supplier;

/*
 * Supplier always returns some value and never takes an arg.
 * Supplier is a functional interface which has 'T get()' method.
 * */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Teacher> teacherSupplier = () -> new Teacher("Rio", 29);

        Teacher rio = teacherSupplier.get();

        System.out.println(rio.getName());
        System.out.println(rio.getAge());

        /*
         * Next:
         * see FunctionExample
         * */
    }
}
