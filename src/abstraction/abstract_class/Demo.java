package abstraction.abstract_class;

public class Demo {
    public static void main(String[] args) {
        // we can't instantiate an abstract class
        // MyAbstractClass myAbstractClass = new MyAbstractClass("some name");
        MyConcreteClass aClass = new MyConcreteClass();
        aClass.abstractMethod();
        aClass.concreteMethod();

        System.out.println("============ POLYMORPHISM ============");
        // Every child class is also a parent class
        // Therefore, you can ALWAYS store a subclass object inside a parent class reference variable
        MyAbstractClass bClass = new MyConcreteClass();
        bClass.abstractMethod();
        bClass.concreteMethod();
    }
}
