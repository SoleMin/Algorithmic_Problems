import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class B {

    void solve() throws IOException {
        int n=nextInt();
        int a=nextInt();
        int b=nextInt();
        int[] p=new int[n];
        for(int i=0;i<n;i++)p[i]=nextInt();
//        if(n%2==1){
//            out.println("NO");
//            return;
//        }
        TreeSet<Integer>[] s=new TreeSet[n];
        for(int i=0;i<n;i++)s[i]=new TreeSet<Integer>();
        HashMap<Integer,Integer> m=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++)
            m.put(p[i],i);
        for(int i=0;i<n;i++){
            if(m.containsKey(a-p[i])){
                s[i].add(a-p[i]);
                s[m.get(a-p[i])].add(p[i]);
            }
            if(m.containsKey(b-p[i])){
                s[i].add(b-p[i]);
                s[m.get(b-p[i])].add(p[i]);
            }
        }
        int last=-1;
        LinkedList<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(s[i].size()==0){
                out.println("NO");
                return;
            }
            if(s[i].size()==1){
                q.add(i);
            }
        }
        int[] ans=new int[n];
        while(last!=n){
            while(!q.isEmpty()){
                int cur=q.poll();
                if(s[cur].size()==0)continue;
                int x=p[cur];
                int y=s[cur].first();
                if(x==a-y){
                    ans[cur]=1;
                    ans[m.get(y)]=1;
                }
                else{
                    ans[cur]=2;
                    ans[m.get(y)]=2;
                }
                for(Integer u:s[m.get(y)]){
                    int o=m.get(u);
                    if(o!=m.get(y)) {
                        s[o].remove(y);
                        if (s[o].size() == 1) q.add(o);
                    }
                }
                for(Integer u:s[cur]){
                    int o=m.get(u);
                    if(o!=m.get(y)) {
                        s[o].remove(y);
                        if (s[o].size() == 1) q.add(o);
                    }
                }
            }
            last++;
            while(last!=n){
                if(s[last].size()!=0&&ans[last]==0)break;
                last++;
            }
            if(last!=n){
                q.add(last);
            }
        }
        for(int i=0;i<n;i++)
            if(ans[i]==0){
                out.println("NO");
                return;
            }
        out.println("YES");
        for(int i=0;i<n;i++)
            out.print((ans[i]-1)+" ");
    }

    public static void main(String[] args) throws IOException {
        new B().run();
    }

    void run() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
//      reader = new BufferedReader(new FileReader("input.txt"));
        tokenizer = null;
        out = new PrintWriter(new OutputStreamWriter(System.out));
//      out = new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        out.flush();

    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
