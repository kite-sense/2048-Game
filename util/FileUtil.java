package util;

import java.util.List;

public interface FileUtil {
    public List<String> convertFileToList(String filePath);
    public void writeFileFromList(String filePath, List<String> lines);
}
