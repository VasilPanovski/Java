package main.bg.softuni.contracts;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface DirectoryChanger {

    void changeCurrentDirRelativePath(String relativePath);

    void changeCurrentDirAbsolute(String absolutePath);
}
