package encapsulation;

// Encapsulation is the process of wrapping up the data (variables/properties)
// and code acting on the data (methods) in a single unit.

// Encapsulation is achieved by making the fields private and providing public getters & setters.

public class Demo {
    public static void main(String[] args) {
        Pocket paypal = new Pocket(4000);
        System.out.println(paypal.getMoney());
        paypal.setMoney(5000);
        System.out.println(paypal.getMoney());

    }
}
