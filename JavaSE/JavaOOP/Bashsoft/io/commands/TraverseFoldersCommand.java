package main.bg.softuni.io.commands;

import main.bg.softuni.anotation.Alias;
import main.bg.softuni.anotation.Inject;
import main.bg.softuni.contracts.DirectoryManager;
import main.bg.softuni.exceptions.InvalidInputException;

@Alias("ls")
public class TraverseFoldersCommand extends Command {

    @Inject
    private DirectoryManager directoryManager;

    public TraverseFoldersCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1 && data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 1) {
            this.directoryManager.traverseDirectory(0);
            return;
        }

        this.directoryManager.traverseDirectory(Integer.valueOf(data[1]));
    }
}
