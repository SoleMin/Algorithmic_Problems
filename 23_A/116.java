import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Prateep
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskB solver = new TaskB();
    solver.solve(1, in, out);
    out.close();
    }
}

class TaskB{
    public void solve(int testNumber, InputReader in, PrintWriter out){
        String base = in.next();
    for (int len=base.length()-1;len>=1;len--)
            for (int i=0;i<base.length()-len+1;i++)
                for (int j=i+1;j<base.length()-len+1;j++)
                    if (base.substring(i,i+len).equals(base.substring(j,j+len))){
                        out.println(len);
            return;
                    }
    out.println(0);
    
    }
    
}
class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong(){
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
}
