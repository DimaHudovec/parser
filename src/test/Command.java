package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MPI on 16.07.2018.
 */
public class Command {
    private BufferedReader stdInput;
    private BufferedReader stdError;

    public void run(String command) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("Bad command");
            e.printStackTrace();
        }
        stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }

    public List<String> getCommandOutput() {
        List<String> lines = new ArrayList<String>();
        String line;
        try {
            while ((line = stdInput.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot read command output");
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> getCommandErrors() {
        List<String> lines = new ArrayList<String>();
        String line;
        try {
            while ((line = stdError.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot read command errors");
            e.printStackTrace();
        }
        return lines;
    }
}
