
import java.util.*;
import java.io.*;
public class code839E
{
    public static void main(String[] args) throws Exception{
        BufferedReader bff=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wff=new PrintWriter(System.out);
        String[] st=bff.readLine().split(" ");
        int V=Integer.parseInt(st[0]);
        int K=Integer.parseInt(st[1]);
        BronKerbosch bk=new BronKerbosch(V);
        for(int i=0;i<V;i++){
            st=bff.readLine().split(" ");
            for(int j=0;j<V;j++){
                if(st[j].equals("1")){
                    bk.anadir(i,j);
                }
            }
        }
        long num=bk.numeroCamarilla();
        wff.printf("%.12f\n", num * (num - 1.0) / 2 * K / num * K / num);
        wff.flush();
    }
    
    
    
static class BronKerbosch {
    int V;
    long[] neig;
    Random random = new Random();
    long maxClique;

    public BronKerbosch(int v){
        V=v;
        neig=new long[V];
    }

    public void anadir(int a,int b){
        long aux=1;
        neig[a] |= aux << (long)b;
    }
    
    public long numeroCamarilla(){
        long numero = Long.bitCount(bronKerbosch());
        return numero;
    }
    
    public long bronKerbosch() {
        maxClique = 0;
        bronKerbosch2(0, (1L << V) - 1, 0);
        return maxClique;
    }

    public void bronKerbosch2(long r, long p, long x) {
        if (Long.bitCount(maxClique) >= Long.bitCount(r | p | x)) return;
        long px = p | x;
        if (px == 0) {
            if (Long.bitCount(maxClique) < Long.bitCount(r)) {
                maxClique = r;
            }
            return;
        }
        int cnt = Long.bitCount(px);
        int choice = random.nextInt(cnt);
        int u;
        for (int i = 0; ; i++) {
            if ((px >>> i & 1) != 0 && choice-- == 0) {
                u = i;
                break;
            }
        }

        long ne = p & ~neig[u];
        for (int v = 0; v < V; v++){
            if ((ne >>> v & 1) != 0) {
                bronKerbosch2(r | 1L << v, p & neig[v], x & neig[v]);
                p &= ~(1L << v);
                x |= 1L << v;
            }
        }
    }

}


    
}
