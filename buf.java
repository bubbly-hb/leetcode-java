import java.util.PriorityQueue;

public class buf{
    public static void main(String[] args) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.add(4);
        a.add(5);
        a.add(4);
        System.out.println(a);
        while(!a.isEmpty()) {
            System.out.println(a.poll());
        }
        // a.remove(4);
        System.out.println(a);
    }
}