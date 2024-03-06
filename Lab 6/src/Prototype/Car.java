package Prototype;

public class Car implements VehiclePrototype {
    private int speed;
    private String model;

    public Car(Car target) {
        if (target != null) {
            this.speed = target.getSpeed();
            this.model = target.getModel();
        }
    }

    public Car(int speed, String model) {
        this.speed = speed;
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public String getModel() {
        return model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Автомобиль: скорость: " + speed + ", модель: " + model;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }
}
