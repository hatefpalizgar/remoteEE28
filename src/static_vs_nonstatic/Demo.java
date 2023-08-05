package static_vs_nonstatic;

public class Demo {
    public static void main1(String[] args) {
        NonStaticEmployee emp1 = new NonStaticEmployee("Tom", 1001, "Yahoo");
        NonStaticEmployee emp2 = new NonStaticEmployee("John", 1002, "Yahoo");
        emp1.display();
        emp2.display();
    }

    public static void main2(String[] args) {
        StaticEmployee emp1 = new StaticEmployee("Tom", 1001);
        StaticEmployee emp2 = new StaticEmployee("John", 1002);
        emp1.display();
        emp2.display();
    }

    public static void main(String[] args) {
        StaticEmployee emp1 = new StaticEmployee("Tom", 1001);
        emp1.display();
        // static method should be called on the Class itself not the object(instance)
        // a static method belongs to the class and is shared among all the objects of that class
        System.out.println("The salary for " + emp1.empId + " is: " + StaticEmployee.calculateSalary(2000, 0.2));

        // Even though static field company is accessible on the object, it's better to access it using the class itself
        System.out.println(emp1.company);

        // The better way to access static field company is by the class, like below:
        System.out.println(StaticEmployee.company);
    }

    // Static variables and methods are created even before the constructor is called and object is created.
    // Therefore, we can access the static variables and methods from anywhere in the program without creating an object.

    // BUT, non-static variables/methods are created only when the class is loaded and object is created.

}
