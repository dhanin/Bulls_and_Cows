import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        char[] chArr =  num.toCharArray();
        int first =  Character.getNumericValue(chArr[0]) + Character.getNumericValue(chArr[1]) + Character.getNumericValue(chArr[2]);
        int second = Character.getNumericValue(chArr[3]) + Character.getNumericValue(chArr[4]) + Character.getNumericValue(chArr[5]);
        if (first == second) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }

    }
}