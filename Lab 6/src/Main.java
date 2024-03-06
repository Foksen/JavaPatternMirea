import AbstractFactory.*;
import Builder.Student;
import Builder.StudentBuilder;
import FactoryMethod.Entity;
import FactoryMethod.EntityFactory;
import FactoryMethod.Villager;
import FactoryMethod.Warrior;
import Prototype.Car;
import Prototype.Van;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(EntityFactory.createEntity("Villager", "Igor", 50, 0));
        entities.add(EntityFactory.createEntity("Warrior", "Anton", 70, 15));
        entities.add(EntityFactory.createEntity("Villager", "Ivan", 30, 0));
        for (Entity entity : entities) {
            System.out.println(entity);
        }

        ArrayList<Animal> animals = new ArrayList<Animal>();
        AnimalFactory animalFactory = new CatFactory();
        animals.add(animalFactory.createAnimal());
        animalFactory = new DogFactory();
        animals.add(animalFactory.createAnimal());
        animalFactory = new BeeFactory();
        animals.add(animalFactory.createAnimal());
        for (Animal animal : animals) {
            animal.makeSound();
        }

        StudentBuilder builder = new StudentBuilder();
        builder.setId(1)
                .setFirstname("Igor")
                .setLastname("Zholobov")
                .setAvgMark(4.8);
        Student student1 = builder.getResult();
        builder.setId(2)
                .setFirstname("Anton")
                .setLastname("Smirnov")
                .setAvgMark(4.5);
        Student student2 = builder.getResult();
        System.out.println(student1);
        System.out.println(student2);

        Car car1 = new Car(150, "BWM");
        Car car2 = car1.clone();
        car1.setSpeed(200);
        car1.setModel("Porshe");
        System.out.println(car1);
        System.out.println(car2);
        Van van1 = new Van(100, "Volvo", 550);
        Van van2 = van1.clone();
        van1.setSpeed(90);
        van1.setModel("Peterbilt");
        van1.setCapacity(750);
        System.out.println(van1);
        System.out.println(van2);
    }
}