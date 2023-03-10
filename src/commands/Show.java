package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class Show extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.show();
    }
}
