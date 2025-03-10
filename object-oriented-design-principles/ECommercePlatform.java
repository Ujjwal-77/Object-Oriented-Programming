import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private List<Product> products;
    private double totalAmount;

    public Order() {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product p : products) {
            System.out.println("- " + p);
        }
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("--------------------------");
    }
}

class ECommerceCustomer {
    private String name;
    private List<Order> orders;

    public ECommerceCustomer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order with Order ID: " + order);
    }

    public void viewOrders() {
        System.out.println("Customer: " + name + "'s Orders");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 1200);
        Product phone = new Product("Smartphone", 800);
        Product headphones = new Product("Wireless Headphones", 150);

        ECommerceCustomer alice = new ECommerceCustomer("Alice");
        ECommerceCustomer bob = new ECommerceCustomer("Bob");

        Order order1 = new Order();
        order1.addProduct(laptop);
        order1.addProduct(headphones);
        alice.placeOrder(order1);

        Order order2 = new Order();
        order2.addProduct(phone);
        bob.placeOrder(order2);

        alice.viewOrders();
        bob.viewOrders();
    }
}
