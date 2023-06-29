// Don't place your source in a package
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.stream.Stream;


// Please name your class Main
public class Main {
    static FastScanner fs=new FastScanner();
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next() {
            while (!st.hasMoreElements())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        int Int() {
            return Integer.parseInt(next());
        }

        long Long() {
            return Long.parseLong(next());
        }

        String Str(){
            return next();
        }
    }


    public static void main (String[] args) throws java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);



        int T=1;
        for(int t=0;t<T;t++){
            int n=Int();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=Int();
            }

            Solution sol=new Solution();
            sol.solution(out,A);
        }
        out.flush();

    }

    public static int Int(){
        return fs.Int();
    }
    public static long Long(){
        return fs.Long();
    }
    public static String Str(){
        return fs.Str();
    }

}






class Solution{
    public void solution(PrintWriter out,int A[]){
        Map<Integer,List<int[]>>f=new HashMap<>();
        List<int[]>res=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int sum=0;
            for(int j=i;j<A.length;j++){
                sum+=A[j];
                if(!f.containsKey(sum))f.put(sum,new ArrayList<>());
                List<int[]>list=f.get(sum);
                list.add(new int[]{i,j});
            }
        }


        for(Integer key:f.keySet()){
            List<int[]>list=f.get(key);
            Collections.sort(list,(a,b)->{
                return a[1]-b[1];
            });
            int pre[]=new int[list.size()];
            Arrays.fill(pre,-1);


            int dp[][]=new int[list.size()][2];
            dp[0][0]=1;
            dp[0][1]=0;

            for(int i=1;i<list.size();i++){
                int pair[]=list.get(i);
                int l=0,r=i-1;
                int pos=-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(list.get(mid)[1]<pair[0]){
                        pos=mid;
                        l=mid+1;
                    }
                    else{
                        r=mid-1;
                    }
                }

                if(pos!=-1){
                    int mx=1+dp[pos][0];
                    if(mx>=dp[i-1][0]){
                        dp[i][0]=mx;
                        dp[i][1]=i;
                        pre[i]=dp[pos][1];
                    }
                    else{
                        dp[i][0]=dp[i-1][0];
                        dp[i][1]=dp[i-1][1];
                    }
                }
                else{
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=dp[i-1][1];
                }
            }

            int n=list.size();
            if(dp[n-1][0]>res.size()){
                res=new ArrayList<>();
                int j=dp[n-1][1];
                while(j!=-1){
                    res.add(list.get(j));
                    j=pre[j];
                }
            }

            
        }





        out.println(res.size());
        for(int p[]:res){
            out.println((p[0]+1)+" "+(p[1]+1));
        }
    }




}




/*
                             ;\
                            |' \
         _                  ; : ;
        / `-.              /: : |
       |  ,-.`-.          ,': : |
       \  :  `. `.       ,'-. : |
        \ ;    ;  `-.__,'    `-.|
         \ ;   ;  :::  ,::'`:.  `.
          \ `-. :  `    :.    `.  \
           \   \    ,   ;   ,:    (\
            \   :., :.    ,'o)): ` `-.
           ,/,' ;' ,::"'`.`---'   `.  `-._
         ,/  :  ; '"      `;'          ,--`.
        ;/   :; ;             ,:'     (   ,:)
          ,.,:.    ; ,:.,  ,-._ `.     \""'/
          '::'     `:'`  ,'(  \`._____.-'"'
             ;,   ;  `.  `. `._`-.  \\
             ;:.  ;:       `-._`-.\  \`.
              '`:. :        |' `. `\  ) \
      -hrr-      ` ;:       |    `--\__,'
                   '`      ,'
                        ,-'


                      free bug dog
*/



