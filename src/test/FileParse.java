package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileParse extends Parser {
    private final String REGEX = "[\\\"]{1}[A-Za-z0-9]{1,}[\\\"]{1}[\\=]{1}[\\\"]{1}[A-Za-z0-9]{1,}[\\\"]{1}";
    private final String ERROR_FILE = "file_err.txt";
    private final String OUT_FILE = "file_out.txt";
    private FileWrite oFile, eFile;

    public FileParse() {
        oFile = new FileWrite();
        eFile = new FileWrite();
    }

    public void start(String patch) {
        oFile.open(OUT_FILE);
        eFile.open(ERROR_FILE);
        try {
            Files.lines(Paths.get(getPatch(patch)), StandardCharsets.UTF_8).forEach(this::parse);
        } catch (IOException e) {
            e.printStackTrace();
            eFile.write(e.getMessage() + '\n');
        }
        finally {
            oFile.close();
            eFile.close();
        }

    }

    private String getPatch (String patch){
        Pattern pattern = Pattern.compile("[A-Z][//:].+");
        Matcher matcher = pattern.matcher(patch);
        if(matcher.matches())
            return patch;
        return (System.getProperty("user.dir") + "\\" + patch);
    }

    private boolean checkWithRegExp(String str) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private void parse(String line){
        if (checkWithRegExp(line)) {
            String[] parts = line.split("[\\=]");
            oFile.write(parts[0] + '\n' + parts[1] + '\n');
        }
        else
            oFile.write(line + '\n');
    }
}
