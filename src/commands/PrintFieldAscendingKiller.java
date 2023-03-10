package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class PrintFieldAscendingKiller extends Command {

    @Override
    protected void execute(String[] commandName) {
        CollectionManager.print_field_ascending_killer();
    }
}
