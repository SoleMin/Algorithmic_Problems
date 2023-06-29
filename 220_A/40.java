import java.io.*;
import java.util.*;

public class Main {

   static class Scanner {
      StreamTokenizer in;
      boolean forceMode = false;

      Scanner(InputStream is, String codePage, boolean forceMode) {
         in = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
         if (!forceMode) {
            in.resetSyntax();
            in.wordChars(33, 255);
            in.whitespaceChars(0, 32);
         }
      }

      Scanner(InputStream is, String codePage) {
         in = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
         if (!forceMode) {
            in.resetSyntax();
            in.wordChars(33, 255);
            in.whitespaceChars(0, 32);
         }
      }

      String next() {
         try {
            in.nextToken();
            return in.sval;
         } catch (Exception e) {
            throw new Error();
         }
      }

      int nextInt() {
         if (forceMode) {
            try {
               in.nextToken();
               return (int) in.nval;
            } catch (Exception e) {
               throw new Error();
            }
         } else {
            return Integer.parseInt(next());
         }
      }

      long nextLong() {
         if (forceMode) {
            throw new Error("No long at force mod!");
         } else {
            return Long.parseLong(next());
         }

      }

      double nextDouble() {
         if (forceMode) {
            try {
               in.nextToken();
               return in.nval;
            } catch (Exception e) {
               throw new Error();
            }
         } else {
            return Double.parseDouble(next());
         }
      }
   }

   static class Assertion {
      static void checkRE(boolean e) {
         if (!e) {
            throw new Error();
         }
      }

      static void checkTL(boolean e) {
         if (!e) {
            int idx = 1;
            while (idx > 0) {
               idx++;
            }
         }
      }
   }

   Scanner in;
   PrintWriter out;

   class Int implements Comparable<Int> {
      int value;
      int pos;

      public Int(int value, int pos) {
         this.value = value;
         this.pos = pos;
      }

      @Override
      public int compareTo(Int second) {
         if (this.value == second.value) {
            return this.pos - second.pos;
         } else {
            return this.value - second.value;
         }
      }
   }

   void solve() {
      int n = in.nextInt();
      Int ar[] = new Int[n];
      for (int i = 0; i < ar.length; i++) {
         ar[i] = new Int(in.nextInt(), i);
      }
      Arrays.sort(ar);
      int cnt = 0;
      for (int i = 0; i < ar.length; i++) {
         if (ar[i].value!=ar[ar[i].pos].value) {
            cnt++;
         }
      }
      if (cnt == 2 || cnt == 0) {
         out.println("YES");
      } else {
         out.println("NO");
      }

   }

   final static String fileName = "";

   void run() {
      // try {
      // in = new Scanner(new FileInputStream(fileName + ".in"), "ISO-8859-1");
      // out = new PrintWriter(fileName + ".out", "ISO-8859-1");
      // } catch (FileNotFoundException e) {
      // throw new Error(e);
      //
      // } catch (UnsupportedEncodingException e) {
      // throw new Error(e);
      // }
      in = new Scanner(System.in, "");
      out = new PrintWriter(System.out);
      try {
         solve();
      } catch (Exception e) {
         throw new Error(e);
      } finally {
         out.close();
      }
   }

   public static void main(String[] args) {
      new Main().run();
   }
}