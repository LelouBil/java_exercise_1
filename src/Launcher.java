import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Hello !");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            String input = scanner.nextLine();
            switch (input) {
                case "quit" -> running = false;
                case "fibo" -> fibo(scanner);
                case "freq" -> freq(scanner);
                default -> System.out.println("Unknown command");
            }
        } while (running);
    }

    private static void freq(Scanner scanner) {
        System.out.println("Chemin du fichier a scanner : ");
        Path path = Path.of(scanner.nextLine());
        try {
            String content = Files.readString(path);
            content = content
                    .replaceAll("[^a-zA-Z0-9]"," ")
                    .toLowerCase();
            List<String> words = Arrays.stream(content.split(" "))
                    .filter(s -> !s.isBlank())
                    .collect(Collectors.groupingBy(s -> s))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt((Map.Entry<String,List<String>> e) -> e.getValue().size()).reversed())
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .toList();
            System.out.println(String.join(" ", words));
        } catch (IOException e) {
            System.err.printf("Unreadable file : %s : %s%n", e.getClass().getSimpleName(), e.getMessage());
        }
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
