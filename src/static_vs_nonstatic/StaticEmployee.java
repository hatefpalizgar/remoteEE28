package static_vs_nonstatic;

public class StaticEmployee {
    // a non-static field is sometimes called as 'Instance Field'
    String name;
    int empId;
    // a static field/property is shared across all instances created from StaticEmployee class
    // a static field belongs to the Class not the objects(instances)
    // a static field is sometimes called as 'Class Field'
    static String company = "Google";


    public StaticEmployee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    // display() is a non-static context
    // we can access a static field/method from within a non-static context, like 'company' below:
    public void display(){
        System.out.println("The details of the employee is employee id: " + empId +
                ", employee name: " + name +
                ", company: " + company);
    }

    // calculateSalary() is a static context
    // we can NOT access a non-static field/method from within a static context, like 'this.name' below:
    public static double calculateSalary(double basic, double taxRate) {
       // System.out.println(this.name);
        return basic * (1 - taxRate);
    }

    // We can access the non-static variables/methods only from within a non-static context.
    // For example, inside calculateSalary() which is a static method, we can't access the non-static variables/methods.
    // BUT, inside display() which is a non-static method, we can access static calculateSalary() or company field.

    // Please learn more about static and non-static in Java here:
    // https://examples.javacodegeeks.com/static-vs-non-static-in-java/

}
