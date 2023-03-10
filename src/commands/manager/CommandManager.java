package commands.manager;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, Command> commandMap = new HashMap<>();
    private static final ArrayList<String> commandHistory = new ArrayList<>();

    public void command(String name, Command command) {
        commandMap.put(name, command);
    }
    public void executeCommand(String[] commandName) {
        try {
            commandHistory.add(commandName[0]);
            Command command = commandMap.get(commandName[0]);
            command.execute(commandName);
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("Не существует команды \"" + commandName[0] + "\"\nДля справки используйте – help");
        }
    }
    public static ArrayList<String> getCommandHistory(){
        return commandHistory;
    }
}
