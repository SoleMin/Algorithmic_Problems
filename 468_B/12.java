import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Set;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Mahmoud Aladdin <aladdin3>
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader jin, OutputWriter jout) {
        int n = jin.int32();
        int a = jin.int32();
        int b = jin.int32();



        Set<Integer> present = new HashSet<Integer>();
        int[] arr = new int[n];
        int[] sarr = new int[n];
        for(int i = 0; i < n; i++) {
            sarr[i] = arr[i] = jin.int32();
            present.add(arr[i]);
        }

        boolean rev = b < a;
        if(b < a) {b ^= a; a ^= b; b ^= a; }

        Arrays.sort(sarr);

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for(int i = 0; i < n; i++) {
            if(set1.contains(sarr)) continue;
            if(set2.contains(sarr)) continue;
            int comp1 = b - sarr[i];
            if(present.contains(comp1)) {
                set2.add(sarr[i]);
                set2.add(comp1);
                present.remove(comp1);
            } else {
                int comp2 = a - sarr[i];
                if(present.contains(comp2)) {
                    set1.add(sarr[i]);
                    set1.add(comp2);
                    present.remove(comp2);
                } else {
                    jout.println("NO");
                    return;
                }
            }
        }

        jout.println("YES");
        for(int i = 0; i < n; i++) {
            if(i != 0) jout.print(' ');
            if(rev) jout.print(set2.contains(arr[i])? 0 : 1);
            else jout.print(set1.contains(arr[i])? 0 : 1);
        }
    }
}

class InputReader {
    private static final int bufferMaxLength = 1024;
    private InputStream in;
    private byte[] buffer;
    private int currentBufferSize;
    private int currentBufferTop;
    private static final String tokenizers = " \t\r\f\n";
    
    public InputReader(InputStream stream) {
        this.in = stream;
        buffer = new byte[bufferMaxLength];
        currentBufferSize = 0;
        currentBufferTop = 0;
    }
    
    private boolean refill() {
        try {
            this.currentBufferSize = this.in.read(this.buffer);
            this.currentBufferTop = 0;
        } catch(Exception e) {}
        return this.currentBufferSize > 0;
    }
    
    
    private Byte readChar() {
        if(currentBufferTop < currentBufferSize) {
            return this.buffer[this.currentBufferTop++];
        } else {
            if(!this.refill()) {
                return null;
            } else {
                return readChar();
            }
        }
    }

    public String token()  {
        StringBuffer tok = new StringBuffer();
        Byte first;
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) != -1));
        if(first == null) return null;
        tok.append((char)first.byteValue());
        while((first = readChar()) != null && (tokenizers.indexOf((char) first.byteValue()) == -1)) {
            tok.append((char)first.byteValue());
        }
        return tok.toString();
    }
    
    public Integer int32() throws NumberFormatException {
        String tok = token();
        return tok == null? null : Integer.parseInt(tok);
    }

    }

class OutputWriter {
    private final int bufferMaxOut = 1024;
    private PrintWriter out;
    private StringBuilder output;
    private boolean forceFlush = false;

    public OutputWriter(OutputStream outStream) {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
        output = new StringBuilder(2 * bufferMaxOut);
    }

    public OutputWriter(Writer writer) {
        forceFlush = true;
        out = new PrintWriter(writer);
        output = new StringBuilder(2 * bufferMaxOut);
    }

    private void autoFlush() {
        if(forceFlush || output.length() >= bufferMaxOut) {
            flush();
        }
    }

    public void print(Object... tokens) {
        for(int i = 0; i < tokens.length; i++) {
            if(i != 0) output.append(' ');
            output.append(tokens[i]);
        }
        autoFlush();
    }

    public void println(Object... tokens) {
        print(tokens);
        output.append('\n');
        autoFlush();
    }

    public void flush() {
        out.print(output);
        output.setLength(0);
    }

    public void close() {
        flush();
        out.close();
    }
}

