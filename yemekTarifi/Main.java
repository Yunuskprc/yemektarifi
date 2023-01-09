import java.util.Scanner;

public class Main {

    static String[] malzemeler = new String[20];

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int i = 0;

        for (int j = 0; j < 20; j++) {
            malzemeler[j] = "*";
        }

        System.out.println("Hoşgeldiz elinizdeki malzemeleri girin (çıkmak için 1 e basin)\n");
        while (true) {
            malzemeler[i] = scann.next();
            if (malzemeler[i].equals("1")) {
                break;
            }
            i++;
        }

        yemekbul nesYemekbul = new yemekbul();
        nesYemekbul.ybul();

    }
}