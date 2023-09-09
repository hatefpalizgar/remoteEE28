package streams.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Task9 {

    public List<Item> findAllItems(List<Order> orders) {
        return orders.stream() // Stream<Order>
                .flatMap(order -> order.getItems().stream())// Stream<Item>
                .collect(Collectors.toList());// List<Item>
    }

    @Test
    public void testFindAllItems() {
        Item item1 = new Item(1, "item1", 2, 5.0);
        Item item2 = new Item(2, "item2", 3, 7.0);
        Item item3 = new Item(3, "item3", 1, 10.0);
        Item item4 = new Item(4, "item4", 4, 3.0);

        List<Order> orders = Arrays.asList(
                new Order(1, Arrays.asList(item1, item2)),
                new Order(2, Arrays.asList(item3, item4))
        );

        List<Item> expectedItems = Arrays.asList(item1, item2, item3, item4);

        List<Item> actualItems = findAllItems(orders);

        assertIterableEquals(expectedItems, actualItems);
    }

    static class Order {
        private int orderId;
        private List<Item> items;

        public Order(int orderId, List<Item> items) {
            this.orderId = orderId;
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }
    }

    static class Item {
        private int itemId;
        private String name;
        private int quantity;
        private double price;

        public Item(int itemId, String name, int quantity, double price) {
            this.itemId = itemId;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

}
