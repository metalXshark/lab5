package commands;

import collection.CollectionManager;
import commands.manager.Command;
import commands.manager.CreateObject;

public class Add extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.add(CreateObject.createDragon());
        System.out.println("Элемент успешно добавлен в коллекцию.");
    }
}
