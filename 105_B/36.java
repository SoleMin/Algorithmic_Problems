import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;

public class Main{
    
    public void go(){
        int n=sc.nextInt(), k=sc.nextInt(), A=sc.nextInt();
        ArrayList< ArrayList< Integer > > waysGiveCandies = doit1(n, k, new ArrayList< Integer >());
/*
        System.out.printf("%d\n", waysGiveCandies.size());
        for(ArrayList< Integer > x : waysGiveCandies){
            for(int i : x)
                System.out.printf("%d ", i);
            System.out.printf("\n");
        }
*/
        int[] lvl = new int[n], loyal = new int[n];
        for(int i=0; i<n; ++i){
            lvl[i] = sc.nextInt();
            loyal[i] = sc.nextInt();
        }

        double ret = 0;
        for(ArrayList< Integer > distribution : waysGiveCandies){
            double[] Loyal = new double[n];
            for(int i=0; i<n; ++i) Loyal[i] = min(loyal[i]+10*distribution.get(i), 100)/100.0;
            double pWin = 0;
            for(int i=0; i<1<<n; ++i){
                double pVoteOccurs = 1;
                for(int j=0; j<n; ++j) 
                    if((i&(1<<j))!=0) // if winner
                        pVoteOccurs *= Loyal[j];
                    else // if loser
                        pVoteOccurs *= 1-Loyal[j];

                int B = 0;
                for(int j=0; j<n; ++j) if((i&(1<<j))==0)
                    B += lvl[j];
                double pWinFight = (double)A/(A+B);

                // if win vote, don't need to fight
                if(bit_count(i)*2 > n)
                    pWinFight = 1;

                pWin += pVoteOccurs * pWinFight;
            }
            ret = max(ret, pWin);
        }

        System.out.printf("%.9f\n", ret);
    }

    ArrayList< ArrayList< Integer > > doit1(int n, int k, ArrayList< Integer > soFar){
        ArrayList< ArrayList< Integer > > ret = new ArrayList< ArrayList< Integer > >();
        
        // base case
        if(n==1){
            soFar.add(k);
            ret.add(soFar);
            return ret;
        }

        // general case
        for(int i=0; i<k+1; ++i){
            ArrayList< Integer > tmp = new ArrayList< Integer >(soFar);
            tmp.add(i);
            ret.addAll(doit1(n-1, k-i, tmp));
        }

        return ret;
    }

    // syntax
    // ArrayList<Integer>[] myMat = (ArrayList<Integer>[]) new ArrayList[nB];

    // Pairs
    public class ii implements Comparable< ii >{
        int x, y;
        public ii(){}
        public ii(int xx, int yy){ x=xx; y=yy; }
        public int compareTo(ii p){ return x!=p.x ? x-p.x : y-p.y; }
        public int hashCode(){ return 31*x+y; }
        public boolean equals(Object o){
            if(!(o instanceof ii)) return false;
            ii p = (ii) o;
            return x==p.x && y==p.y;
        }
        public String toString(){ return "("+x+", "+y+")"; }
    }
/*
    public class pair< X extends Comparable< X >,Y extends Comparable< Y > > implements Comparable< pair< X,Y > >{
        X x;
        Y y;
        public pair(){}
        public pair(X xx, Y yy){ x=xx; y=yy; }
        public int compareTo(pair< X,Y > p){ return x.compareTo(p.x)!=0 ? x.compareTo(p.x) : y.compareTo(p.y); }
        public int hashCode(){ return 31*x.hashCode()+y.hashCode(); }
        public boolean equals(Object o){
            if((o.getClass() != this.getClass())) return false;
            pair< X,Y > p = (pair< X,Y >) o;
            return x.equals(p.x) && y.equals(p.y);
        }
        public String toString(){ return "("+x+", "+y+")"; }
    }
*/
    // my stuff
    public static final int INF = 1000*1000*1000+7;
    public static final double EPS = 1e-9;
    public static final double PI = 2*acos(0.0);
    public void rev(Object[] a){ for(int i=0; i<a.length/2; ++i){ Object t=a[i]; a[i]=a[a.length-1-i]; a[a.length-1-i]=t; } }
    public void rev(int[] a){ for(int i=0; i<a.length/2; ++i){ int t=a[i]; a[i]=a[a.length-1-i]; a[a.length-1-i]=t; } }
    public int bit_count(long x){ return x==0 ? 0 : 1+bit_count(x&(x-1)); }
    public int low_bit(int x){ return x&-x; } // 0011 0100 returns 0000 0100
    public int sign(int x){ return x<0 ? -1 : x>0 ? 1 : 0; }
    public int sign(double x){ return x<-EPS ? -1 : x>EPS ? 1 : 0; }
    int[] unpack(ArrayList< Integer > a){
        int[] ret = new int[a.size()];
        for(int i=0; i<a.size(); ++i) ret[i] = a.get(i);
        return ret;
    }

    // generic main stuff
    static myScanner sc;
    static PrintWriter pw;
    static long startTime;
    public static void main(String[] args) throws Exception{
        // sc = new Scanner(System.in);
        sc = (new Main()).new myScanner(new BufferedReader(new InputStreamReader(System.in)));
        pw = new PrintWriter(System.out);
        startTime = System.nanoTime();
        (new Main()).go();
        // errprintln("nanoTime="+(System.nanoTime()-startTime)/1000000/1000.0);
        pw.flush();
        System.exit(0);
    }

    // capable of reading   2.86M 6dp doubles per second
    //                      2.16M 12dp doubles per second
    //                      2.75M int per second
    public class myScanner{
        private BufferedReader f;
        private StringTokenizer st;
        public myScanner(BufferedReader ff){ f=ff; st=new StringTokenizer(""); }
        public int nextInt(){ return Integer.parseInt(nextToken()); }
        public double nextDouble(){ return Double.parseDouble(nextToken()); }
        public String nextLine(){
            st=new StringTokenizer("");
            String ret="";
            try{ ret=f.readLine(); }catch(Exception e){}
            return ret;
        }
        public String nextToken(){
            while(!st.hasMoreTokens()) try{ st=new StringTokenizer(f.readLine()); } catch(Exception e){}
            return st.nextToken();
        }
    }


}
