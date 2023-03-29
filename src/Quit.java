import java.util.Scanner;

public class Quit extends Command {
    @Override
    public String name() {
        return "quit";
    }

    @Override
    public boolean run(Scanner scanner)
    {
        return true;
    }
}
