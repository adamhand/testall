package amazontest;

import java.io.File;
import java.util.List;

public interface FindOfLinux {
    List<File> find(String suffix, String path);

    List<File> find(int size, String path);

    List<File> find(String suffix, int size, String path);
}
