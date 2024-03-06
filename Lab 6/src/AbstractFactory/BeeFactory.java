package AbstractFactory;

public class BeeFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Bee();
    }
}
