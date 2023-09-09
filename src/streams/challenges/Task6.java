package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6 {

    public List<OrderSummary> filterAndMapOrders(List<Order> orders) {
        // 1. filter out order(s) with price less than $50
        // 2. map orders to id and price
        // 3. return list of OrderSummary objects
        return orders.stream() // Stream<Order>
                .filter(order -> order.getTotalPrice() >= 50) // Stream<Order>
                .map(order -> new OrderSummary(order.getId(), order.getTotalPrice())) // Stream<OrderSummary>
                .collect(Collectors.toList());
    }




    @Test
    void testFilterAndMapOrders() {
        List<String> items1 = Arrays.asList("Laptop", "Mouse", "Keyboard");
        List<String> items2 = Arrays.asList("Monitor", "Speakers", "Headphones");
        List<String> items3 = Arrays.asList("USB Drive", "External Hard Drive", "Flash Drive");
        List<String> items4 = Arrays.asList("Smartphone", "Tablet");
        Order o1 = new Order(1, items1, 1200.00);
        Order o2 = new Order(2, items2, 250.00);
        Order o3 = new Order(3, items3, 40.00);
        Order o4 = new Order(4, items4, 600.00);
        List<Order> orders = Arrays.asList(o1, o2, o3, o4);

        List<OrderSummary> expected = Arrays.asList(
                new OrderSummary(1, 1200.00),
                new OrderSummary(2, 250.00),
                new OrderSummary(4, 600.00)
        );
        List<OrderSummary> actual = filterAndMapOrders(orders);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            assertEquals(expected.get(i).getTotalPrice(), actual.get(i).getTotalPrice(), 0.001);
        }
    }


    static class Order {
        private int id;
        private List<String> items;
        private double totalPrice;

        public Order(int id, List<String> items, double totalPrice) {
            this.id = id;
            this.items = items;
            this.totalPrice = totalPrice;
        }

        public int getId() {
            return id;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    static class OrderSummary {
        private int id;
        private double totalPrice;

        public OrderSummary(int id, double totalPrice) {
            this.id = id;
            this.totalPrice = totalPrice;
        }

        public int getId() {
            return id;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

}
