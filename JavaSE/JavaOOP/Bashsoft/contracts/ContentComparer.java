package main.bg.softuni.contracts;

import java.io.IOException;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface ContentComparer {

    void compareContent(
            String actualOutput,
            String expectedOutput) throws IOException;
}
