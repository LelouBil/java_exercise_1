import java.util.Scanner;

public class Fibo extends Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner)
    {
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
        return false;
    }
}
