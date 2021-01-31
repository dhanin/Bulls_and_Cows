import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        int seed = 0;
        boolean state = true;
        while (state == true) {
            Random random = new Random(k);
            int count = 0;
            for (int i = 0; i < n; i++) {
                double number = random.nextGaussian();
                if (number <= m) {
                    count++;
                }
                if (count == n) {
                    seed = k;
                    state = false;
                }
            }
            k++;
        }
        System.out.println(seed);
    }
}