package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class RemoveHead extends Command {
    @Override
    protected void execute(String[] commandName) {
        CollectionManager.remove_head();
    }
}
