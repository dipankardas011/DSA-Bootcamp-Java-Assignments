package Problems;
class Animal{
    public void walk(){
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    public void fly() {
        System.out.println("I am flying");
    }
    public void sing() {
        System.out.println("I am singing");
    }
}

public class Q1 {
    public static void main(String[] args) {
        Bird o = new Bird();
        o.walk();
        o.fly();
        o.sing();
    }
}
