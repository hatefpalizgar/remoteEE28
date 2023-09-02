package functional_interfaces.method_references;

/**
 * Method reference is a shorthand notation of a lambda expression to call a method.
 * If your lambda expression is like this:
 * <pre>
 *     str -> System.out.println(str)
 *  </pre>
 * then you can replace it with a method reference like this:
 * <pre>
 *      System.out::println
 *  </pre>
 * The <code>::</code> operator is used in method reference to separate the class or object from the method name
 * <br><br>
 * <h2>Four types of method references:</h2>
 * <li>Method reference to an instance method of an object – <code> object::instanceMethod </code></li>
 * <li>Method reference to a static method of a class – <code> Class::staticMethod </code></li>
 * <li>Method reference to an instance method of an arbitrary object of a particular type – <code> Class::instanceMethod </code></li>
 * <li>Method reference to a constructor – <code> Class::new </code></li>
 *
 * @see <a href="https://beginnersbook.com/2017/10/method-references-in-java-8/">method-references-in-java-8</a>
 * <pre></pre>
 * <h1>Method reference to an instance method of an object:</h1>
 * */
public class Example01 {
    public static void main(String[] args) {
        Displayable displayable = () -> System.out.println("Hello World");
        displayable.display();  // Hello World

        Printer printer = new Printer();

        // anything I put on the right side of this equation that follows the structure
        // of display() method, is correct and will work.
        // printer::print is literally referencing print() of printer object
        // **NB: 'printer::print' is NOT calling print() method, it's just REFERENCING it
        Displayable displayable2 = printer::print;
        // above code is equivalent to below:
        // Displayable displayable2 = () -> printer.print();
        // Using printer::print you are telling displayable2 object to use the same
        // logic inside print() of the printer object and don't expect us to write lambda expression explicitly

        displayable2.display(); // this is the line which calls print() method of printer object


        // NB! on line 14, we are not calling printer.print() method. we are just
        // REFERENCING it

        // The call to print() is made on line 20
    }
}

@FunctionalInterface
interface Displayable {
    void display();
}


class Printer {
    public void print() {
        System.out.println("instance method");
    }
}