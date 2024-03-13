package Strategy;

import java.util.Scanner;

public class InputStrategy implements Strategy {

    @Override
    public int[] getNumbers(int n) {
        int[] numbers = new int[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; ++i) {
            System.out.printf("Input number %d: ", i + 1);
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }
}
