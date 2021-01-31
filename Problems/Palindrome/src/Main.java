import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder temp = new StringBuilder();
        temp.append(string);
        temp.reverse();
        if (string.toString().equals(temp.toString())) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}