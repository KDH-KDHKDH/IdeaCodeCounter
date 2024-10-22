package codecounter.counter;

import java.io.File;

public final class Constant {
    /**
     * 列名
     */
    static String[] initHeader = {"Extension", "File Count", "Total Lines", "Empty Lines", "Single Comment Lines", "Multi Comment Lines", "Code Lines"};

    // 常见的源文件后缀名数组
    static String[] extensions = {
            "c", "h", "cpp", "cc", "cxx", "hpp", "java", "py", "js", "html",
            "htm", "css", "ts", "go", "rb", "swift", "rs", "php", "sh", "pl"
    };

    static String projectRoot = new File(System.getProperty("user.dir")).getPath();
}
