package State;

public class StayBirdState implements BirdState {
    @Override
    public boolean onFly() {
        System.out.println("Bird is flying now");
        return true;
    }

    @Override
    public boolean onStay() {
        System.out.println("Bird is already staying");
        return false;
    }

    @Override
    public boolean onEat() {
        System.out.println("Bird is eating now");
        return true;
    }
}
