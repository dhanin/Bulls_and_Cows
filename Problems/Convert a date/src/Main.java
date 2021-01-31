import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split("-");
        System.out.println(split[1] + "/" + split[2] + "/" + split[0]);
    }
}