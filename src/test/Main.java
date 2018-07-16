package test;

public class Main {

    public static void main(String[] args) {
        if (args.length >= 2) {
            switch (args[0]) {
                case "-f":
                    FileParse fp = new FileParse();
                    fp.fileOperation(args[1]);
                    break;
                case "-cmd":
                    String command = "";
                    for(int i=1; i < args.length; i++)
                       command = command + " " + args[i];
                    CmdParse cp = new CmdParse();
                    cp.cmdOperation(command);
                    break;
                case "-rk":
                    String reg = "";
                    for(int i=1; i < args.length; i++)
                        reg = reg + " " + args[i];
                    ReqParse rp = new ReqParse();
                    rp.regOperation(reg);
                    break;
                default:
                    break;
            }
        }
    }
}
