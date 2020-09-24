package com.campbell.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Campbell
 * @date 2020/9/19
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);
//        FileOutputStream fos = new FileOutputStream(file,true);
        byte[] b = "abcd".getBytes();
        fos.write(b,2,2);
        fos.close();
    }
}
