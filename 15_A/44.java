import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ProblemA {

    static ArrayList<Point2> houses = new ArrayList<Point2>();
    
    public static void main(String[] args) {
        ProblemA a = new ProblemA();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            double t = in.nextDouble();
            for (int k=0;k<n;k++){
                houses.add(a.new Point2(in.nextDouble(),in.nextDouble()));
            }
            Collections.sort(houses);
            int ans = 2;
            for (int k=0;k<n-1;k++){
                Point2 cur = houses.get(k);
                Point2 next = houses.get(k+1);
                double dist = (next.x - next.y/2) - (cur.x + cur.y/2);
                if (dist == t) ans ++;
                if (dist > t ) ans+=2;
            }
            System.out.println(ans);
        }
    }
    
    public class Point2 implements Comparable<Point2>{
        public double x;
        public double y;
        public Point2(double one, double two){
            x = one;
            y = two;
        }
        
        public int compareTo(Point2 other){
            if (x - other.x > 0) return 1;
            if (x - other.x < 0) return -1;
            return 0;
        }
        
        public String toString(){
            return "x:" + x + " y:" + y;
        }
    }
}



 