package main.bg.softuni.contracts;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface AsynchDownloader {

    void downloadOnNewThread(String fileUrl);
}
