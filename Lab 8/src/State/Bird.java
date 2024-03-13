package State;

public class Bird {
    BirdState state;

    public Bird() {
        this.state = new StayBirdState();
    }

    public BirdState getState() {
        return state;
    }

    public void setState(BirdState state) {
        this.state = state;
    }

    public void fly() {
        if (this.state.onFly()) {
            this.state = new FlyBirdState();
        }
    }

    public void stay() {
        if (this.state.onStay()) {
            this.state = new StayBirdState();
        }
    }

    public void eat() {
        if (this.state.onEat()) {
            this.state = new EatBirdState();
        }
    }
}
