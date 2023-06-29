import static java.lang.Math.max;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GivenString implements Runnable
{
  public static void main(String[] args) throws Exception
  {
    new GivenString().run();
  }

  private void solve() throws Exception
  {
    String s = nextToken();
    int len = s.length();
    KMP kmp = new KMP();
    int r = 0;
    for (int i = 0; i < len; i++)
    {
      for (int j = i + 1; j <= len; j++)
      {
        String cur = s.substring(i, j);
        int count = kmp.search(s, cur);
        if (count >= 2)
          r = max(r, cur.length());
      }
    }
    out.println(r);
  }

  class KMP
  {
    public int search(String text, String pattern)
    {
      int count = 0;
      int n = text.length(), m = pattern.length(), matchPoint = -1;
      char pat[] = pattern.toCharArray(), t[] = text.toCharArray();
      int p[] = prefixTable(pattern);
      int j = 0;
      for (int i = 0; i < n; i++)
      {
        while (j > 0 && pat[j] != t[i])
          j = p[j - 1];
        if (pat[j] == t[i])
          j++;
        if (j == m)
        {
          matchPoint = i - m + 1;
          j = p[j - 1];
          count++;
        }
      }
      return count;
    }

    private int[] prefixTable(String pat)
    {
      int m = pat.length(), p[] = new int[m];
      char s[] = pat.toCharArray();
      int j = 0;
      for (int i = 1; i < m; i++)
      {
        while (j > 0 && s[j] != s[i])
          j = p[j - 1];
        if (s[j] == s[i])
          j++;
        p[i] = j;
      }
      return p;
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