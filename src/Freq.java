import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Freq extends Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {

        System.out.println("Chemin du fichier a scanner : ");
        Path path = Path.of(scanner.nextLine());
        try {
            String content = Files.readString(path);
            content = content
                    .replaceAll("[^a-zA-Z0-9]", " ")
                    .toLowerCase();
            List<String> words = Arrays.stream(content.split(" "))
                    .filter(s -> !s.isBlank())
                    .collect(Collectors.groupingBy(s -> s))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt((Map.Entry<String, List<String>> e) -> e.getValue().size()).reversed())
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .toList();
            System.out.println(String.join(" ", words));
        } catch (IOException e) {
            System.err.printf("Unreadable file : %s : %s%n", e.getClass().getSimpleName(), e.getMessage());
        }

        return false;
    }
}
