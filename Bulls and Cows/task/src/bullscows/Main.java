package bullscows;
import java.util.*;

public class Main {

    static int numChar;
    static int numCode;


    public static void main(String[] args) {
       String code = getCodeLengthAndGenCode();
       if (code == null) {
           return;
       }
       //System.out.println(code);
       printHint(code);
       startHere(code);
    }

    private static void printHint(String code) {
        int length = code.length();
        boolean hasDigit = false;
        boolean hasAlphabet = false;

        if (numChar >= 1) {
            hasDigit = true;
        }
        if (numChar >= 11 ) {
            hasAlphabet = true;
        }
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.print(" (");
        if (hasDigit == true) {
            int lower = 0;
            int upper = numChar < 11 ? numChar-1 : 9;
            System.out.printf("%d-%d",lower,upper);
        }
        if (hasAlphabet == true) {
            System.out.printf(", a-%c", numChar - 11 + 97);
        }
        System.out.print(").");
        System.out.println();;


    }

    public static String getCodeLengthAndGenCode() {

        boolean state = true;
        StringBuilder charCode = new StringBuilder();
        StringBuilder numberCode = new StringBuilder();
        StringBuilder secretCode = new StringBuilder();
        String tempChar;
        int lengthSecretCode;
        //int numChar;
        int countCode = 0;
        int countChar = 0;
        int countNum = 0;
        char ch; //char random 0-9 and a-z

        lengthSecretCode = getSecretCodeLength();
        if (lengthSecretCode == 0) {
            return null;
        }
        numChar = getMaxCharAvailableInSecretCode();
        if (numChar == 0) {
            return null;
        }
        if (numCode > numChar) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.",numCode,numChar);
            return null;
        }
        Random random = new Random(lengthSecretCode); //todo delete seed here
        while (countCode < lengthSecretCode) {

            ch = (char) randomChar(random, countNum, lengthSecretCode);
            if (ch >= 'a' && ch <= 'z') {
                if (countChar >= numChar) {
                    continue;
                }
                else {
                    StringBuilder nextCode =  new StringBuilder();
                    nextCode = getNextCode(countCode, secretCode, ch);
                    if(isUnique(nextCode.toString()) == true) {
                        secretCode.append(ch);
                        countCode++;
                        countChar++;
                        charCode.append(ch);
                        charCode = new StringBuilder(sorString(charCode.toString()));
                    } else {
                        continue;
                    }
                }
            } else {
                StringBuilder nextCode =  new StringBuilder();
                nextCode = getNextCode(countCode, secretCode, ch);
                if(isUnique(nextCode.toString()) == true) {
                    secretCode.append(ch);
                    countCode++;
                    countNum++;
                    numberCode.append(ch);
                    numberCode = new StringBuilder(sorString(numberCode.toString()));
                } else {
                    continue;
                }

            }
        }
        return String.valueOf(secretCode);

    }
    public static StringBuilder getNextCode(int countCode, StringBuilder secretCode, char ch) {
        StringBuilder tempCode =  new StringBuilder();
        if (countCode > 0) {
            tempCode.append(secretCode).append(ch);
        } else {
            tempCode.append(ch);
        }
        return tempCode;
    }
    public static String sorString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public static int getSecretCodeLength() {
        //int numCode;
        String temp = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Input the length of the secret code:");
            temp = scanner.nextLine();
            if (temp.matches(".*[a-z].*")  || temp.toString().equals("0")) {
                System.out.printf("Error: \"%s\" isn't a valid number.",temp);
                return 0;
            }
            numCode = Integer.parseInt(temp);

            if (numCode > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } } while(numCode > 36 || numCode < 1);
        return numCode;
    }
    public static int getMaxCharAvailableInSecretCode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the number of possible symbols in the code:");
        numChar = scanner.nextInt();
        if (numChar > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return 0;
        } else {
            return numChar;
        }
    }
    public static int randomChar(Random randomSeed, int countNum, int lengthSecretCode) {
        int lower = 0;
        int upper = 35;


        int number;

        if (lengthSecretCode == 1) {
            number = randomSeed.nextInt(10);
            return number + 48;
        }

        if (countNum <= 10) {
            number = randomSeed.nextInt(upper-lower+1) + lower;
            if (number >= 0 && number <= 9) {
                return number + 48; // ascii code 0-9
            } else {
                return number + 87;
            }
        } else {
            lower = 0;
            upper = 25;
            number = randomSeed.nextInt(upper-lower+1) + lower;
            return number + 97; // ascii code a-z
        }
    }
    public static boolean isUnique(String input) {
        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();
        for (char ch:chars
             ) {
            if (!set.add(ch)) {
                return false;
            }

        }
        return true;
    }
    public static void startHere(String code)
    {
        Scanner scanner = new Scanner(System.in);
        int[] countBullsCows = new int[] {0,0};
        int turn = 1;
        int length = code.length();
        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n",turn++);
            String number = scanner.next();
            countBullsCows = countBullsCows(code, number);
            if (countBullsCows[0] == 0 && countBullsCows[1] == 0) {
                System.out.println("Grade: None.");
            } else if (countBullsCows[0] == 0) { //no bulls, but cows
                System.out.println("Grade: " + countBullsCows[1] + " cow(s).");
            } else if (countBullsCows[1] == 0) { //no cows, but bulls
                System.out.println("Grade: " + countBullsCows[0] + " bull(s).");
            } else { //have bulls and cows
                System.out.println("Grade: " + countBullsCows[0] + " bull(s) and " + countBullsCows[1] + " cow(s).");
            }
            if (countBullsCows[0] == length)
            {
                System.out.println("Congratulations! You guessed the secret code.");
            }
        } while (countBullsCows[0] < length);
    }
    public static int[] countBullsCows(String code_,String number_) {
        int[] countBullsCows = new int[]{0,0};
        StringBuilder code = new StringBuilder(code_);
        StringBuilder number = new StringBuilder(number_);
        for (int i = 0; i < code.length(); i++) { //count bulls
            if (number.charAt(i) == code.charAt(i)) {
                countBullsCows[0]++;
                code.setCharAt(i,'*');
                number.setCharAt(i,'*');
            }
        }
        for (int i = 0; i < code.length(); i++) { //count cows
            for (int k = 0; k < code.length(); k++) {
                if (number.charAt(i) != '*' && number.charAt(i) == code.charAt(k)) {
                    number.setCharAt(i,'*');
                    code.setCharAt(k,'*');
                    countBullsCows[1]++;
                }
            }
        }
        return countBullsCows;
    }
    public static int[] toArrayInt(int input)
    {
        String str = Integer.toString(input);
        int[] number = new int[str.length()];
        char[] chArr = new char[str.length()];
        chArr = str.toCharArray();

        for(int i = 0; i < str.length(); i++)
        {
            number[i] = Character.getNumericValue(chArr[i]);
        }
        return number;

    }
}

