class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false;
    }

    public void bookTicket(String seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName);
        } else {
            System.out.println("Ticket is already booked.");
        }
    }

    public void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("No ticket booked for " + movieName);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Transformers");

        ticket.displayTicketDetails();
        ticket.bookTicket("A12", 12.5);
        ticket.displayTicketDetails();
    }
}
