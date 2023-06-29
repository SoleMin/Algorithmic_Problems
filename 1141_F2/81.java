import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        F1BlokiRavnoiSummiProstayaRedakciya solver = new F1BlokiRavnoiSummiProstayaRedakciya();
        solver.solve(1, in, out);
        out.close();
    }

    static class F1BlokiRavnoiSummiProstayaRedakciya
    {
        InputReader in;
        Map<Long, List<F1BlokiRavnoiSummiProstayaRedakciya.Block>> sums;

        public void solve(int testNumber, InputReader in, PrintWriter out)
        {
            this.in = in;

            int n = ni();
            long[] a = nla(n);

            sums = new HashMap<>();
            for (int i = 0; i < n; i++)
            {
                long sum = 0;
                for (int j = i; j < n; j++)
                {
                    sum += a[j];
                    sums.computeIfAbsent(sum, k -> new ArrayList<>()).add(
                                    new F1BlokiRavnoiSummiProstayaRedakciya.Block(i, j, sum));
                }
            }

            for (Map.Entry<Long, List<F1BlokiRavnoiSummiProstayaRedakciya.Block>> e : sums.entrySet())
            {
                Collections.sort(e.getValue());
            }

            List<F1BlokiRavnoiSummiProstayaRedakciya.Block> res = Collections.emptyList();
            for (Map.Entry<Long, List<F1BlokiRavnoiSummiProstayaRedakciya.Block>> e : sums.entrySet())
            {
                List<F1BlokiRavnoiSummiProstayaRedakciya.Block> blocks = e.getValue();
                List<F1BlokiRavnoiSummiProstayaRedakciya.Block> updated = new ArrayList<>();

                for (F1BlokiRavnoiSummiProstayaRedakciya.Block next : blocks)
                {
                    if (updated.size() == 0)
                        updated.add(next);
                    else
                    {
                        F1BlokiRavnoiSummiProstayaRedakciya.Block prev = updated.get(updated.size() - 1);
                        if (next.l > prev.r)
                            updated.add(next);
                    }
                }

                if (updated.size() > res.size())
                    res = updated;
            }

            StringBuilder resS = new StringBuilder();
            resS.append(res.size()).append('\n');
            for (F1BlokiRavnoiSummiProstayaRedakciya.Block block : res)
                resS.append(block.l + 1).append(' ').append(block.r + 1).append('\n');

            out.println(resS);
        }

        private long[] nla(int size)
        {
            return in.nextLongArray(size);
        }

        private int ni()
        {
            return in.nextInt();
        }

        static class Block implements Comparable<F1BlokiRavnoiSummiProstayaRedakciya.Block>
        {
            int l;
            int r;
            long sum;

            public Block(int l, int r, long sum)
            {
                this.l = l;
                this.r = r;
                this.sum = sum;
            }

            public int compareTo(F1BlokiRavnoiSummiProstayaRedakciya.Block o)
            {
                int res = Integer.compare(r, o.r);
                if (res == 0)
                    res = Integer.compare(l, o.l);
                return res;
            }

        }

    }

    static class InputReader
    {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in)
        {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public long[] nextLongArray(int size)
        {
            long[] array = new long[size];
            for (int i = 0; i < size; ++i)
            {
                array[i] = nextLong();
            }
            return array;
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }

        public String next()
        {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine()
        {
            String line;
            try
            {
                line = reader.readLine();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

