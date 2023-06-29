import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;
import java.math.*;

public class x1017C
{
    public static void main(String hi[]) throws Exception
    {
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int N = Integer.parseInt(st.nextToken());
        int groups = 1;
        int val = N+N;
        for(int i=2; i <= N; i++)
        {
            int lis = (N+i-1)/i;
            if(lis+i < val)
            {
                val = lis+i;
                groups = i;
            }
        }
        int[] res = new int[N];
        int rem = N%groups;  int dex = N-(N/groups);
        int tag = 1;    int right = N;
        //System.out.println(groups);
        while(tag <= N)
        {
            if(rem > 0)
            {
                dex--;
                rem--;
            }
            int next = dex;
            while(dex < right)
                res[dex++] = tag++;
            right = next;
            dex = right-(N/groups);
        }
        StringBuilder sb = new StringBuilder();
        for(int x: res)
            sb.append(x+" ");
        System.out.println(sb);
    }
}