import java.util.*;
import java.io.*; 
import java.text.DecimalFormat;

public class Main{
    final long mod = (int)1e9+7, IINF = (long)1e19;
    final int MAX = (int)1e6+1, MX = (int)1e7+1, INF = (int)1e9, root = 3;
    DecimalFormat df = new DecimalFormat("0.0000000000000");
    double eps = 1e-9;
    FastReader in;
    PrintWriter out;
    static boolean multipleTC = false, memory = false;

    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Main().run();
    }

    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        for(int i = 1, t = (multipleTC)?ni():1; i<=t; i++)solve(i);
        out.flush();    
        out.close();
    }
    
    void solve(int TC)throws Exception{
        int n = ni();
        int[] f1 = new int[9], f2 = new int[9];
        MyHashSet<String> set = new MyHashSet<>();
        for(int i = 0; i< n; i++){
            String s = n();
            set.add(s);
            f1[s.length()]++;
        }
        int[] f = new int[4];
        for(int i = 0; i< n; i++){
            String s = n();
            if(set.remove(s))continue;
            else f[s.length()-1]++;
        }
        int ans = 0;
        for(int i = 0; i< 4; i++)ans+=f[i];
        pn(ans);
    }
    
    class MyHashSet<T>{
        private int size;
        private HashMap<T, Integer> map;
        public MyHashSet(){
            size = 0;
            map = new HashMap<>();
        }
        public int size(){return size;}
        public void add(T t){
            size++;
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        public int cnt(T t){return map.getOrDefault(t,0);}
        public boolean remove(T t){
            if(!map.containsKey(t))return false;
            size--;
            int c = map.get(t);
            if(c==1)map.remove(t);
            else map.put(t, c-1);
            return true;
        }
    }
    
    int[] reverse(int[] a){
        int[] o = new int[a.length];
        for(int i = 0; i< a.length; i++)o[i] = a[a.length-i-1];
        return o;   
    }

    int[] sort(int[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        int[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    long[] sort(long[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        long[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bitcount(long n){return (n==0)?0:(1+bitcount(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n(){return in.next();}
    String nln(){return in.nextLine();}
    int ni(){return Integer.parseInt(in.next());}
    long nl(){return Long.parseLong(in.next());}
    double nd(){return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }   
            return str;
        }
    }
}      