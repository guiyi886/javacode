package javaLow.作业6.forth;

/**
 * @author guiyi
 * @Date 2023/12/29 16:28:20
 * @ClassName javaLow.作业6.forth.Config
 * @function -->
 */
public class Config {
    public String getConfigFile(String filename) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "C:\\" + filename;
        }
        if (os.contains("mac") || os.contains("linux") || os.contains("unix")) {
            return "/usr/local/" + filename;
        }
        throw new UnsupportedOperationException();
    }
}
