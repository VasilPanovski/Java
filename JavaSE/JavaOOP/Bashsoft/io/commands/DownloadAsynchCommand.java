package main.bg.softuni.io.commands;

import main.bg.softuni.anotation.Alias;
import main.bg.softuni.anotation.Inject;
import main.bg.softuni.contracts.Downloader;
import main.bg.softuni.exceptions.InvalidInputException;

@Alias("downloadasynch")
public class DownloadAsynchCommand extends Command {

    @Inject
    private Downloader downloader;

    public DownloadAsynchCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileUrl = data[1];
        this.downloader.downloadOnNewThread(fileUrl);
    }
}
