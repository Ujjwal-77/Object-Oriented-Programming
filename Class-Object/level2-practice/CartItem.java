class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
            System.out.println(quantity + " more " + itemName + "(s) added to the cart.");
        } else {
            System.out.println("Invalid quantity to add.");
        }
    }

    public void removeItem(int quantity) {
        if (quantity > 0 && quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + itemName + "(s) removed from the cart.");
        } else {
            System.out.println("Invalid quantity to remove.");
        }
    }

    public void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per item: $" + price);
        System.out.println("Total Cost: $" + totalCost);
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Laptop", 800.0, 1);

        cart.displayTotalCost();
        cart.addItem(2);
        cart.displayTotalCost();
        cart.removeItem(1);
        cart.displayTotalCost();
    }
}
