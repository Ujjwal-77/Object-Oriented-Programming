import java.util.ArrayList;
import java.util.List;
import java.util.Random;


abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;


    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

   
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }


    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per km: $" + ratePerKm);
    }
}


interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}


class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown"; 
    }


    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 5; 
    }


    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}


class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

   
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm; 
    }

    
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}


class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 2; 
    }

    
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}


public class RideHailingApp {
    public static void main(String[] args) {
        
        List<Vehicle> rides = new ArrayList<>();

        
        Car car1 = new Car("C101", "John Doe", 10.0);
        Bike bike1 = new Bike("B202", "Jane Smith", 5.0);
        Auto auto1 = new Auto("A303", "Robert Brown", 7.0);

       
        rides.add(car1);
        rides.add(bike1);
        rides.add(auto1);

       
        double distance = 12.5; 
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Estimated Fare for " + distance + " km: $" + ride.calculateFare(distance));

            
            if (ride instanceof GPS) {
                GPS gpsVehicle = (GPS) ride;
                String newLocation = generateRandomLocation();
                gpsVehicle.updateLocation(newLocation);
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }

            System.out.println("----------------------------");
        }
    }

    
    private static String generateRandomLocation() {
        String[] locations = { "Downtown", "City Center", "Airport", "Suburbs", "Train Station" };
        Random rand = new Random();
        return locations[rand.nextInt(locations.length)];
    }
}
