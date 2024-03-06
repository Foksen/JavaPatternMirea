package FactoryMethod;

public class Warrior extends Entity {
    private String name;
    private int HP;
    private int damage;

    public Warrior(String name, int HP, int damage) {
        this.name = name;
        this.HP = HP;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHP() {
        return this.HP;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
