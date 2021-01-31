// write your class here
import java.util.Scanner;
class Main {

    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        account.ownerName = scanner.next();
        System.out.println(account.balance + " " + account.locked + " " + account.ownerName);
    }
    public static class Account {
        long balance;
        String ownerName;
        boolean locked;
    }
}


