import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;


public class p15a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        if(n == 1) {
            System.out.println(2);
            return;
        }
        house[] all = new house[n];
        for (int i = 0; i < all.length; i++) {
            all[i] = new house(in.nextInt(),in.nextInt());
        }
        Arrays.sort(all);
        
        int count = 0;
        for (int i = 0; i < all.length; i++) {
            double left = all[i].center - (all[i].side*1.0/2);
            double right = all[i].center + (all[i].side*1.0/2);
            if(i == 0) {
                count++;
                double left2 = all[i+1].center - (all[i+1].side*1.0/2);
                if(right+t<left2) {
                    count++;
                }
                continue;
                
            }
            if(i == all.length-1) {
                count++;
                double right2 = all[i-1].center + (all[i-1].side*1.0/2);
                if(left-t>= right2) {
                    count++;
                }
                continue;
            }
            double left2 = all[i+1].center - (all[i+1].side*1.0/2);
            double right2 = all[i-1].center + (all[i-1].side*1.0/2);
            
            if(right+t<left2) {
                count++;
            }
            if(left-t>=right2)
                count++;
        }
        System.out.println(count);
        
    }
}
class house implements Comparable<house>{
    int center;
    int side;
    public house(int a , int b) {
        center = a;
        side = b;
    }
    public int compareTo(house o) {
        return center-o.center;
    }
}