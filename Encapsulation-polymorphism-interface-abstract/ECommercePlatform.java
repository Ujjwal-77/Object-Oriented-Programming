import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }


    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();


    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
    }
}


interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double discountRate = 0.10;
    private double taxRate = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }


    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }


    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 18% (Electronics)";
    }
}


class Clothing extends Product implements Taxable {
    private double discountRate = 0.15;
    private double taxRate = 0.05; 

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5% (Clothing)";
    }
}


class Groceries extends Product {
    private double discountRate = 0.05; 

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}


public class ECommercePlatform {
    public static void main(String[] args) {
        
        List<Product> products = new ArrayList<>();

        
        Electronics laptop = new Electronics(101, "Laptop", 50000);
        Clothing tShirt = new Clothing(102, "T-Shirt", 2000);
        Groceries rice = new Groceries(103, "Rice (5kg)", 500);

        
        products.add(laptop);
        products.add(tShirt);
        products.add(rice);

        for (Product product : products) {
            product.displayDetails();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - product.calculateDiscount();
            System.out.println("Final Price (After Tax & Discount): $" + finalPrice);

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("----------------------------");
        }
    }
}
