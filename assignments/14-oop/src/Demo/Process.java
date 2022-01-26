package Demo;

public class Process {
    public int pid;
    private String data;
    private String name;
    Status state;
    private static int SIZE = 200; // 200 max processes can be created

    public Process(String pname, String data) {
        this.pid = (int) (Math.random() * SIZE) + 1;
        this.data = data;
        this.name = pname;
        this.state = (this.pid > 1 && this.pid < 50) ? Status.RUNNING : Status.WAITING;
    }

    public void showDetails() {
        System.out.println("|---PID: "+pid);
        System.out.println("|\t|- PName: "+name);
        System.out.println("|\t|- status: "+state);
        System.out.println("|\t|- Data "+data);
    }
}
