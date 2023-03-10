package commands;

import collection.CollectionManager;
import commands.manager.Command;

public class MinByColor extends Command {

    @Override
    protected void execute(String[] commandName) {
        CollectionManager.min_by_color();
    }
}
