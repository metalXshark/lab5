package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Clear extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.clear();
    }
}
