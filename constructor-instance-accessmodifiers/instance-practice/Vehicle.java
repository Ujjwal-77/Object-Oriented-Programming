public class Vehicle {
    private String ownername;
    private String vehicletype;
    private static int fee=500;

    Vehicle(String ownername,String vehicletype){
        this.ownername=ownername;
        this.vehicletype=vehicletype;
    }

    public void displayVehicleDetails(){
        System.out.println("Owner Name: "+ownername);
        System.out.println("Vehicle Type: "+vehicletype);
        System.out.println("Fee: "+fee);
    }

    public void updateRegistrationFee(int updatedfee){
        fee=updatedfee;
    }
    public static void main(String[] args) {
        Vehicle obj=new Vehicle("Ujjwal","Racing");
        obj.displayVehicleDetails();
        obj.updateRegistrationFee(1000);
        obj.displayVehicleDetails(); 
    }
}
