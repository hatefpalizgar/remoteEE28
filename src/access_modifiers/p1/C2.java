package access_modifiers.p1;

public class C2 {
    public void aMethod() {
        C1 c1 = new C1();

        // can access c1.publicField
        System.out.println(c1.publicField);

        // can not access c1.privateField
        // System.out.println(c1.privateField);

        // can access c1.defaultField
        System.out.println(c1.defaultField);

        // can access c1.protectedField
        System.out.println(c1.protectedField);




        // can invoke c1.publicMethod()
        c1.publicMethod();

        // can not invoke c1.privateMethod()
        // c1.privateMethod();

        // can invoke c1.defaultMethod()
        c1.defaultMethod();

        // can invoke c1.protectedMethod()
        c1.protectedMethod();
    }
}
