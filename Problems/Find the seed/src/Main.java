import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int a_ = a;

        int[] value = new int[n];
        int[][] output = new int[b-a+1][2];

        while (a <= b) {
            Random random = new Random(a);
            for (int i = 0; i < n; i++) {
                value[i] = random.nextInt(k);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = value[i] > max ? value[i] : max;
            }
            output[b-a][0] = a; //keep seed
            output[b-a][1] = max; //keep max value of this seed
            a++;
        }
        int min = k;
        int seed = 0;
        for (int i = 0; i < b-a_+1; i++) {

            for (int j = 0; j < 2; j++) {

                if (output[i][1] <= min) {
                    min = output[i][1];
                    seed = output[i][0];
                }
            }
        }
        System.out.println(seed);
        System.out.println(min);
    }
}