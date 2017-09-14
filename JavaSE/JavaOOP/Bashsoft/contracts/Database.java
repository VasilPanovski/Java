package main.bg.softuni.contracts;

import java.io.IOException;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface Database extends Requester, OrderedTaker, FilteredTaker {

    void loadData(String fileName) throws IOException;
    void unloadData();
}
