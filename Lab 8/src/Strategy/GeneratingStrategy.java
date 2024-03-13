package Strategy;

import java.util.Random;

public class GeneratingStrategy implements Strategy {
    @Override
    public int[] getNumbers(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            numbers[i] = random.nextInt();
        }
        return numbers;
    }
}
