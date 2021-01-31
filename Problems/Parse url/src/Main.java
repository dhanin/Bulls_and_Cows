import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String parameters = url.split("\\?")[1];
        String[] keyValue = parameters.split("&");
        String empty = "not found";
        String value;
        String password = "";
        for (int i = 0; i < keyValue.length; i++) {
            String[] pair =  keyValue[i].split("=");
            if (pair[0].toString().equals("pass")) {
                password = new String(pair[1]);
            }
            if (pair.length == 1)  {
                value = empty;
            } else {
                value = pair[1];
            }
            System.out.println(pair[0] + " : " + value);
        }
        if (password.length() > 0) {
            System.out.println("password : " + password);
        }
    }
}