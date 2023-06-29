import java.io.*;
import java.util.*;
public class CF_468B {
    public static void main(String[] args) throws IOException {
        new CF_468B().solve();
    }
    
    int root(int[] father, int a){
        if (father[a]==a) return a;
        else return father[a]=root(father, father[a]);
    }
    void unite(int[] father, int a, int b){
        father[root(father, a)]=root(father, b);
    }
    
    
    private void solve() throws IOException{
        
        InputStream in = System.in;
        PrintStream out = System.out;
        
//        in = new FileInputStream("in.txt");
//        out = new PrintStream("out.txt");
        
        long mod=1_000_000_007;
        Scanner sc=new Scanner(in);
        int n=sc.nextInt();
        long a=sc.nextLong(), b=sc.nextLong();

        int[] father=new int[n];
        long[] p=new long[n];
        HashMap<Long, Integer> pos=new HashMap<Long, Integer>();
        for (int i=0;i<n;i++){
            father[i]=i;
            p[i]=sc.nextLong();
            pos.put(p[i],i);
        }        
        for (int i=0;i<n;i++){
            if (pos.containsKey(a-p[i])) unite(father,i,pos.get(a-p[i]) );
            if (pos.containsKey(b-p[i])) unite(father,i,pos.get(b-p[i]) );
        }
        boolean[] canA=new boolean[n],
                canB=new boolean[n];
        Arrays.fill(canA,true);
        Arrays.fill(canB,true);
        for (int i=0;i<n;i++){
            if (!pos.containsKey(a-p[i]) || 
                    root(father, i)!=root(father, pos.get(a-p[i]))) 
                canA[root(father, i)]=false;
            if (!pos.containsKey(b-p[i]) || 
                    root(father, i)!=root(father, pos.get(b-p[i]))) 
                canB[root(father, i)]=false;
            if (!canA[root(father,i)] && !canB[root(father,i)]){
                out.println("NO");
                return;                    
            }
        }
        out.println("YES");
        for (int i=0;i<n;i++)
            if (canA[root(father, i)])
                out.print("0 ");
            else
                out.print("1 ");
            
                
    }
}


