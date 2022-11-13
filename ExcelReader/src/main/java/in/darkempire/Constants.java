package in.darkempire;

import java.io.File;
import java.net.URL;

public class Constants {
    public static String RESOURCE_BASE_PATH = "main/resources/";

    public File getResourceFile(final String fileName) {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);
        if (url == null) {
            throw new IllegalArgumentException(fileName + " is not found 1");
        }
        File file = new File(url.getFile());
        return file;
    }
}
