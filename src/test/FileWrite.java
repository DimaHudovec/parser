package test;

import java.io.*;
import java.util.List;

/**
 * Created by MPI on 16.07.2018.
 */
public class FileWrite {
    private FileOutputStream outputStream;
    public void open(String filename){
        try {
            outputStream = new FileOutputStream(filename, true);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }
    public void write(String str){
        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }

    public void write(List<String> strList){
        try {
            for (String s: strList) {
                outputStream.write(s.getBytes());
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }

    public void close(){
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                System.out.println("Cannot close file");
                e.printStackTrace();
            }
        }
    }
}
