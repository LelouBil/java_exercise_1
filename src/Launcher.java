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
            }else{
                System.out.println("Unknown command");
            }
        } while (running);
    }
}
