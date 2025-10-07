
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.junit.Test;

/**
 *
 * @author jadan
 */
public class TestFTP {

    @Test
    public void run() throws IOException {
        FTPClient ftp = new FTPClient();
        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);
        String server = "61.244.87.154";
        ftp.connect(server);
//            ftp.login("anonymous", "anonymous");
        ftp.login("jaden", "jaden12--");

        File file = new File("/Users/jadan/javaLesson36.zip");
        System.out.println(file.getPath());
        String localFilePath = file.getPath();
        String remoteFilePath = "/" + file.getName();
        try (FileInputStream inputStream = new FileInputStream(file)) {
            boolean success = ftp.storeFile(remoteFilePath, inputStream);
            System.out.println(success);
        }
        System.out.println(ftp.listFiles());
    }
}
