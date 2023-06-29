import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class ProblemC {
  
  public static void main(String[] args) throws IOException {
    init();
    new ProblemC().run();
    out.flush();
    out.close();
  }
  
  static void init() throws IOException {
    in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    in.ordinaryChars(0, 65535);
    in.wordChars(0, 65535);
    in.whitespaceChars(' ', ' ');
    in.whitespaceChars('\n', '\n');
    in.whitespaceChars('\r', '\r');
  }
  
  // класс для пар
  class Pair<L, R> {
    private final L X;
    private final R Y;
    
    public Pair(L X, R Y) {
      this.X = X;
      this.Y = Y;
    }
    
    public L getX() {
      return X;
    }
    
    public R getY() {
      return Y;
    }
    
    @Override
    public int hashCode() {
      return X.hashCode() ^ Y.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Pair)) return false;
      Pair pairo = (Pair) o;
      return X.equals(pairo.getX()) && Y.equals(pairo.getY());
    }
  }
  
  static final long INFL = 200000000000000000L;
  static final int INF = 2000000000;
  static final boolean DEBUG = true;
  
  static StreamTokenizer in;
  static PrintWriter out;
  
  static void print(String s) {
    print(s, 0);
  }
  
  static void print(String s, int debug) {
    if (debug == 0 || DEBUG) {
      out.print(s);
    }
  }
  
  static void println(String s) {
    println(s, 0);
  }
  
  static void println(String s, int debug) {
    if (debug == 0 || DEBUG) {
      out.println(s);
    }
  }
  
  static void printArray(int[] arr) {
    println(Arrays.toString(arr));
  }
  
  static void printArray(char[] arr) {
    println(Arrays.toString(arr));
  }
  
  static void printArray(String[] arr) {
    println(Arrays.toString(arr));
  }
  
  static void sort(int[] a) {
    Random rnd = new Random();
    for (int i = a.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i);
      a[i] ^= a[index];
      a[index] ^= a[i];
      a[i] ^= a[index];
    }
    Arrays.sort(a);
  }
  
  static char[] inChars;
  static int inCharsInd;
  
  static String next() throws IOException {
    in.nextToken();
    return in.sval;
  }
  
  static char nextChar() throws IOException {
    while (inChars == null || inCharsInd >= inChars.length) {
      inChars = next().toCharArray();
      inCharsInd = 0;
    }
    return inChars[inCharsInd++];
  }
  
  static int nextInt() throws IOException {
    return Integer.valueOf(next());
  }
  
  static double nextDouble() throws IOException {
    return Double.valueOf(next());
  }
  
  static long nextLong() throws IOException {
    return Long.valueOf(next());
  }
  
  private void run() throws IOException {
    solve();
  }
  
  int K, L, M, N, P;
  
  private void solve() throws IOException {
    int[] countChars = new int['z' + 1];
    boolean[] gotIt = new boolean['z' + 1];
    int N = nextInt();
    int fullCount = 0;
    char[] chars = next().toCharArray();
    for (int i = 0; i < N; i++) {
      if (countChars[chars[i]] == 0) fullCount++;
      countChars[chars[i]]++;
    }
//    out.println(fullCount);
    
    countChars = new int['z' + 1];
    int answer = N;
    int start = 0, finish = 0;
    countChars[chars[start]]++;
    fullCount--;
    
    while (finish+1 < N){
      finish++;
      if (countChars[chars[finish]] == 0) {
        fullCount--;
      }
      countChars[chars[finish]]++;
      while (countChars[chars[start]] > 1){
        countChars[chars[start]]--;
        start++;
      }
      while (fullCount == 0){
//        out.println("start = " + (start+1));
//        out.println("finish = " + (finish+1));
        answer = Math.min(answer, finish-start+1);
        countChars[chars[start]]--;
        if (countChars[chars[start]] == 0) fullCount++;
        start++;
      }
    }
    
    out.println(answer);
  }
  
}
