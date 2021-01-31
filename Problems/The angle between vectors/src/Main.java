import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ai = scanner.nextInt();
        int aj = scanner.nextInt();
        int bi = scanner.nextInt();
        int bj = scanner.nextInt();

        double lengthA = Math.sqrt(ai * ai + aj * aj);
        double lengthB = Math.sqrt(bi * bi + bj *  bj);
        double dotAB = ai * bi + aj * bj;

        double cosO = dotAB / (lengthA * lengthB);
        double radian = Math.acos(cosO);

        System.out.println(Math.toDegrees(radian));


    }
}