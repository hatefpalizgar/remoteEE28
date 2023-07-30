package abstraction.abstract_class;

public class Girl extends Human{

    // by extending Human(abstract class) we are 'enforcing' any child object
    // of Human (like Girl here) to have two methods:
    // 1. eat()
    // 2. breathe()

    // Using abstract methods, is a sort of signing a 'contract'

    // by extending Human, we can be %100 sure that any subclass(child) of Human
    // will certainly have two methods eat() and breathe()

    @Override
    public void eat() {
        //...
    }

    @Override
    public void breathe() {
        //...
    }

}
