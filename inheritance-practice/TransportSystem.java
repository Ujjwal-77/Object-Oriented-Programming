class Vehicle{
    protected double maxSpeed;
    protected String fuelType;

    Vehicle(double maxSpeed,String fuelType){
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }

    public void displayInfo(){
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
    }
}

class Car extends Vehicle{
    protected int seatCapacity;
    Car(double maxSpeed,String fuelType,int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity=seatCapacity;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Seat Capacity: "+seatCapacity);
    }
}

class Truck extends Vehicle{
    protected double loadCapacity;
    Truck(double maxSpeed,String fuelType,double loadCapacity){
        super(maxSpeed,fuelType);
        this.loadCapacity=loadCapacity;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Load Capacity: "+loadCapacity);
    }
}

class MotorCycle extends Vehicle{
    protected boolean sideCar;
    MotorCycle(double maxSpeed,String fuelType,boolean sideCar){
        super(maxSpeed,fuelType);
        this.sideCar=sideCar;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Has Side Car: "+sideCar);
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[] {
            new Car(200, "Petrol", 5),
            new Truck(120, "Diesel", 10.5),
            new MotorCycle(180, "Petrol", false)
        };

        System.out.println("Vehicle Information:\n");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}
