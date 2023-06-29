import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.io.Writer;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        
        
        int n = in.nextInt();
        int a[] = in.nextIntArray(n);
        int i,j,k;

        int b[] = a.clone();
        ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        
        int c[] = new int[n];
        k=0;
        for(i=0;i<n;++i) if(a[i]!=b[i]) c[k++] = i;
        
        String res = "NO";
        if(k==0){
            res = "YES";
        }else
        if(k==1){
           
        }else
        if(k==2){
            i = c[0]; j = c[1];
            if(a[i]==b[j] && a[j]==b[i]) res = "YES";
        }
        
        out.writeln(res);
	}
}

class InputReader{
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    
    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    
    public String next(){
        while(tokenizer==null || !tokenizer.hasMoreTokens()){
            try{
                tokenizer = new StringTokenizer(reader.readLine());
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    
    public int nextInt(){
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int size){
        int array[] = new int[size];
        for(int i=0; i<size; ++i) array[i] = nextInt();
        return array;
    }
}

class OutputWriter{
    private PrintWriter out;
    
    public OutputWriter(Writer out){
        this.out = new PrintWriter(out);
    }

    public OutputWriter(OutputStream out){
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
    }
    
    public void close(){
        out.flush();
        out.close();
    }

    public void writeln(Object ... o){
        for(Object x : o) out.print(x);
        out.println();
    }
}

class ArrayUtils{
    private final static Random random = new Random(System.nanoTime());
    
    public static void randomShuffle(int a[]){
        int n = a.length;
        for(int i=0;i<n;++i){
            int j = random.nextInt(n-i);
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
    }
}

