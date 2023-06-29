
import java.io.*;
import java.util.*;

public class Main implements Runnable
{
  Scanner in;
  PrintWriter out; //= new PrintWriter(System.out);

  public static void main(String[] args) throws FileNotFoundException, IOException
  {
    new Thread(new Main()).start();
  }

  public class Pair
  {
    public long last;
    public long count;
    public int L;
    Pair(long l, long c) {last = l; count = c;}
    Pair(long l, long c, int L) {last = l; count = c; this.L = L;}
  }

  public void run()
  {
    final String name = "B-small";
    //try {
      in = new Scanner(System.in);// (new File(name + ".in"));//StreamTokenizer(new FileReader(new File(name + ".in")));
      out = new PrintWriter(System.out); // new PrintWriter(new File(name + ".out")); //= new PrintWriter(System.out);
    //} catch (IOException e) {}


    String s = in.next().trim();
    int n = s.length();
    boolean[][] a = new boolean[n][n];

   for (int i = 0; i < n; ++i)
     for (int j = i + 1; j < n; ++j)
       a[i][j] = (s.charAt(i) == s.charAt(j));

    int max = 0;
    for (int i = 0; i < n; ++i)
     for (int j = i + 1; j < n; ++j)
     {
       int k =0;
       while (i + k < n && j + k < n && a[i + k][j + k])
           ++k;
       
       if (max < k)
           max = k;
     }
    
    out.println(max);
    out.flush();
  }

}
