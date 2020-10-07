package com.campbell.service;

import com.alibaba.fastjson.JSONObject;
import com.campbell.entity.Person;
import com.campbell.entity.Student;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * @author Campbell
 * @date 2020/9/19
 */
public class IOTest {

    @Test
    public void fileOutputStreamTest() throws IOException {
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);
        /*FileOutputStream fos = new FileOutputStream(file,true);*/
        byte[] b = "hello".getBytes();
        fos.write(b, 0, 2);
        fos.close();
    }

    @Test
    public void fileInputStreamTest1() throws IOException {
        File file = new File("a.txt");
        FileInputStream fis = new FileInputStream(file);
        int b;
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        fis.close();
    }

    @Test
    public void fileInputStreamTest2() throws IOException {
        File file = new File("a.txt");
        FileInputStream fis = new FileInputStream(file);
        int len;
        byte[] b = new byte[2];
        while ((len = fis.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }
        fis.close();
    }

    @Test
    public void copyTest() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\32983\\Pictures\\Saved Pictures\\cloud.png");
        FileOutputStream fos = new FileOutputStream("test.png");
        int len;
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        fos.close();
        fis.close();
    }

    /**
     * 字节缓冲流
     *
     * @throws IOException
     */
    @Test
    public void bufferedTest() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\32983\\Pictures\\Saved Pictures\\cloud.png"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.png"));
        int len;
        byte[] b = new byte[1024];
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bos.close();
        bis.close();
    }

    @Test
    public void encodingTest() throws IOException {
        byte[] bytes = "你".getBytes("UTF-8");
        System.out.println(Arrays.toString(bytes));

        bytes = "你".getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void outputStreamWriterTest() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"), "UTF-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    @Test
    public void inputStreamReaderTest() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
        /*int c;
        while ((c = isr.read())!= -1){
            System.out.println((char)c);
        }*/
        int len;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        isr.close();
    }

    @Test
    public void fileWriterTest() throws IOException {
        FileWriter fw = new FileWriter("a.txt");
        fw.write(97);
        fw.flush();

        char[] chars = "ABCDEF".toCharArray();
        fw.write("\n");
        fw.write(chars);
        fw.flush();

        fw.write("\n");
        fw.write(chars, 0, 4);
        fw.flush();

        fw.write("\n");
        fw.write("你好");
        fw.close();
    }

    @Test
    public void fileReaderTest() throws IOException {
        FileReader fr = new FileReader("a.txt");
        int len;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        fr.close();
    }

    @Test
    public void bufferedWriterTest() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        bw.write("ABCD");
        bw.newLine();
        bw.write("ABCD");
        bw.newLine();
        bw.write("ABCD");
        bw.newLine();
        bw.close();
    }

    @Test
    public void bufferedReaderTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        List<String> stringList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        Collections.sort(stringList, String::compareTo);

        /*//正序
        Collections.sort(stringList, (o1, o2) -> o1.charAt(0)-o2.charAt(0));
        Collections.sort(stringList, Comparator.comparingInt(o -> o.charAt(0)));
        //倒序
        Collections.sort(stringList, (o1, o2) -> o2.charAt(0)-o1.charAt(0));*/

        for (String s : stringList) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    @Test
    public void printWriterTest() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("a.txt"), true);
        pw.println(97);
        pw.println(98);
        pw.close();
    }

    @Test
    public void objectOutputStreamTest() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        Person person = new Person().builder().name("张三").age(18).gender(1).build();
        oos.writeObject(person);
        oos.close();
    }

    @Test
    public void objectInputStreamTest() {
        Person person;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
            person = (Person) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(person.toString());
    }

    @Test
    public void propertiesTest() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("D:\\IDEA Workspaces\\review\\src\\main\\resources\\application.yml"));
        Set<String> strings = properties.stringPropertyNames();
        strings.forEach(s -> System.out.println(s + ":" + properties.getProperty(s)));
    }

}
