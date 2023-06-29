import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        
        int[] h = new int[3000];
        
        for(int i = 0; i<n; i++)
            h[i] = in.nextInt();
        
        int l = 0, r = 1000000000, m = 0;
        int ansl = 0, ansr = 0;
        
        while(l<=r){
            m = (l+r)/2;
            
            int ca=0;
            
            for(int i = 0;i<n;i++)
                if (h[i]>m) ca++;
            
            if (ca == a) ansl=m;
            if (ca <= a) r=m-1; else l=m+1;
        }
        l = 0; r = 1000000000;
        while(l<=r){
            m = (l+r)/2;
            
            int ca=0;
            
            for(int i = 0;i<n;i++)
                if (h[i]>m) ca++;
            
            if (ca == a) ansr=m;
            if (ca < a) r=m-1; else l=m+1;
        }
        if (ansl == 0 || ansr==0) System.out.print(0); else
        System.out.print(ansr-ansl+1);
    }
}