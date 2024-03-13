import State.Bird;
import Strategy.GeneratingStrategy;
import Strategy.InputStrategy;
import Strategy.Summator;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.eat();
        bird.stay();
        bird.eat();
        bird.eat();

        Summator summator = new Summator();
        summator.collectNumbers(new InputStrategy(), 5);
        System.out.println("Numbers sum: " + summator.getNumbersSum());
        summator.collectNumbers(new GeneratingStrategy(), 5);
        System.out.println("Numbers sum: " + summator.getNumbersSum());
    }
}