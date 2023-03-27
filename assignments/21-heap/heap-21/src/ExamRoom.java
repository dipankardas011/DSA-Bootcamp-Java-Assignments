import java.util.TreeSet;

public class Main {
    static class ExamRoom {

        int capacity;
        TreeSet<Integer> seats;

        public ExamRoom(int n) {
            this.capacity=n;
            this.seats = new TreeSet<>();
        }

        public int seat() {
            int seatNumber=0;
            if(seats.size() > 0){
                Integer prev=null;
                int distance = seats.first();
                for(Integer seat : seats){
                    if(prev != null){
                        int d = (seat-prev)/2; // get the middle of the distance for searNumber
                        if(distance < d){
                            distance=d;
                            seatNumber=prev+distance;
                        }
                    }
                    prev = seat;
                }

                if(distance < capacity-1-seats.last()){
                    seatNumber = capacity-1;
                }
            }
            seats.add(seatNumber);
            return seatNumber;
        }

        public void leave(int p) {
            seats.remove(p);
        }
    }
    public static void main(String[] args){
        ExamRoom obj = new ExamRoom(10);
        System.out.println(obj.seat()); // return 0, no one is in the room, then the student sits at seat number 0.
        System.out.println(obj.seat()); // return 9, the student sits at the last seat number 9.
        System.out.println(obj.seat()); // return 4, the student sits at the last seat number 4.
        System.out.println(obj.seat()); // return 2, the student sits at the last seat number 2.
        obj.leave(4);
        System.out.println(obj.seat());
    }
}