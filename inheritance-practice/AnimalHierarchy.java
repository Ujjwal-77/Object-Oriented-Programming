class Animal{
    protected String name;
    protected int age;

    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void makeSound(){
        System.out.println("");
    }
    public void displayInfo(){
        System.out.println("Name: "+name+"Age: "+age);
    }
}

class Dog extends Animal{
    Dog(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println("Bark");
    }
}

class Bird extends Animal{
    Bird(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
}

class Cat extends Animal{
    Cat(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println("chirp");
    }
}



public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal myDog = new Dog("Buddy", 3);
        Animal myCat = new Cat("Whiskers", 2);
        Animal myBird = new Bird("Tweety", 1);

        myDog.displayInfo();
        myDog.makeSound();

        myCat.displayInfo();
        myCat.makeSound();

        myBird.displayInfo();
        myBird.makeSound();
    }
}
