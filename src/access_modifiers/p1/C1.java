package access_modifiers.p1;

public class C1 {
    // public visibility(access) modifier
    // accessible from any other classes
    public int publicField;

    // private visibility modifier
    // accessible only by the class itself
    private int privateField;

    // default visibility modifier (package-private | package-access)
    // accessible only by any class in the same package
    int defaultField;

    // protected visibility modifier
    // accessible only by the class itself and classes in the same package and its subclasses
    protected int protectedField;


    public void publicMethod(){}

    private void privateMethod(){}

    void defaultMethod(){};

    protected void protectedMethod(){};
}
