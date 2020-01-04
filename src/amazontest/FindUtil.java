package amazontest;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindUtil implements FindOfLinux {
    private List<File> list = new ArrayList<>();

    @Override
    public List<File> find(int size, String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    list = find(size, f.getAbsolutePath());
                } else if (f.isFile() && f.length() > size * 1024) {
                    list.add(f);
                }
            }
        }
        return list;
    }

    @Override
    public List<File> find(String suffix, String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    list = find(suffix, f.getAbsolutePath());
                } else if (f.isFile() && f.getName().endsWith(suffix)) {
                    list.add(f);
                }
            }
        }
        return list;
    }

    @Override
    public List<File> find(String suffix, int size, String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    list = find(suffix, size, f.getAbsolutePath());
                } else if (f.isFile() && f.getName().endsWith(suffix) && f.length() > size * 1024) {
                    list.add(f);
                }
            }
        }
        return list;
    }
}

class Main {
    public static void main(String[] args) {
        FindUtil findUtil = new FindUtil();
        List<File> list = new ArrayList<>();
        String path = "H:\\IDEA\\Test\\TestALL\\src\\amazontest";

//        list = findUtil.find(".xml", path);

//        list = findUtil.find(5, path);

        list = findUtil.find(".xml", 5, path);

        for (File f : list) {
            System.out.println(f.getName());
        }
    }
}
