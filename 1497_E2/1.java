import java.util.*;
import java.io.*;

public class Solve{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int size=(int)1e7+1;
        int[] pr=new int[size];
        for(int i=0;i<size;i++){
            pr[i]=i;
        }
        for(int i=2;i*i<size;i++){
          int val=i*i;
            for(int j=val;j<=size;j+=val){
                 pr[j]=j/val;
            }
        }
        int t=sc.nextInt();
        int[] dp=new int[size];
        Arrays.fill(dp,-1);
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] ar=new int[n];
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                ar[i]=pr[a];
            }
            int[] ans=new int[k+1];
            int[] ind=new int[k+1];
            for(int i=0;i<n;i++){
                for(int h=k;h>=0;h--){
                    if(dp[ar[i]]>=ind[h]){
                        ans[h]++;
                        ind[h]=i;
                    }
                    if(h>0 && (ans[h-1]<ans[h] ||(ans[h-1]==ans[h] && ind[h-1]>ind[h])))
                    {
                        ans[h]=ans[h-1];
                        ind[h]=ind[h-1];
                    }
                }
                dp[ar[i]]=i;
            }
            out.println(ans[k]+1);
            for(int i=0;i<n;i++)dp[ar[i]]=-1;
        }
        out.close();
    }
}