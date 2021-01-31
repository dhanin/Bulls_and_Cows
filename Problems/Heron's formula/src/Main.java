import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        double s;
        double p;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        p = (double)(a + b +c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(s);

    }
}