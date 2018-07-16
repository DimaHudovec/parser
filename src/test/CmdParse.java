package test;

import java.io.*;

public class CmdParse {
    private final String ERROR_FILE = "cmd_err.txt";
    private final String OUT_FILE = "cmd_out.txt";
    private FileWrite oFile, eFile;

    public CmdParse() {
        oFile = new FileWrite();
        eFile = new FileWrite();
    }

    public void cmdOperation(String command){
        Command cmd = new Command();
        oFile.open(OUT_FILE);
        eFile.open(ERROR_FILE);
        cmd.run(command);
        oFile.write(cmd.getCommandOutput());
        eFile.write(cmd.getCommandErrors());
        oFile.close();
        eFile.close();
    }
}
