package FactoryMethod;

public abstract class Entity {
    public abstract String getName();

    public abstract int getHP();

    public abstract int getDamage();

    @Override
    public String toString() {
        return "Name: " + getName() + "\tHP: " + getHP() + "\tDamage: " + getDamage();
    }
}
