import java.io.*;

abstract class FileUser {

    protected final String path = System.getProperty("user.dir");
    protected final String _WordList = "/WordList/NZCER-spelling-lists.txt";
    protected final String _StatPath = path + "/.stats.txt";

    protected BufferedReader getWordListBr() {
        InputStream input = getClass().getResourceAsStream(_WordList);
        return new BufferedReader(new InputStreamReader(input));
    }

}
