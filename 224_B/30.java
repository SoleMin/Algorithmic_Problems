import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n+1];
        for(int i=1;i<=n;i++)a[i]=sc.nextInt();
        int[] c = new int[100001];
        int num = 0;
        int ri = -1, rj = -1;
        int s = 1, t = 0;
        while(t<n){
            t++;
            if(c[a[t]]==0){
                num++;
            }
            c[a[t]]++;
            for(;k<=num;s++){
                if(ri==-1 || rj-ri+1>t-s+1){
                    ri = s; rj = t;
                }
                c[a[s]]--;
                if(c[a[s]]==0){
                    num--;
                }
            }
        }
        System.out.println(ri+" "+rj);
    }
    
    void debug(Object...o){
        System.out.println(Arrays.deepToString(o));
    }
    
    public static void main(String[] args) {
        new B().run();
    }
}