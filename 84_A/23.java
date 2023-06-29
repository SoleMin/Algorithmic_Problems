import java.io.*;

public class N72A
{
    StreamTokenizer in;
    PrintWriter out;

    int nextInt() throws IOException
    {
        in.nextToken();
        return (int) in.nval;
    }

    double nextDouble() throws IOException
    {
        in.nextToken();
        return in.nval;
    }

    public void init() throws Exception
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) : new FileReader(new File("input.txt"));
        Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter(new File("output.txt"));
        in = new StreamTokenizer(reader);
        out = new PrintWriter(writer);
    }

    public void solve() throws Exception
    {
        int n = nextInt();
        out.print(2*n - (n/2));
    }

    public void print() throws Exception
    {
        out.flush();
    }

    public void run() throws Exception
    {
        init();
        solve();
        print();
    }

    public static void main(String[] args) throws Exception
    {
        new N72A().run();
    }
}