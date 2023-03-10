package console;

import commands.*;
import commands.manager.*;

import java.io.IOException;
import java.util.Scanner;


public class ConsoleManager {
    public void start() throws IOException {
        CommandManager manager = new CommandManager();

        manager.command("help", new Help());
        manager.command("info", new Info());
        manager.command("show", new Show());
        manager.command("add", new Add());
        manager.command("update", new Update());
        manager.command("remove_by_id", new RemoveById());
        manager.command("clear", new Clear());
        manager.command("save", new Save());

        manager.command("exit", new Exit());
        manager.command("remove_first", new RemoveFirst());
        manager.command("remove_head", new RemoveHead());
        manager.command("history", new History());
        manager.command("min_by_color", new MinByColor());
        manager.command("group_counting_by_name", new GroupCountingByName());
        manager.command("print_field_ascending_killer", new PrintFieldAscendingKiller());

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Введите комманду: ===");
            while (scanner.hasNextLine()) {
                manager.executeCommand(scanner.nextLine().trim().split(" "));
                System.out.println("\n=== Введите комманду: ===");
            }
        }
    }
}
