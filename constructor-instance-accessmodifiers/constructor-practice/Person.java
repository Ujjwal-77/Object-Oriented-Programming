public class Person {
    private String name;
    private int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    Person(Person other){
        this.name=other.name;
        this.age=other.age;
    }

    public void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    public static void main(String[] args) {
        Person obj=new Person("Ujjwal",21);
        Person obj1=new Person(obj);
    }
}
