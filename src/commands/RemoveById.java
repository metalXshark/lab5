package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveById extends Command {
    @Override
    protected void execute(String[] commandName) {
        if (commandName.length == 2) {
            CollectionManager.remove_by_id(commandName[1]);
        }
        else {
            System.out.println("Некорректное количество аргументов. Для справки напишите help.");
        }
    }
}
