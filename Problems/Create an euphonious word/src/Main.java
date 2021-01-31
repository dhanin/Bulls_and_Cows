import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int state = 0; //1 - vowel, 0 - consonant
        int count = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (isVowel(str.charAt(0)) == 1) {
                    state = 1;
                    count++;
                } else {
                    state = 0;
                    count++;
                }
            } else if (isVowel(str.charAt(i)) == state ) {
                count++;
            }else {
                state = isVowel(str.charAt(i));
                total += calculateCount(count); //todo
                count = 1; //reset count
            }
        }
        total += calculateCount(count);
        System.out.println(total);
    }
    private static int isVowel(char ch) {
        return "aeiouyAEIOUY".indexOf(ch) != -1 ? 1 : 0;
    }
    private static int calculateCount(int count) {
        if (count % 2 == 0) {
            return count / 2 - 1;
        } else {
            return  count / 2;
        }
    }
}