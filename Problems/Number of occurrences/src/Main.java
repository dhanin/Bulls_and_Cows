import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String findStr = scanner.nextLine();

        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1 ) {
                count++;
                lastIndex += findStr.length();
            }
        }
        System.out.println(count);
    }
}