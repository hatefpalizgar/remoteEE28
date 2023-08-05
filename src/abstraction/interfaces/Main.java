package abstraction.interfaces;

public class Main {
    public static void main(String[] args) {
        Loveable girl = new Girl("White", "Anna");
        Loveable rex = new Dog(2, "Circular");

        // We abstracted away the love() implementation from its definition
        // in other words, we separated HOW from WHAT

        // WHAT: love()
        // HOW: the implementation of love()
        showLove(girl);
        showLove(rex);

    }

    public static void showLove(Loveable loveable) {
        // because of Loveable contract(interface)
        // we are %100 sure that any Loveable object
        // has love() method
        loveable.love();
    }


    //    without polymorphism
//    public static void showLove(Human human) {
//        //...
//    }
//
//    public static void showLove(Animal animal) {
//        //...
//    }


}
