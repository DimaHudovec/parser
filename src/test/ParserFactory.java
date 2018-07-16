package test;

/**
 * Created by MPI on 16.07.2018.
 */
public class ParserFactory { // простейшая реализация шаблона
    public static Parser createParserFromFactory(String type) {
        switch(type) {
            case "-f": return new FileParse();
            case "-cmd": return new CmdParse();
            case "-rk": return new ReqParse();
            default : return null;
        }
    }
}
