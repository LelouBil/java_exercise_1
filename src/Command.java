import java.util.Scanner;

public abstract class Command {

    public abstract  String name();

    public abstract boolean run(Scanner scanner);
}
