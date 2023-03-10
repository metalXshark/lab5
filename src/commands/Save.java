package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Save extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.save();
    }
}
