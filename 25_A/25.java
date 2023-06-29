import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IQTest implements Runnable
{
  public static void main(String[] args) throws Exception
  {
    new IQTest().run();
  }

  private void solve() throws Exception
  {
    int n = nextInt();
    int a[] = new int[n];
    for (int i = 0; i < a.length; i++)
    {
      a[i] = nextInt();
    }

    int c0 = 0, c1 = 0;
    for (int i = 0; i < a.length; i++)
    {
      a[i] = a[i] % 2;
      if (a[i] == 0)
        c0++;
      else
        c1++;
    }

    int f = 0;
    if (c0 > c1)
      f = 1;
    else
      f = 0;

    int r = 0;
    for (int i = 0; i < a.length; i++)
    {
      if (a[i] == f)
      {
        r = i + 1;
        break;
      }
    }
    out.println(r);
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