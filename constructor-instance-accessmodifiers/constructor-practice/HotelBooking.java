public class HotelBooking {
    private String guestname;
    private String roomtype;
    private int nights;
    HotelBooking(){
        guestname="Unknown";
        roomtype="unknown";
        nights=0;
    }

    HotelBooking(String guestname,String roomtype,int nights){
        this.guestname=guestname;
        this.roomtype=roomtype;
        this.nights=nights;
    }

    HotelBooking(HotelBooking other){
        this.guestname=other.guestname;
        this.roomtype=other.roomtype;
        this.nights=other.nights;

    }
    public void displayDetails(){
        System.out.println("Guest Name: "+guestname);
        System.out.println("Room Type: "+roomtype);
        System.out.println("Nights: "+nights);
    }
    public static void main(String[] args) {
        HotelBooking defaultbook=new HotelBooking();
        defaultbook.displayDetails();

        HotelBooking customBooking=new HotelBooking("Ujjwal","Deluxe",2);
        customBooking.displayDetails();
        
        HotelBooking copyBooking=new HotelBooking(customBooking);
        copyBooking.displayDetails();
    }
}
