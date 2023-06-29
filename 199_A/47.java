import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        
        List<Long> fi = new ArrayList<Long>(); 
        
        fi.add((long) 0);
        fi.add((long) 1);
        
        while (fi.get(fi.size()-1)<n) {
            fi.add(fi.get(fi.size()-1)+fi.get(fi.size()-2));
        }
        
        int last = fi.size()-1;

        long z = last-1>=0 ? fi.get(last-1) : 0;
        long y = last-3>=0 ? fi.get(last-3) : 0;
        long x = last-4>=0 ? fi.get(last-4) : 0;

        if (x+y+z<n)
            x=1;
        
        System.out.println(x+" "+y+" "+z);
    }
    
}