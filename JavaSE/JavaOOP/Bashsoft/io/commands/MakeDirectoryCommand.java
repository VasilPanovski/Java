package main.bg.softuni.io.commands;

import main.bg.softuni.anotation.Alias;
import main.bg.softuni.anotation.Inject;
import main.bg.softuni.contracts.DirectoryManager;
import main.bg.softuni.exceptions.InvalidInputException;

@Alias("mkdir")
public class MakeDirectoryCommand extends Command {

    @Inject
    private DirectoryManager directoryManager;

    public MakeDirectoryCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String folderName = data[1];
        this.directoryManager.createDirectoryInCurrentFolder(folderName);
    }
}
