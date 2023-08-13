package casting_autoboxing;
/* ========================================================================================== */
//                                    Casting & Autoboxing & Unboxing
/* ========================================================================================== */

public class Main {
    public static void main(String[] args) {
        /* ========================================================================================== */
        //                                    Casting
        /* ========================================================================================== */
//        Casting in Java refers to the process of converting an object of one type to another type. This can be done either explicitly or implicitly.
//        Explicit casting is when you explicitly specify the type to which you want to cast an object. For example:
        double xx = 10.5;
        int yy = (int) xx;

//        Implicit casting, on the other hand, occurs automatically when an object is assigned to a variable of a compatible type. For example:
        int x = 10;
        double y = x;
//        Here, the int value x is implicitly cast to a double value and stored in y.


        /* ========================================================================================== */
        //                                    Autoboxing
        /* ========================================================================================== */
//        Autoboxing is the automatic conversion of a primitive type to its corresponding wrapper class. For example:
        int xxx = 10;
        Integer yyy = xxx;
//        Here, the int value xxx is automatically converted to an Integer object and stored in yyy.


        /* ========================================================================================== */
        //                                    Unboxing
        /* ========================================================================================== */
//        Unboxing is the opposite of autoboxing, i.e., it is the automatic conversion of a wrapper class to its corresponding primitive type. For example:

        Integer xxxx = new Integer(10);
        int yyyy = xxxx;

//        It's important to note that casting and autoboxing/unboxing can lead to runtime errors if not used properly.
//        For example, trying to cast an object to an incompatible type will result in a ClassCastException,
//        and trying to unbox a null value will result in a NullPointerException.

//        Here is an example of a runtime error due to an invalid cast:
        Object obj = "Hello, World!";
        Integer num = (Integer) obj;  // ClassCastException

//        Here is an example of a runtime error due to an attempt to unbox a null value:
        Integer nullObj = null;
        int aVariable = nullObj;  // NullPointerException



    }
}
