package abstraction.abstract_class;

public class MyConcreteClass extends MyAbstractClass{

    // We SHOULD provide implementation for ALL the abstract methods in an abstract class when extending it

    // below we're implementing abstractMethod
    @Override
    public void abstractMethod() {
        System.out.println("inside abstractMethod() of MyConcreteClass");
    }


}
