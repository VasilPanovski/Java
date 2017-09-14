import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class CreateZIPArchive {
    public static void main(String[] args) throws IOException {

        try(FileOutputStream fileOutput = new FileOutputStream("sources/zippedFiles.zip");
            ZipOutputStream outputZipped = new ZipOutputStream(fileOutput)){

            String pathToFirstFile="sources/words1.txt";
            String pathToSecondFile = "sources/count-chars.txt";
            String pathToThirdFile = "sources/lines.txt";

            addFileToZip(outputZipped, pathToFirstFile);
            addFileToZip(outputZipped, pathToSecondFile);
            addFileToZip(outputZipped, pathToThirdFile);
        }
    }

    private static void addFileToZip(ZipOutputStream outputZipped, String pathToFile) throws IOException {
        try(FileInputStream fileInput = new FileInputStream(pathToFile)){
            ZipEntry zipEntry = new ZipEntry(pathToFile);
            outputZipped.putNextEntry(zipEntry);
            byte[] buffer = new byte[4096];
            int byteReader;
            while ((byteReader = fileInput.read(buffer,0, buffer.length)) >= 0){
                outputZipped.write(byteReader);
            }

        }
    }
}
