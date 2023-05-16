package logic;

import java.io.*;
import java.util.zip.GZIPOutputStream;


public class Compress {
    public static void method(File file) throws IOException {
        String parentDirectory = file.getParent();
        String fileName = file.getName();
        System.out.println(fileName);

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(parentDirectory+"/"+fileName+"compressed.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int length;

        while((length=fis.read(buffer))!=-1){
            gzip.write(buffer,0,length);
        }

        gzip.close();
        fos.close();
        fis.close();


    }

    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        method(file);

    }
}
