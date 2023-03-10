package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Info extends Command {

    @Override
    protected void execute(String[] commandName) {
        CollectionManager.info();
    }
}
