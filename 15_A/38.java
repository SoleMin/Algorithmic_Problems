

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author epiZend
 */
public class Cottage {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        List<Point> houses = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            houses.add(new Point(x, a));
        }
        Collections.sort(houses, new Comparator<Point>() {
            
            @Override
            public int compare(Point o1, Point o2) {
                return ((Integer) o1.x).compareTo(o2.x);
            }
        });
        int pos = 2;
        for (int i = 0; i < n - 1; i++) {
            double end = houses.get(i).x + (houses.get(i).y+0.0)/2;
            double start = houses.get(i+1).x - (houses.get(i+1).y+0.0)/2;
            //System.out.println("end "+end+" start "+start);
            double diff = start-end;
            //System.out.println("diff");
            if (Math.abs(diff-t) < 0.0000001) {
                pos++;
            }
            if (diff > t) {
                pos += 2;
            }
        }
        System.out.println(pos);
    }
}
