
import java.util.*;
import java.text.*;
import java.math.*;

public class Main{
    
    static double EPS=1e-10;
    static double PI=Math.acos(-1.0);
    
    static double p[][]=new double[25][25];
    static double f[]=new double[1<<20];
    static int n;
    
    
    public static void PR(String s){
        System.out.print(s);
    }
    
    public static void PR(double s)
    {
        java.text.DecimalFormat d=new java.text.DecimalFormat("#.0000000");
        System.out.print(d.format(s));
    }
    
    public static void DP()
    {
        int i,j,k,cnt;
        for(i=0;i<(1<<n);i++) f[i]=0;
        f[(1<<n)-1]=1;
        for(k=(1<<n)-1;k>=0;k--)
        {
            cnt=0;
            for(i=0;i<n;i++) if((k&(1<<i))!=0) cnt++;
            for(i=0;i<n;i++) if((k&(1<<i))!=0)
            {
                for(j=0;j<n;j++) if(i!=j&&(k&(1<<j))!=0)
                {
                    f[k^(1<<j)]+=f[k]*p[i][j]/((cnt-1)*cnt/2);
                }
            }
        }
    }
    
    public static void main(String[] args){
  
        Scanner S=new Scanner(System.in);
        while(S.hasNext())
        {
            n=S.nextInt();
            int i,j;
            for(i=0;i<n;i++) for(j=0;j<n;j++) p[i][j]=S.nextDouble();
            DP();
            for(i=0;i<n;i++) 
            {
                if(i!=0) PR(" ");
                PR(f[1<<i]);
            }
            PR("\n");
        }
    }
}