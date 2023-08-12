package access_modifiers.p1;

public class C3 extends C1{
    public void aMethod() {

        // can access publicField
        System.out.println(publicField);


        // can not access privateField
        // System.out.println(privateField);


        // can access defaultField
        System.out.println(defaultField);


        // can access protectedField
        System.out.println(protectedField);




        // can invoke publicMethod()
        publicMethod();


        // can not invoke privateMethod()
        // privateMethod();


        // can invoke defaultMethod()
        defaultMethod();

        // can invoke protectedMethod()
        protectedMethod();
    }
}
