import java.util.*;
import java.io.*;
import java.math.*;

public class d {


    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        long[] arr = new long[n];//in.nextLongArray(n);
        for (int i = 0; i < n; i++) {
            //if (i < n / 2) arr[i] = 1;
            //else arr[i] = 1000000000;
            arr[i] = in.nextLong();
        }
        long sum = 0;
        long count = 0;
        
        TreeSet<Long> ts = new TreeSet<>();
        ts.add(1L);
        long oo = 1000000000 + 100;
        ts.add(oo);
        for (long a : arr) {
            a += 10;
            ts.add(a);
            ts.add(a - 2);
            ts.add(a + 2);
        }
        
        long[] inds = new long[ts.size()];
        int idx = 0;
        for (long a : ts) {
            inds[idx++] = a;
        }
        
        SuperBIT bit1 = new SuperBIT(inds);
        SuperBIT bit2 = new SuperBIT(inds);
        BigInteger ans = BigInteger.valueOf(0);
        
        for (long a : arr) {
            a += 10;
            
            long countLess = bit1.queryCompr(1, a - 2);
            long sumLess = bit2.queryCompr(1, a - 2);
            
            long countMore = bit1.queryCompr(a + 2, oo);
            long sumMore = bit2.queryCompr(a  + 2, oo);
            
            //System.out.println(a + "  " + countLess + "  " + sumLess + "  " + countMore + "  " + sumMore);
            bit1.updateCompr(a, 1);
            bit2.updateCompr(a, a);
            
            long tmp = 0;
            tmp += countLess * a - sumLess;
            tmp -= sumMore - countMore * a;
            ans = ans.add(BigInteger.valueOf(tmp));
        }
        
        out.println(ans);
        
        
        out.close();
    }
static class SuperBIT {
  long[] dataMul, dataAdd;
  SuperBIT(int n) {
    dataMul = new long[n];
    dataAdd = new long[n];
  }
  void update(int left, int right, long val) {
    internalUpdate(left, val, -val * (left-1));
    internalUpdate(right, -val, val * right);
  }
  void internalUpdate(int at, long mul, long add) {
    while (at < dataMul.length) {
      dataMul[at] += mul;
      dataAdd[at] += add;
      at |= (at + 1);
    }
  }
  long query(int at) {
    long mul = 0;
    long add = 0;
    int start = at;
    while(at >= 0) {
      mul += dataMul[at];
      add += dataAdd[at];
      at = (at & (at + 1)) -1;
    }
    return mul * start + add;
  }
  long query(int left, int right) {
    if (left > right) {
      int temp = left;
      left = right;
      right = temp;
    }
    return query(right) - (left > 0 ? query(left-1) : 0);
  }
  long[] indices; // Used for compressed BIT
  // Compressed BIT constructor
  // A BIT that only stores the values that will be updated. 
  // indices is a sorted array of all the unique indices 
  // that would be used for this BIT.
  public SuperBIT(long[] indices) {
    this.indices = indices;
    dataMul = new long[indices.length];
    dataAdd = new long[indices.length];
  }
 
  // Search for the index in the array. If the index was not found, 
  // return the first index lower than the search index.
  int binSearch(long ind) {
    int low = 0;
    int high = dataMul.length-1;
    while(low < high) {
      int mid = (low + high+1)/2;
      if(indices[mid] == ind)
        return mid;
      else if(indices[mid] < ind) 
        low = mid;
      else if(indices[mid] > ind) 
        high = mid-1;
    }
    if(indices[low] > ind)
      --low;
    return low;
  }
  
  // Read the largest index less than or equal to the given index.
  long queryCompr(long index) {
    return query(binSearch(index));
  }
  long queryCompr(long left, long right) {
    return query(binSearch(left), binSearch(right));
  }
  // Update a specific index by a value. If the index is not in this 
  // compressed BIT, the index below will be updated.
  void updateCompr(long index, long val) {
    int ind = binSearch(index);
    update(ind, ind, val);
  }
  void updateCompr(long left, long right, long val) {
    update(binSearch(left), binSearch(right), val);
  } 
}
    static Random rand = new Random();
    static void sort(int[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void sort(long[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            long tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void sort(double[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }
    static long[] eEuclid(long a, long b) {
        if (b == 0) return new long[] { a, 1, 0 };
        long[] ans = eEuclid(b, a % b);
        long temp = ans[1] - ans[2] * (a / b);
        ans[1] = ans[2];  ans[2] = temp;
        return ans;
    }
    static long modInverse(long a, long m) {
        return ((eEuclid(a, m)[1] % m) + m) % m;
    }
    static class IntList {
        static int[] EMPTY = {};
        int[] a = EMPTY;
        int n = 0;
        void add(int v) {
            if (n >= a.length)
                a = Arrays.copyOf(a, (n << 2) + 8);
            a[n++] = v;
        }
        int get(int idx) {
            return a[idx];
        }
        int size() {
            return n;
        }
    }
    static class DisjointSet {
        int[] s, r;	
	public DisjointSet(int n) {
            s = new int[n]; r = new int[n];
            for (int i = 0; i < n; i++) s[i] = i;
        }	
        public int find(int i) { return s[i] == i ? i : (s[i] = find(s[i])); }
	public void union(int a, int b) {
            if(r[a = find(a)] == r[b = find(b)]) r[a]++;
            if(r[a] >= r[b]) s[b] = a; else s[a] = b;
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public int[] nextOffsetIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt() - 1;
            return arr;
        }
        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
        public int[][] nextIntArray(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }
        public long[][] nextLongArray(int n, int m) throws IOException {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextLong();
            return arr;
        }
        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextDouble();
            return arr;
        }
        public double[][] nextDoubleArray(int n, int m) throws IOException {
            double[][] arr = new double[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextDouble();
            return arr;
        }
        public char[][] nextCharArray(int n, int m) throws IOException {
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++)
                arr[i] = next().toCharArray();
            return arr;
        }
    }
}
