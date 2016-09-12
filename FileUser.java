import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

abstract class FileUser {

    protected final String path = System.getProperty("user.dir");
    protected final String _WordList = "/WordList/NZCER-spelling-lists.txt";
    protected final String _StatPath = path + "/.stats.txt";

    protected BufferedReader getBr(String filePath) {
        InputStream input = getClass().getResourceAsStream(filePath);
        return new BufferedReader(new InputStreamReader(input));
    }

}
