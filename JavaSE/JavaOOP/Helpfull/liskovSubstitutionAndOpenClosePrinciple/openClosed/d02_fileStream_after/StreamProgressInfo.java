package liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after;

import liskovSubstitutionAndOpenClosePrinciple.openClosed.d02_fileStream_after.contracts.Streamable;

public class StreamProgressInfo {

    private Streamable streamable;

    public StreamProgressInfo(Streamable streamResult) {
        this.streamable = streamResult;
    }

    public int calculateStreamProgress() {
        return (this.streamable.getBytesSent() * 100) / this.streamable.getLength();
    }
}
