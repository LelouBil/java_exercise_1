import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Hello !");
        Scanner scanner = new Scanner(System.in);
        List<Command> commandList = List.of(
                new Quit(),
                new Fibo(),
                new Freq(),
                new Predict()
        );
        AtomicBoolean running = new AtomicBoolean(true);
        do {
            String input = scanner.nextLine();
            commandList
                    .stream()
                    .filter(c -> c.name().equals(input))
                    .findFirst()
                    .ifPresentOrElse(
                            c -> running.set(!c.run(scanner)),
                            () -> System.out.println("Unknown command")
                    );
        } while (running.get());
    }

}
