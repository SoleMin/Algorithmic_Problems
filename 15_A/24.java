import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class _P015A{
    Scanner sc=new Scanner(System.in);

    int INF=1<<28;
    double EPS=1e-9;

    int n, t;
    int[][] a;

    void run(){
        n=sc.nextInt();
        t=sc.nextInt();
        a=new int[n][2];
        for(int i=0; i<n; i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        solve();
    }

    void solve(){
        sort(a, new Comparator<int[]>(){
            @Override
            public int compare(int[] a0, int[] a1){
                return a0[0]-a1[0];
            }
        });
        int ans=2;
        for(int i=0; i<n-1; i++){
            int s=(a[i+1][0]*2-a[i+1][1])-(a[i][0]*2+a[i][1]);
            if(s>t*2){
                ans+=2;
            }else if(s==t*2){
                ans++;
            }
        }
        println(ans+"");
    }

    void println(String s){
        System.out.println(s);
    }

    void print(String s){
        System.out.print(s);
    }

    void debug(Object... os){
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args){
        new _P015A().run();
    }
}
