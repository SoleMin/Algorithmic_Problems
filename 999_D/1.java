import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int a[][]=new int[n][2],i,c=n/m,g[]=new int[m];
        s=bu.readLine().split(" ");

        for(i=0;i<n;i++)
        {
            a[i][0]=Integer.parseInt(s[i]);
            g[a[i][0]%m]++;
            a[i][1]=i;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]%m>o2[0]%m) return 1;
                else if(o1[0]%m==o2[0]%m) return o1[1]>=o2[1]?1:-1;
                else return -1;
            }});

        int first[]=new int[m]; long moves=0;
        Arrays.fill(first,-1);
        for(i=0;i<n;i++)
        if(first[a[i][0]%m]==-1) first[a[i][0]%m]=i;

        Stack<Integer> rem=new Stack<>();
        for(i=0;i<m;i++)
        {
            while(g[i]>c)
            {
                g[i]--;
                rem.add(first[i]++);
            }
            while(g[i]<c && !rem.isEmpty())
            {
                g[i]++;
                int p=rem.pop(),q=i-a[p][0]%m;
                moves+=q;
                a[p][0]+=q;
            }
        }

        for(i=0;i<m;i++)
        while(g[i]<c)
        {
            g[i]++;
            int p=rem.pop(),q=a[p][0]%m;
            if(q>i) q=(m-q)+i;
            else q=i-q;
            moves+=q;
            a[p][0]+=q;
        }

        sb.append(moves+"\n");
        int ans[]=new int[n];
        for(i=0;i<n;i++)
        ans[a[i][1]]=a[i][0];

        for(i=0;i<n;i++)
        sb.append(ans[i]+" ");
        System.out.print(sb);
    }
}