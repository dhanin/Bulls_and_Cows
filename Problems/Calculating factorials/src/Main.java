import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        // write your code here
        long sum = 1L;
        if (n == 0) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                sum *= i;
            }
        }
        return sum;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}