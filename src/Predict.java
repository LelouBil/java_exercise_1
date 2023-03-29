import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Predict extends Command {
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Chemin du fichier de lexique : ");
        Path path = Path.of(scanner.nextLine());
        try {
            String content = Files.readString(path);
            Map<String, Map<String, Integer>> data = new HashMap<>();
            List<String> words = Arrays.stream(content
                            .replaceAll("[^a-zA-Z0-9]", " ")
                            .toLowerCase().split(" "))
                    .filter(s -> !s.isBlank())
                    .toList();
            List<String> distinctWords =
                    words
                            .stream()
                            .distinct()
                            .toList();
            Map<String, Integer> subMap = new HashMap<>();
            for (String word : distinctWords) {
                subMap.put(word, 0);
            }
            for (String word : distinctWords) {
                data.put(word, new HashMap<>(subMap));
            }
            for (int i = 0; i < words.size() - 1; i++) {
                String word = words.get(i);
                String next = words.get(i + 1);
                var wordMap = data.get(word);
                wordMap.replace(next, wordMap.get(next) + 1);
            }
            Map<String, String> analyzed =
                    data
                            .entrySet()
                            .stream()
                            .map(e -> Map.entry(e.getKey(),
                                    e.getValue()
                                            .entrySet()
                                            .stream()
                                            .max(Comparator.comparingInt(Map.Entry::getValue))
                                            .map(Map.Entry::getKey)
                                            .get()
                            ))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            System.out.println("Premier mot : ");
            String word = scanner.nextLine();
            if (analyzed.containsKey(word)) {
                StringBuilder builder = new StringBuilder();
                builder.append(word).append(" ");
                for (int i = 0; i < 20; i++) {
                    word = analyzed.get(word);
                    builder.append(word).append(" ");
                }
                System.out.println(builder);
            } else {
                System.out.println("Le mot n'existe pas dans le texte");
            }
        } catch (IOException e) {
            System.out.printf("Unreadable file : %s : %s%n", e.getClass().getSimpleName(), e.getMessage());
        }
        return false;
    }
}
