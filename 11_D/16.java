import java.io.*;
import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int x,y;
        boolean graph[][]=new boolean[n][n];
        for(int i=0;i<m;i++){
            x=sc.nextInt()-1;
            y=sc.nextInt()-1;
            graph[x][y]=graph[y][x]=true;
        }
        long dp[][]=new long[1<<n][n];
        long res=0;
        for(int i=0;i<n;i++){
            dp[1<<i][i]=1;
        }
        for(int mask=1;mask<(1<<n);mask++){
            int first=-1;
            for(int f=0;f<n;f++){
                if((mask&(1<<f))!=0){
                    first=f;
                    break;
                }
            }
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0&&i!=first){
                    for(int j=0;j<n;j++){
                        if(graph[j][i]&&((mask&1<<j)!=0)){
                            dp[mask][i]+=dp[mask^1<<i][j];
                        }
                    }
                }
                if(Integer.bitCount(mask)>2&&graph[first][i]){
                    res+=dp[mask][i];
                }
            }
        }
        
        System.out.println(res/2);
    }
    
}