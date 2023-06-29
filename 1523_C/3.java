//I'm Whiplash99
import java.io.*;
import java.util.*;
public class C
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while (T-->0)
        {
            N=Integer.parseInt(br.readLine().trim());

            int[] a=new int[N];
            for(i=0;i<N;i++) a[i]=Integer.parseInt(br.readLine().trim());

            int end=1;
            int[][] ans=new int[N][N+10];

            ans[0][0]=1;
            for(i=1;i<N;i++)
            {
                while (true)
                {
                    if(ans[i-1][end]==a[i]-1) break;
                    end--;
                }
                for(int j=0;j<end;j++) ans[i][j]=ans[i-1][j];

                ans[i][end]=a[i];
                end++;
            }

            for(i=0;i<N;i++)
            {
                for(int j=0;j<N&&ans[i][j]!=0;j++)
                {
                    sb.append(ans[i][j]);
                    if(ans[i][j+1]!=0) sb.append('.');
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}