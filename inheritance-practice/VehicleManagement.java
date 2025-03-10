class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging... Battery Capacity: " + batteryCapacity + " kWh");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Electric Vehicle, Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling... Fuel Capacity: " + fuelCapacity + " liters");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Petrol Vehicle, Fuel Capacity: " + fuelCapacity + " liters");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        Vehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        Vehicle bmw = new PetrolVehicle("BMW M5", 280, 60);

        Vehicle[] vehicles = {tesla, bmw};

        for (Vehicle v : vehicles) {
            v.displayInfo();
            if (v instanceof ElectricVehicle) {
                ((ElectricVehicle) v).charge();
            }
            if (v instanceof PetrolVehicle) {
                ((PetrolVehicle) v).refuel();
            }
            System.out.println();
        }
    }
}
