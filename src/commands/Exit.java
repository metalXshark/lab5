package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Exit extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.exit();
    }
}
