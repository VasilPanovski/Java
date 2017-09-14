import java.io.*;
import java.net.URL;
import java.nio.file.Files;

public class CopyJpgFile {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://cdn.superbwallpapers.com/wallpapers/cartoons/despicable-me-2-22540-1280x800.jpg");
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream("sources/my-copied-picture.jpg");

            byte[] buffer = new byte[4096];
            int length;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Can not found the file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

