package com.campbell;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/9/19
 */
public class FileTest extends BaseTest {

    @Test
    public void newFile() {
        String pathName = "D:\\IDEA Workspaces\\review\\a.txt";
        File file1 = new File(pathName);
        System.out.println(file1);

        String parent = "D:\\IDEA Workspaces\\review\\";
        String child = "a.txt";
        File file2 = new File(parent, child);
        System.out.println(file2);

        File parentDir = new File("D:\\IDEA Workspaces\\review\\");
        String child2 = "a.txt";
        File file3 = new File(parentDir, child2);
        System.out.println(file3);
    }

    @Test
    public void getFile() {
        File file = new File("D:\\IDEA Workspaces\\review\\a.txt");
        System.out.println("文件绝对路径:" + file.getAbsolutePath());
        System.out.println("文件构造路径:" + file.getPath());
        System.out.println("文件名称:" + file.getName());
        System.out.println("文件长度:" + file.length() + "字节");
        System.out.println("文件路径的父路径" + file.getParentFile());

        File dir = new File("D:\\IDEA Workspaces\\review\\");
        System.out.println("目录绝对路径:" + dir.getAbsolutePath());
        System.out.println("目录构造路径:" + dir.getPath());
        System.out.println("目录名称:" + dir.getName());
        System.out.println("目录长度:" + dir.length());
        System.out.println("目录父路径" + dir.getParentFile());

        System.out.println(file.getPath() + "文件?:" + file.isFile());
        System.out.println(dir.getPath() + "目录?:" + dir.isDirectory());
    }

    @Test
    public void createFile() throws IOException {
        File file = new File("b.txt");
        System.out.println("是否存在:" + file.exists());
        System.out.println("是否创建:" + file.createNewFile());
        System.out.println("是否存在:" + file.exists());

        File dir = new File("dir");
        System.out.println("是否存在:" + dir.exists());
        System.out.println("是否创建:" + dir.mkdirs());
        System.out.println("是否存在:" + dir.exists());

        System.out.println("是否删除:" + file.delete());
        System.out.println("是否删除:" + dir.delete());
    }

    @Test
    public void listFile() {
        File dir = new File("D:\\IDEA Workspaces\\review");
        /*File[] files = dir.listFiles();
        for (File file : files){
            System.out.println(file);
        }*/
        File[] files = dir.listFiles(pathname -> {
            if (pathname.isDirectory())
                return true;
            return pathname.getName().toLowerCase().endsWith("txt");
        });
        for (File file : files) {
            System.out.println(file);
        }
    }

    @Test
    public void testRecursive() {
        System.out.println("请输入数字：");
        int num = new Scanner(System.in).nextInt();
        int record = recursive(num);
        System.out.println(record);
    }

    /**
     * 递归阶乘
     *
     * @param n
     * @return
     */
    public int recursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n * recursive(n - 1);
    }

    @Test
    public void testRecursiveDir() {
        File dir = new File("D:\\IDEA Workspaces\\review");
        recursiveDir(dir);
    }

    /**
     * 递归搜索目录和文件
     *
     * @param dir
     */
    public void recursiveDir(File dir) {
        File[] files = dir.listFiles(pathname -> {
            if (pathname.isDirectory()) {
                return true;
            }
            return pathname.getName().toLowerCase().endsWith("java");
        });
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file);
            } else {
                recursiveDir(file);
            }
        }
    }

}
