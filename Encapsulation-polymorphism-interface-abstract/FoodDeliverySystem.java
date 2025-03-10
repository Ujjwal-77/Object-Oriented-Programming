import java.util.ArrayList;
import java.util.List;


abstract class FoodItem {
    private String itemName;
    protected double price;
    protected int quantity;

    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public abstract double calculateTotalPrice();


    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}


interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}


class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    
    @Override
    public double calculateTotalPrice() {
        return price * quantity - applyDiscount();
    }

  
    @Override
    public double applyDiscount() {
        return (price * quantity) * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied!";
    }
}


class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 2.0; 

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    
    @Override
    public double calculateTotalPrice() {
        return (price * quantity + (nonVegCharge * quantity)) - applyDiscount();
    }

    
    @Override
    public double applyDiscount() {
        return (price * quantity) * 0.03;
    }

    @Override
    public String getDiscountDetails() {
        return "3% discount applied, but includes a non-veg surcharge of $" + (nonVegCharge * quantity);
    }
}


public class FoodDeliverySystem {
    public static void main(String[] args) {
        
        List<FoodItem> order = new ArrayList<>();

        
        VegItem vegBurger = new VegItem("Veg Burger", 5.99, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 12.99, 1);
        VegItem paneerTikka = new VegItem("Paneer Tikka", 8.49, 3);

        
        order.add(vegBurger);
        order.add(chickenPizza);
        order.add(paneerTikka);

        
        double totalOrderPrice = 0;
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price (after discount & charges): $" + item.calculateTotalPrice());

            
            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
            }

            totalOrderPrice += item.calculateTotalPrice();
            System.out.println("----------------------------");
        }

        System.out.println("Final Order Amount: $" + totalOrderPrice);
    }
}
