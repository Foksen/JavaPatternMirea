package Prototype;

public class Van extends Car {
    private int capacity;

    public Van(Van target) {
        super(target);
        if (target != null) {
            this.capacity = target.capacity;
        }
    }

    public Van(int speed, String model, int capacity) {
        super(speed, model);
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Грузовик: скорость: " + getSpeed() + ", модель: " + getModel() + ", вместимость: " + capacity;
    }

    @Override
    public Van clone() {
        return new Van(this);
    }
}
