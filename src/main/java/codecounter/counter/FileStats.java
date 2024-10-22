package codecounter.counter;

/**
 * 文件统计数据类，用于存储每个文件的统计信息。
 */
public class FileStats {
    int totalLines = 0;
    int emptyLines = 0;
    int singleCommentLines = 0;
    int multiCommentLines = 0;
    int codeLines = 0;
    int fileCnt = 0;
}