package logic;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Decompress {


    public static void decompressMethod(File file) throws IOException {
        String parentDirectory = file.getParent();
        String fileName = file.getName();
        System.out.println(fileName);

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(parentDirectory+"/"+fileName.substring(0,fileName.length()-13));

        byte[] buffer = new byte[1024];
        int length;

        while((length=gzip.read(buffer))!=-1){
            fos.write(buffer,0,length);
        }

        gzip.close();
        fos.close();
        fis.close();
    }



    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        decompressMethod(file);
    }
}
