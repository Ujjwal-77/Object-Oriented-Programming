import java.time.LocalDate;

class Order {
    protected String orderId;
    protected LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

public class RetailOrderSystem {
    public static void main(String[] args) {
        Order order = new Order("ORD123", LocalDate.of(2024, 3, 1));
        ShippedOrder shippedOrder = new ShippedOrder("ORD124", LocalDate.of(2024, 3, 2), "TRACK56789");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", LocalDate.of(2024, 3, 3), "TRACK98765", LocalDate.of(2024, 3, 5));

        System.out.println("Order Details:\n");
        order.displayOrderDetails();
        System.out.println();
        shippedOrder.displayOrderDetails();
        System.out.println();
        deliveredOrder.displayOrderDetails();
    }
}
