package Medium;

class MyCircularQueue {

    protected int[] queue;
    protected int front, rear;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = rear = -1;
    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            front = 0;
            queue[++rear] = value;
            return true;
        }
        if (isFull())
            return false;

        rear = (rear+1)% queue.length;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (front == rear) {
            // last element
            front = rear = -1;
            return true;
        }
        front = (front+1)% queue.length;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return front == rear && front == -1;
    }

    public boolean isFull() {
        return (rear+1)% queue.length == front;
    }
}

public class Q6 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}
