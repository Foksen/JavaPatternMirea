package AbstractFactory;

public class Bee implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Buzz!");
    }
}
