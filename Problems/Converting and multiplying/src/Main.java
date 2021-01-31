import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input;
        StringBuilder str = new StringBuilder();
        do {
            input = scanner.nextLine();
            str.append(input).append(" ");
        } while(!input.toString().equals("0"));

        String[] strArr = str.toString().split(" ");
        String temp = null;
            for (int i = 0; i < strArr.length - 1; i++) {
                try {
                    temp = new String(strArr[i]);
                    int num = Integer.parseInt(strArr[i]);
                    num *= 10;
                    System.out.println(num);
                } catch (RuntimeException e) {
                    System.out.println("Invalid user input: " + temp);
            }

        }

    }
}