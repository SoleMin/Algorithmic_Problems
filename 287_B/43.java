import java.io.*;
import java.util.*;

public class SolutionB {
   BufferedReader in;
   StringTokenizer str;
   PrintWriter out;
   String SK;
   String next() throws IOException {
      while ((str == null) || (!str.hasMoreTokens())) {
         SK = in.readLine();
         if (SK == null)
              return null;
         str = new StringTokenizer(SK);
      }
      return str.nextToken();
   }
   int nextInt() throws IOException {
      return Integer.parseInt(next());
   }
   double nextDouble() throws IOException {
      return Double.parseDouble(next());
   }
   long nextLong() throws IOException {
      return Long.parseLong(next());
   }
   char[] charArray() throws IOException{
      return next().toCharArray();
   }
   public static void main(String[] args) throws IOException {
      new SolutionB().run();
   }
   void run() throws IOException {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      //in = new BufferedReader(new FileReader("input.txt"));
      //out = new PrintWriter("output.txt");
      solve();
      out.close();
   }
   void solve() throws IOException {
      //out.println(Long.MAX_VALUE);
      long n = nextLong();
      long k = nextLong();
      long m=num1(k);
      if(m<n){
         out.println(-1);
         return;
      }
      if(m==n){
         out.println(k-1);
         return;
      }
      long ans=binS(n,k);
      out.println(k-ans);
   }
   long num1(long k){
      long r=k*(k+1)/2-1;
      r=r-(k-2);
      return r;
   }
   long num2(long k){
      return num1(k)-1;
   }
   long binS(long n, long k) {
      long start, end, mid;
      start = 2;
      end = k;
      long ret=-1;
      while (start <= end) {
         mid = (start + end) / 2;
         if (num1(k)-num2(mid) == n) {
            return mid;
         } else if (num1(k)-num2(mid) < n) {
            end = mid - 1;
         } else {
            ret=mid;
            start = mid + 1;
         }
      }
      return ret;
   }
}
   



