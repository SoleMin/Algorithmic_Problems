import java.util.Map;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.io.PrintWriter;
import java.util.Deque;
import java.math.BigInteger;
import java.util.Queue;
import java.util.Collection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author karan173
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB
{
    int val[];
    int p[];
    int aneigh[], bneight[], deg[];
    Deque<Integer> mycycle;
    boolean loops = false;
    public void solve(int testNumber, FastReader in, PrintWriter out)
    {
        int n = in.ni ();
        val = new int[n];
        int a = in.ni ();
        int b = in.ni ();
        Map<Integer, Integer> set = new TreeMap<Integer, Integer> ();
        p = in.iArr (n);
        for (int i = 0; i < n; i++)
        {
            set.put (p[i], i);
        }
        aneigh = new int[n];
        bneight = new int[n];
        deg = new int[n];
        for (int i = 0; i < n; i++)
        {
            aneigh[i] = val[i] = bneight[i] = -1;
            deg[i] = 0;
        }
        Queue<Integer> queue = new ArrayDeque<Integer> ();
        for (int i = 0; i < n; i++)
        {
            Integer x1 = set.get (a - p[i]);
            Integer x2 = set.get (b - p[i]);
            if (x1 != null)
            {
                aneigh[i] = x1;
                deg[i]++;
            }
            if (x2 != null && a != b)
            {
                bneight[i] = x2;
                deg[i]++;
            }
            if (deg[i] == 1)
            {
                queue.add (i);
            }
        }

        while (!queue.isEmpty ())
        {
            int idx = queue.remove ();
            if (deg[idx] != 1)
            {
                continue;
            }
            int aa = aneigh[idx];
            int bb = bneight[idx];
            if (aa != -1)
            {
                val[idx] = val[aa] = 0;
                deg[aa]--;
                deg[idx]--;
                aneigh[aa] = -1;
                aneigh[idx] = -1;
                if (deg[aa] == 1)
                {
                    int zz = bneight[aa];
                    bneight[zz] = -1;
                    deg[zz]--;
                    if(deg[zz] == 1)
                    queue.add (zz);
                }
            }
            else
            {
                val[idx] = val[bb] = 1;
                deg[bb]--;
                deg[idx]--;
                bneight[idx] = bneight[bb] = -1;
                if (deg[bb] == 1)
                {
                    //queue.add (bb);
                    int zz = aneigh[bb];
                    aneigh[zz] = -1;
                    deg[zz]--;
                    if(deg[zz] == 1)
                        queue.add (zz);
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (val[i] == -1 && cantBePaired(i))
            {
                out.println ("NO");
                return;
            }
        }

        //every person has two neighbours

        //cases => either cycles or linear path with loops end points
        for (int i = 0; i < n; i++)
        {
            if (val[i] == -1)
            {
                mycycle = new ArrayDeque<Integer> ();
                loops = false;
                cycle (i);
                if (loops || mycycle.size () % 2 == 0)
                {
                    doEvenCycle ();
                    continue;
                }

                out.println ("NO");
                return;
            }
        }
        out.println ("YES");
        for (int i = 0; i < n; i++)
        {
            out.print (val[i] + " ");
        }
        out.println ();
    }

    private boolean cantBePaired(int i)
    {
        int aa = aneigh[i];
        int bb = bneight[i];
        if (aa != -1 && val[aa] == -1)
        {
            return false;
        }
        if (bb != -1 && val[bb] == -1)
        {
            return false;
        }
        return true;
    }


    private void doEvenCycle()
    {
        for (int x : mycycle)
        {
            val[x] = 0;
        }
    }

    private void cycle(int i)
    {
        boolean aa = false;
        int prev = i;
        mycycle.addLast (i);
        System.out.println (i);
        int j = aneigh[i];
        while (j != i)
        {
            if (j == prev)
            {
                loops = true;
                break;
            }
            mycycle.addLast (j);
            System.out.println (j);
            prev = j;
            j = aa ? aneigh[j] : bneight[j];
//            if (j == -1)
//            {
//                System.out.println (prev + " " + aneigh[prev] + bneight[prev] + " " + deg[prev] + " " + val[prev] + " " + val[64] + " " + deg[64]);
//            }
            aa = !aa;
        }

        if (loops)
        {
            j = bneight[i];
            prev = i;
            aa = true;
            while (prev != j)
            {
                mycycle.addFirst (j);

                prev = j;
                j = aa ? aneigh[j] : bneight[j];
                aa = !aa;
            }
        }
        System.out.println ("XXX");
    }
}

class FastReader
{

    public InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public FastReader(InputStream stream)
    {
        this.stream = stream;
    }

    public FastReader()
    {

    }

    public int read()
    {
        if (numChars == -1)
        {
            throw new InputMismatchException ();
        }
        if (curChar >= numChars)
        {
            curChar = 0;
            try
            {
                numChars = stream.read (buf);
            } catch (IOException e)
            {
                throw new InputMismatchException ();
            }
            if (numChars <= 0)
            {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int ni()
    {
        int c = read ();
        while (isSpaceChar (c))
            c = read ();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read ();
        }
        int res = 0;
        do
        {
            if (c < '0' || c > '9')
            {
                throw new InputMismatchException ();
            }
            res *= 10;
            res += c - '0';
            c = read ();
        } while (!isSpaceChar (c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c)
    {
        if (filter != null)
        {
            return filter.isSpaceChar (c);
        }
        return isWhitespace (c);
    }

    public static boolean isWhitespace(int c)
    {
        return c==' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int[] iArr(int n)
    {
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = ni ();
        }
        return a;
    }

    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}
