package FactoryMethod;

public class EntityFactory {
    public static Entity createEntity(String type, String name, int HP, int damage) {
        switch (type) {
            case "Villager" -> {
                return new Villager(name, HP);
            }
            case "Warrior" -> {
                return new Warrior(name, HP, damage);
            }
            default -> {
                return null;
            }
        }
    }
}
