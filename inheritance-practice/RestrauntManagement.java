class Person{
    protected String name;
    protected double id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

interface Worker{
    public void performDuties();
}

class Chef extends Person implements Worker{
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes in the kitchen.");
    }
}

class Waiter extends Person implements Worker{
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }
}

public class RestrauntManagement {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Gordon Ramsay", 101, "Italian");
        Waiter waiter1 = new Waiter("John Doe", 201, 5);

        System.out.println(" Chef Details:");
        chef1.displayInfo();
        chef1.performDuties();

        System.out.println("\n Waiter Details:");
        waiter1.displayInfo();
        waiter1.performDuties();
    }
}
