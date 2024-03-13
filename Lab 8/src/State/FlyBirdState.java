package State;

public class FlyBirdState implements BirdState {
    @Override
    public boolean onFly() {
        System.out.println("Bird is already flying");
        return false;
    }

    @Override
    public boolean onStay() {
        System.out.println("Bird is staying now");
        return true;
    }

    @Override
    public boolean onEat() {
        System.out.println("Bird cannot fly and eat together");
        return false;
    }
}
