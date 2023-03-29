import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Hello !");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(!input.equals("quit")){
            System.out.println("Unknown command");
        }
    }
}
