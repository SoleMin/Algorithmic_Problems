import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by Tejas on 18-10-2018.
 */
public class Main {

    static HashSet<Integer> adjList[];
    public static void main(String[]args)throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder=new StringBuilder();

        String temp[]=bufferedReader.readLine().split(" ");
        int V=Integer.parseInt(temp[0]);
        int E=Integer.parseInt(temp[1]);
        adjList=new HashSet[V];
        for(int i=0;i<V;i++)
            adjList[i]=new HashSet<>();
        for(int i=0;i<E;i++){
            temp=bufferedReader.readLine().split(" ");
            int x=Integer.parseInt(temp[0])-1;
            int y=Integer.parseInt(temp[1])-1;
            adjList[y].add(x);
            adjList[x].add(y);
        }
        stringBuilder.append(solve(V)+"\n");
        System.out.println(stringBuilder);
    }

    private static long solve(int V) {

        long dp[][]=new long[(1<<V)][V];
        long count=0;
        for(int i=0;i<V;i++)
            dp[(1<<i)][i]=1;
        for(int mask=1;mask<(1<<V);mask++){
            // HW starting at pos first and ending at j.
            int first = Integer.numberOfTrailingZeros(mask);
            for(int i=0;i<V;i++){
                if((mask&(1<<i))==0 || first==i) continue;
                for (int j = 0; j < V; j++)
                    if (adjList[i].contains(j) && (mask & (1<<j))!=0)
                        dp[mask][i] += dp[mask ^ (1 << i)][j];
                //Calculating simple cycles
                if (Integer.bitCount(mask)>=3)
                    if(adjList[first].contains(i))
                        count+=dp[mask][i];
            }
        }
        return count/2;
    }
}
