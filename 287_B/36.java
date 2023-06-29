import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

   long k;

   private void solve() throws IOException {
      long n = nl();
      k = nl();

      if (n == 1) {
         prln(0);
         return;
      }

      if (n <= k) {
         prln(1);
         return;
      }

      long l = 1, r = k - 1;
      long mid = (l + r + 1) / 2;
      long old = -1;

      while (old != mid) {
         old = mid;

         if (take(mid) >= n)
            r = mid;
         if (take(mid) < n)
            l = mid;

         mid = (l + r + 1) / 2;
      }

      if (mid >= k || mid <= 0) {
         prln(-1);
         return;
      }

      if (take(mid) == n) {
         prln(mid);
         return;
      }

      if (mid == k - 1)
         prln(-1);
      else
         if (take(mid) < n)
            prln(mid + 1);
         else
            prln(mid);

   }

   long take(long t) {
      return k * t - t * (t - 1) / 2 - (t - 1);
   }

   public static void main(String[] args) {
      new Main().run();
   }

   public void run() {
      try {
         if (isFileIO) {
            pw = new PrintWriter(new File("output.out"));
            br = new BufferedReader(new FileReader("input.in"));
         } else {
            pw = new PrintWriter(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
         }
         solve();
         pw.close();
         br.close();
      } catch (IOException e) {
         System.err.println("IO Error");
      }
   }

   private int[] nia(int n) throws IOException {
      int arr[] = new int[n];
      for (int i = 0; i < n; ++i)
         arr[i] = Integer.parseInt(nextToken());
      return arr;
   }

   private int[] niam1(int n) throws IOException {
      int arr[] = new int[n];
      for (int i = 0; i < n; ++i)
         arr[i] = Integer.parseInt(nextToken()) - 1;
      return arr;
   }

   private long[] nla(int n) throws IOException {
      long arr[] = new long[n];
      for (int i = 0; i < n; ++i)
         arr[i] = Long.parseLong(nextToken());
      return arr;
   }

   private void pr(Object o) {
      pw.print(o);
   }

   private void prln(Object o) {
      pw.println(o);
   }

   private void prln() {
      pw.println();
   }

   int ni() throws IOException {
      return Integer.parseInt(nextToken());
   }

   long nl() throws IOException {
      return Long.parseLong(nextToken());
   }

   double nd() throws IOException {
      return Double.parseDouble(nextToken());
   }

   private String nextToken() throws IOException {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
         tokenizer = new StringTokenizer(br.readLine());
      }

      return tokenizer.nextToken();
   }

   // private void qsort(int a[]) {
   // Random rand = new Random(271828182l);
   // qsort(a, 0, a.length, rand);
   // }
   //
   // private void qsort(int a[], int l, int r, Random rand) {
   // if (r - l <= 1)
   // return;
   //
   // if (r - l == 2) {
   // if (a[r - 1] < a[l]) {
   // int t = a[r - 1];
   // a[r - 1] = a[l];
   // a[l] = t;
   // }
   //
   // return;
   // }
   //
   // int x = a[rand.nextInt(r - l) + l];
   // int i = l, j = r - 1;
   // while (i < j) {
   // while (a[i] < x)
   // ++i;
   // while (a[j] > x)
   // --j;
   // if (i < j) {
   // int t = a[i];
   // a[i] = a[j];
   // a[j] = t;
   // ++i;
   // --j;
   // }
   // }
   //
   // qsort(a, l, j + 1, rand);
   // qsort(a, i, r, rand);
   // }

   private BufferedReader br;
   private StringTokenizer tokenizer;
   private PrintWriter pw;
   private final boolean isFileIO = false;
}