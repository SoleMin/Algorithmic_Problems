/*
stream Butter!
eggyHide eggyVengeance
I need U
xiao rerun when
 */
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class x1523C
{
    public static void main(String hi[]) throws Exception
    {
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(T-->0)
        {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for(int i=0; i < N; i++)
                arr[i] = Integer.parseInt(infile.readLine());
            ArrayList<Integer>[] buckets = new ArrayList[N];
            buckets[0] = new ArrayList<Integer>();
            buckets[0].add(arr[0]);
            //first element always 1?
            for(int i=1; i < N; i++)
            {
                ArrayList<Integer> ls = new ArrayList<Integer>();
                if(arr[i] == 1)
                {
                    for(int x: buckets[i-1])
                        ls.add(x);
                    ls.add(1);
                }
                else
                {
                    int dex = -1;
                    for(int a=0; a < buckets[i-1].size(); a++)
                        if(buckets[i-1].get(a) == arr[i]-1)
                            dex = a;
                    for(int a=0; a < dex; a++)
                        ls.add(buckets[i-1].get(a));
                    ls.add(arr[i]);
                }
                buckets[i] = ls;
            }
            //output answer
            for(int a=0; a < N; a++)
            {
                for(int i=0; i < buckets[a].size()-1; i++)
                {
                    sb.append(buckets[a].get(i));
                    sb.append(".");
                }
                sb.append(arr[a]);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}