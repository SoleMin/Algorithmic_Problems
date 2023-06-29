import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CottageVillage {
    
    class cl {
        int x=0;
        int a=0;
        
        cl(int x, int a){
            this.x=x; 
            this.a=a;
        }
    }
    
    class cmp implements Comparator<cl> {
        public int compare(cl d1, cl d2) {
            return d1.x<d2.x ? -1 : 1;
        }
    }
    
    public CottageVillage() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        cl[] w = new cl[n];
        for(int i=0; i<n; i++)
            w[i] = new cl(sc.nextInt(), sc.nextInt());
        Arrays.sort(w, new cmp());
        
        int cnt=2, diff=0; 
        for(int i=1; i<n; i++) {
            diff = Math.abs(2*w[i].x-2*w[i-1].x-w[i].a-w[i-1].a)-2*k; 
            if (diff>0) cnt+=2;
            else if (diff==0) cnt++;
        }
        System.out.println(cnt);
    }
    
    public static void main(String... args) {
        new CottageVillage();
    }
}