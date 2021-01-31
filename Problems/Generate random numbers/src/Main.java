import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int num = scanner.nextInt();
        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        int ranNum;
        int sum = 0;
        Random random = new Random(lower + upper);
        for (int i = 0; i < num; i++) {

            ranNum = random.nextInt(upper - lower + 1) + lower;
            sum += ranNum;
        }
        System.out.println(sum);
    }
}