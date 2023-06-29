import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CottageVillage {
    
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        while (n-->0) {
            tm.put(sc.nextInt(), sc.nextInt());
        }
        
        int cnt=2, x=0, a=0; 
        double diff=0;
        for(Map.Entry<Integer, Integer> e : tm.entrySet()) {
            if (x!=0 || a!=0) {
                diff = Math.abs(e.getKey()-x-e.getValue()*0.5-a*0.5); 
                if (diff-k>0) cnt+=2;
                else if (diff-k==0) cnt++;
            }
            x=e.getKey();
            a=e.getValue();
        }
        System.out.println(cnt);
    }
}