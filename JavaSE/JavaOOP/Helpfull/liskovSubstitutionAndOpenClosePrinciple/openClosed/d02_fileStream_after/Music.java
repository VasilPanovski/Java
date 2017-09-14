package liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after.contracts.Streamable;

public class Music implements Streamable {

    private int length;
    private int bytesSent;
    private String artist;
    private String album;

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
