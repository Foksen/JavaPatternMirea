package FactoryMethod;

public class Villager extends Entity {
    private String name;
    private int HP;

    public Villager(String name, int HP) {
        this.name = name;
        this.HP = HP;
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
        return 0;
    }
}
