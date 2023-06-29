import java.util.Arrays;
import java.util.Scanner;


public class C
{

    public static void main(String[] args)
    {
        new C();
    }
    
    final int oo = (int)1e9;
    
    int Hx,Hy;
    
    int N;
    int[][] P;
    
    int[] memo;
    int[][] soln;
    
    int[] dist1;
    int[][] dist2;
    
    C()
    {
        Scanner in = new Scanner(System.in);
        Hx=in.nextInt();
        Hy=in.nextInt();
        
        N=in.nextInt();
        P=new int[N][2];
        for (int i=0; i<N; ++i)
        {
            P[i][0]=in.nextInt();
            P[i][1]=in.nextInt();
        }
        
        memo=new int[1<<N];
        Arrays.fill(memo, -1);
        soln=new int[2][1<<N];
        
        dist1=new int[N];
        Arrays.fill(dist1, -1);
        dist2=new int[N][N];
        for (int[] d : dist2) Arrays.fill(d, -1);
        
        int res=go((1<<N)-1);
        System.out.println(res);
        
        int set=(1<<N)-1;
        while (set>0)
        {
            System.out.print("0 ");
            System.out.print((soln[0][set]+1)+" ");
            if (soln[1][set]>-1) System.out.print((soln[1][set]+1)+" ");
            
            if (soln[1][set]>-1)
            {
                set-=((1<<soln[0][set])+(1<<soln[1][set]));
            }
            else
            {
                set-=(1<<soln[0][set]);
            }
        }
        System.out.println("0");
    }
    
    int go(int set)
    {
        if (set==0)
            return 0;
        if (memo[set]>-1)
            return memo[set];
                
        int res=oo;
        int i=0;
        while (!on(set,i)) ++i;

        res=dist(i)+go(set-(1<<i));
        soln[0][set]=i;
        soln[1][set]=-1;
        
        for (int j=i+1; j<N; ++j)
        {
            if (on(set,j))
            {
                int tmp=dist(i,j)+go(set-(1<<i)-(1<<j));
                if (tmp<res)
                {
                    res=tmp;
                    soln[0][set]=i;
                    soln[1][set]=j;
                }
            }
        }
        
        return memo[set]=res;
    }
    
    // H->i->H
    int dist(int i)
    {
        if (dist1[i]>-1) return dist1[i];
        
        int dx=P[i][0]-Hx;
        int dy=P[i][1]-Hy;
        return dist1[i]=2*(dx*dx+dy*dy);
    }
    
    // H->i->j->H
    int dist(int i, int j)
    {
        if (dist2[i][j]>-1) return dist2[i][j];
        
        int res=0,dx,dy;
        
        dx=P[i][0]-Hx;
        dy=P[i][1]-Hy;
        res+=dx*dx+dy*dy;
        
        dx=P[i][0]-P[j][0];
        dy=P[i][1]-P[j][1];
        res+=dx*dx+dy*dy;
        
        dx=P[j][0]-Hx;
        dy=P[j][1]-Hy;
        res+=dx*dx+dy*dy;
        
        return dist2[i][j]=res;
    }
    
    boolean on(int set, int loc)
    {
        return (set&(1<<loc))>0;
    }
}
