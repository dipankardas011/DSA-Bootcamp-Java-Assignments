package Demo;
import Demo.Status;
import java.util.Scanner;


public class Main {
    // when the computer boots

    public static void main(String[] args) {
        InitProc initObj = InitProc.startUp();
        try{
            if (initObj == null) {
                throw new Error();
            }
            Object[] otherProcess = new Object[10];

            StringBuilder str = new StringBuilder("1");
            Scanner in = new Scanner(System.in);

            for (int i = 0; i < 10; i++) {
//                System.out.println("Enter the name");
//                String o = in.next();
                otherProcess[i] = new Process(""+(i+1), str.toString());

//                otherProcess[i] = new Process(o, str.toString());
                str.append((char) ((int) (Math.random() * 2) % 2 + '0'));
            }
            in.close();
            initObj.display();

            System.out.println("INIT");

            for (int i = 0; i < 10; i++) {
                ((Process) otherProcess[i]).showDetails();
                String x = initObj.whatIsData(((Process) otherProcess[i]).pid);
                System.out.println("|\t|- Is System Process: " + (x != null));
                System.out.println("|");
            }
        } catch (Error e) {
            System.out.println("SYSTEM COULDN'T START");
        }
    }
}
