package liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after.contracts.Streamable;

public class File implements Streamable {

    private String name;
    private int length;
    private int bytesSent;

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
