package liskovSubstitutionAndOpenClosePrinciple.openClosed.d01_fileStream_before;

public class Music {

    private String artist;
    private String album;
    private int length;
    private int bytesSent;

    public int getLength() {
        return length;
    }

    public int getBytesSent() {
        return bytesSent;
    }
}
