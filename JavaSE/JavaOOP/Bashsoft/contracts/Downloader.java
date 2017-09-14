package main.bg.softuni.contracts;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface Downloader extends AsynchDownloader {

    void download(String fileUrl);
}
