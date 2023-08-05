package static_vs_nonstatic;

public class NonStaticEmployee {
    String name;
    int empId;
    String company;


    public NonStaticEmployee(String name, int empId, String company) {
        this.name = name;
        this.empId = empId;
        this.company = company;
    }

    public void display(){
        System.out.println("The details of the employee is employee id: " + empId +
                ", employee name: " + name +
                ", company: " + company);
    }
}
