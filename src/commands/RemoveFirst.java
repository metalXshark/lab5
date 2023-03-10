package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveFirst extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.remove_first();
    }
}
