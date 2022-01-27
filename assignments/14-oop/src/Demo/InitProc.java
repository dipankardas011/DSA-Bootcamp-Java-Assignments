package Demo;

public class InitProc {

    private static InitProc init = null;

    private int pid;
    private String data;
    private String name;
    Status stat;

    InitProc() {
        this.pid = 1;
        this.data = "INTIAL PROCESS";
        this.stat = Status.RUNNING;
        this.name = "init";
    }

    public static InitProc startUp() {
        if (init == null) {
            return new InitProc();
        }
        return init;
    }

    private String getData() {return this.data;}

    public String whatIsData(int requestPID) {
        if (requestPID > 1 && requestPID < 50) {
            return this.getData();
        }
//        only able to access the data if systemcall
        return null;
    }

    public void display() {
        System.out.println("PID: "+pid);
        System.out.println("PName: "+name);
        System.out.println("status: "+stat);
        System.out.println();
    }
}
