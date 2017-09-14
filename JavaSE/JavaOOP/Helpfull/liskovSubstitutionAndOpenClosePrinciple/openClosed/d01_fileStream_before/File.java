package liskovSubstitutionAndOpenClosePrinciple.openClosed.d01_fileStream_before;

public class File {

    private String name;
    private int length;
    private int bytesSent;

    public int getLength() {
        return length;
    }

    public int getBytesSent() {
    return bytesSent;
    }
}
