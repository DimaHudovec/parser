package test;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 2) {
            String string = "";
            Parser parser = ParserFactory.createParserFromFactory(args[0]);
            for (int i = 1; i < args.length; i++) {
                string = string + " " + args[i];
            parser.start(string);
            }
        }
    }
}
