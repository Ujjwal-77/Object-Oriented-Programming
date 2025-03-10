import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: $" + rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate = 0.05; 

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
    }

    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

   
    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    
    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: [Protected]";
    }
}


class Bike extends Vehicle implements Insurable {
    private double insuranceRate = 0.03; 

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

  
    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: [Protected]";
    }
}


class Truck extends Vehicle {
    private double extraCharge = 50.0; 

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + extraCharge;
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        
        List<Vehicle> vehicles = new ArrayList<>();

        
        Car car = new Car("MH12AB1234", 100, "CAR-INS-123");
        Bike bike = new Bike("MH14XY5678", 50, "BIKE-INS-567");
        Truck truck = new Truck("MH09TR9999", 300);

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        
        int rentalDays = 5; 
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: " + vehicle.calculateRentalCost(rentalDays));

            if (vehicle instanceof Insurable) {
                System.out.println("Insurance Cost: " + ((Insurable) vehicle).calculateInsurance());
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }

            System.out.println("----------------------------");
        }
    }
}
