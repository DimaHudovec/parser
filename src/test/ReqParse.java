package test;

import java.io.*;
import java.util.List;

public class ReqParse extends Parser {
    private final String ERROR_FILE = "reg_err.txt";
    private final String OUT_FILE = "reg_out.txt";
    private FileWrite oFile, eFile;

    public ReqParse() {
        oFile = new FileWrite();
        eFile = new FileWrite();
    }

    private void parse(List<String> list) {
        for (String str:list) {
            String[] parts = str.split("    ");
            if(parts.length > 2) {
                oFile.write("\"" + parts[1] + "\"" + "=" + "\"");
                for (int i = 3; i < parts.length; i++) {
                    oFile.write(parts[i]);
                }
                oFile.write("\"" + "\n");
                }
            }
        }

    public void start(String location){
        Command cmd = new Command();
        oFile.open(OUT_FILE);
        eFile.open(ERROR_FILE);
        cmd.run("reg query " + '"'+ location );
        parse(cmd.getCommandOutput());
        eFile.write(cmd.getCommandErrors());
        oFile.close();
        eFile.close();
    }

}