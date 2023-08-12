package access_modifiers.p2;

import access_modifiers.p1.C1;

public class C4 extends C1 {
    public void aMethod() {
        // can access c1.publicField
        System.out.println(publicField);

        // can not access privateField
        // System.out.println(privateField);

        // can not access defaultField
        // System.out.println(defaultField);

        // can access protectedField because C4 is a subclass of C1
        System.out.println(protectedField);



        // can invoke publicMethod()
        publicMethod();

        // can not invoke privateMethod()
        // privateMethod();

        // can not invoke defaultMethod()
        // defaultMethod();

        // can not invoke protectedMethod()
        protectedMethod();
    }
}
