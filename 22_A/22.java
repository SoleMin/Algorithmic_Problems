import static java.util.Arrays.sort;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SecondOrderStatistics implements Runnable
{
  public static void main(String[] args) throws Exception
  {
    new SecondOrderStatistics().run();
  }

  private void solve() throws Exception
  {
    int n = nextInt();
    SortedSet<Integer> sset = new TreeSet<Integer>();
    for (int i = 0; i < n; i++)
    {
      int a = nextInt();
      sset.add(a);
    }

    if (sset.size() < 2)
      out.println("NO");
    else
    {
      Integer v[] = (Integer[]) sset.toArray(new Integer[sset.size()]);
      sort(v);
      out.println(v[1]);
    }
  }

  // -------------- Input/Output routines below ---------------//
  private BufferedReader in;
  PrintWriter out;
  StringTokenizer tokenizer;

  public void run()
  {
    // String problem = this.getClass().getName();
    try
    {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new BufferedOutputStream(System.out));
      solve();
      out.flush();
      in.close();
      out.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      // System.exit(1);
    }
  }

  String nextToken() throws IOException
  {
    while (tokenizer == null || !tokenizer.hasMoreTokens())
    {
      tokenizer = new StringTokenizer(in.readLine());
    }
    return tokenizer.nextToken();
  }

  int nextInt() throws IOException
  {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException
  {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException
  {
    return Double.parseDouble(nextToken());
  }

}