public class CarRental {
    private String customername;
    private String carmodel;
    private int rentaldays;
    private double rate;

    CarRental(String customername,String carmodel,int rentaldays,double rate){
        this.customername=customername;
        this.carmodel=carmodel;
        this.rentaldays=rentaldays;
        this.rate=rate;
    }

    public double calculateTotalCost() {
        return rentaldays * rate;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customername);
        System.out.println("Car Model: " + carmodel);
        System.out.println("Rental Days: " + rentaldays);
        System.out.println("Daily Rate: " + rate);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental obj=new CarRental("ujjwal", null, 2, 10000);
        obj.displayRentalDetails();

    }
}
