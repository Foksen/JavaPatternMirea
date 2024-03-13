package Strategy;

import java.util.Arrays;

public class Summator {
    private int[] numbers;

    public Summator() {
        numbers = null;
    }

    public Summator(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getNumbersSum() {
        if (numbers == null)
            return 0;
        return Arrays.stream(numbers).sum();
    }

    public void collectNumbers(Strategy strategy, int n) {
        numbers = strategy.getNumbers(n);
    }
}
