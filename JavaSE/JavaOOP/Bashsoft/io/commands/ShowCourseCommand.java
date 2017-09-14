package main.bg.softuni.io.commands;

import main.bg.softuni.anotation.Alias;
import main.bg.softuni.anotation.Inject;
import main.bg.softuni.contracts.Database;
import main.bg.softuni.exceptions.InvalidInputException;

@Alias("show")
public class ShowCourseCommand extends Command {

    @Inject
    private Database database;

    public ShowCourseCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.database.getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.database.getStudentMarkInCourse(courseName, userName);

    }
}
