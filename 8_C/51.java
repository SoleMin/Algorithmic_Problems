import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static int[][] dist;
    static int[] dist1;
    static int [] dp;
    static int [] path;
    static int end,x,y;
    static Point[] a;
    public static int doit(int mask) {
        if(mask==end) return 0;
        if(dp[mask]!=-1) return dp[mask];
        int min=Integer.MAX_VALUE;
        int t;
        int i;
        for(i=0;i<dist.length;i++) 
            if(((1<<i)|mask)!=mask) break;
            t=2*dist1[i]+doit(mask|(1<<i));
            if(t<min) {
                min=t;
                path[mask]=(1<<i);
            }
            
            for(int j=i+1;j<dist.length;j++) {
                if(((1<<j)|mask)==mask) continue;
                t=dist[i][j]+doit(mask|(1<<i)|(1<<j));
                if(t<min) {
                    min=t;
                    path[mask]=(1<<i)|(1<<j);
                }
            }
        
        return dp[mask]=min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         x=sc.nextInt();y=sc.nextInt();
         a=new Point[sc.nextInt()];
        for(int i=0;i<a.length;i++) {
            a[i]=new Point(sc.nextInt(), sc.nextInt());
        }
        end=(1<<a.length)-1;
        dp=new int[1<<a.length];
        Arrays.fill(dp, -1);
        dist=new int[a.length][a.length];
        dist1=new int[a.length];
        for(int i=0;i<a.length;i++) {
            dist1[i]=(a[i].x-x)*(a[i].x-x)+(a[i].y-y)*(a[i].y-y);
            for(int j=i+1;j<a.length;j++) {
                
                dist[i][j]=dist1[i]+
                (a[j].x-a[i].x)*(a[j].x-a[i].x)+(a[j].y-a[i].y)*(a[j].y-a[i].y)+
                (a[j].x-x)*(a[j].x-x)+(a[j].y-y)*(a[j].y-y);
                //System.out.println(dist[i][j]);
            }
        }
        path=new int[dp.length];
        System.out.println(doit(0));
        int e=0;
        int cur=path[e];
        StringBuffer bf=new StringBuffer();
        bf.append(0+" ");
        int count=0;
        for(int i=0;count<a.length;i++) {
            //System.out.println(Integer.toBinaryString(cur)+" "+cur);
            for(int j=0;j<a.length;j++) {
                if(((1<<j)|cur)==cur) {
                    bf.append((j+1)+" "); count++;
                }
            }
            e|=cur;
            cur=path[e];
            bf.append(0+" ");
        }
        System.out.println(bf);
    }
}
