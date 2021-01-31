import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                count++;
                continue;
            } else if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                System.out.printf("%c%d", str.charAt(i - 1), count);
                count = 1;
            }
        }
        System.out.printf("%c%d", str.charAt(str.length() - 1), count);
    }
}