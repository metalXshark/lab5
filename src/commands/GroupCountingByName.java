package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class GroupCountingByName extends Command {

    @Override
    protected void execute(String[] commandName) {
        CollectionManager.group_counting_by_name();
    }
}
