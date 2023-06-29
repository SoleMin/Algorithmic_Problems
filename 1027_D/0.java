import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String args[])throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int c[]=new int[n+1];
        int a[]=new int[n+1];
        int ans=0;
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        int dfs[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int curr=i;
            while(dfs[curr]==0){
                dfs[curr]=1;
                curr=a[curr];
            }
            int cost=Integer.MAX_VALUE;
            while(dfs[curr]==1){
                cost=Math.min(cost,c[curr]);
                dfs[curr]=-1;
                curr=a[curr];
            }
            if(cost!=Integer.MAX_VALUE)
            ans+=cost;
           curr=i;
           while(dfs[curr]==1){
               dfs[curr]=-1;
               curr=a[curr];
           }
        }
        System.out.println(ans);

    }
}
