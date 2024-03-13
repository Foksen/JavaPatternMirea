package State;

public class EatBirdState implements BirdState {
    @Override
    public boolean onFly() {
        System.out.println("Bird cannot eat and fly together");
        return false;
    }

    @Override
    public boolean onStay() {
        System.out.println("Bird is staying now");
        return true;
    }

    @Override
    public boolean onEat() {
        System.out.println("Bird is already eating");
        return false;
    }
}
