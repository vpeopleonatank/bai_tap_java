import java.util.*;

public class app {

    static Comparator<Double> cmp = Comparator.comparingDouble(Double::doubleValue);
    public static Queue<Double> testQ = new PriorityQueue<Double>(cmp.reversed());
//    public static Queue<Double> testQ = new PriorityQueue<Double>(new Comparator<Double>() {
//        @Override
//        public int compare(Double t1, Double t2) {
////            return t1 < t2 ? 1 : -1;
//            return Double.compare(t2, t1);
//        }
//    });

    public static void main(String[] args) {
        testQ.add(6.6);
        testQ.add(3.1);
        testQ.add(3.3);
        testQ.add(3.2);

        while(!testQ.isEmpty()) {
            System.out.println(testQ.remove());
        }


    }
}
