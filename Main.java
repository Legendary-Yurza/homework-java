import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random newRandom = new Random();
        int number = newRandom.nextInt(9);
        System.out.println("Угадай число от 0 до 9: ");
        Scanner newScanner = new Scanner(System.in);
        int sas = scanner.nextInt();
        if (sas > number || sas < number) {
            for (int schetchik = 2; schetchik > 0; schetchik--) {

                System.out.println("Угадай число от 0 до 9");

                if (sas > number) {
                    System.out.println(" Загаданное число меньше. Осталось попыток: " + schetchik);
                    Scanner Secscanner = new Scanner(System.in);
                    int scannerS = Secscanner.nextInt();
                    sas = scannerS;
                } else if (sas < number) {
                    System.out.println("Загаданное число больше. Осталось попыток: " + schetchik);
                    Scanner ThScanner = new Scanner(System.in);
                    int scannerT = ThScanner.nextInt();
                    sas = scannerT;
                }
            }
                if (sas == number) {
                    System.out.println("Ты победил! Гратц");
                }
                if (sas > number || sas < number) {
                    System.out.println("Ты проиграл! Бывает");
                }
            }
        }
    }

