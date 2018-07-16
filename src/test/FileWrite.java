package test;

import java.io.*;
import java.util.List;

/**
 * Created by MPI on 16.07.2018.
 */
public class FileWrite {
    private BufferedWriter bw;
    public void open(String filename){
        try {
            bw = new BufferedWriter(new FileWriter(new File(filename), true));
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }
    public void write(String str){
        try {
            bw.write(str);
        } catch (IOException e) {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }

    public void write(List<String> strList){
        try {
            for (String s: strList) {
                bw.write(s);
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file");
            e.printStackTrace();
        }
    }

    public void close(){
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Cannot close file");
                e.printStackTrace();
            }
        }
    }
}
