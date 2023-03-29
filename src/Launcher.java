import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Hello !");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                running = false;
            } else if (input.equals("fibo")) {
                fibo(scanner);
            } else {
                System.out.println("Unknown command");
            }
        } while (running);
    }

    private static void fibo(Scanner scanner) {
        System.out.print("Nombre : ");
        int num = scanner.nextInt();
        scanner.nextLine();
        int a = 0;
        int b = 1;
        if (num == 0) {
            System.out.println(a);
        } else if (num == 1) {
            System.out.println(b);
        } else {
            for (int i = 2; i <= num; i++) {
                int n = a + b;
                a = b;
                b = n;
            }
            System.out.println(b);
        }
    }
}
