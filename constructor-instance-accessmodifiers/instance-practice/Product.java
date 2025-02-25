public class Product {

    private String productname;
    private double price;
    private static int totalproducts;

    public void setProductDetails(String productname,double price){
        this.productname=productname;
        this.price=price;
        totalproducts++;
    }

    public void displayTotalProducts(){
        //System.out.println("Product Name: "+productname);
        //System.out.println("Price: "+price);
        System.out.println("Total Products: "+totalproducts);
    }
    public static void main(String[] args) {
        Product obj=new Product();
        obj.setProductDetails("Asus Laptop",70000);
        obj.displayTotalProducts();
        obj.setProductDetails("iphone", 100000);
        obj.displayTotalProducts();
    }
}
