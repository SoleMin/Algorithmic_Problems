import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A {

    public void solve() throws Exception {
        
        int n = nextInt();
        int[] p = nextArr(n);
        Arrays.sort(p);
        int sum = 0;
        for (int i=0; i<n; ++i) sum+=p[i];
        int curr = 0;
        for (int i=n-1; i>=0; --i) {
            curr += p[i];
            if (curr>sum-curr) halt(n-i);
        }
        
    }

    

    ////////////////////////////////////////////////////////////////////////////
    
    boolean showDebug = true;
    static boolean useFiles = false;
    static String inFile = "input.txt";
    static String outFile = "output.txt";

    double EPS = 1e-7;
    int INF = Integer.MAX_VALUE;
    long INFL = Long.MAX_VALUE;
    double INFD = Double.MAX_VALUE;

    
    int absPos(int num) {
        return num<0 ? 0:num;
    }
    long absPos(long num) {
        return num<0 ? 0:num;
    }
    double absPos(double num) {
        return num<0 ? 0:num;
    }
    
    int min(int... nums) {
        int r = Integer.MAX_VALUE;
        for (int i: nums)
            if (i<r) r=i;
        return r;
    }
    int max(int... nums) {
        int r = Integer.MIN_VALUE;
        for (int i: nums)
            if (i>r) r=i;
        return r;
    }
    long minL(long... nums) {
        long r = Long.MAX_VALUE;
        for (long i: nums)
            if (i<r) r=i;
        return r;
    }
    long maxL(long... nums) {
        long r = Long.MIN_VALUE;
        for (long i: nums)
            if (i>r) r=i;
        return r;
    }
    double minD(double... nums) {
        double r = Double.MAX_VALUE;
        for (double i: nums)
            if (i<r) r=i;
        return r;
    }
    double maxD(double... nums) {
        double r = Double.MIN_VALUE;
        for (double i: nums)
            if (i>r) r=i;
        return r;
    }
    
    long sumArr(int[] arr) {
        long res = 0;
        for (int i: arr)
            res+=i;
        return res;
    }
    long sumArr(long[] arr) {
        long res = 0;
        for (long i: arr)
            res+=i;
        return res;
    }
    double sumArr(double[] arr) {
        double res = 0;
        for (double i: arr)
            res+=i;
        return res;
    }

    long partsFitCnt(long partSize, long wholeSize) {
        return (partSize+wholeSize-1)/partSize;
    }

    boolean odd(long num) {
        return (num&1)==1;
    }
    
    boolean hasBit(int num, int pos) {
        return (num&(1<<pos))>0;
    }

    long binpow(long a, int n) {
        long r = 1;
        while (n>0) {
            if ((n&1)!=0) r*=a;
            a*=a;
            n>>=1;
        }
        return r;
    }

    boolean isLetter(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
    boolean isLowercase(char c) {
        return (c>='a' && c<='z');
    }
    boolean isUppercase(char c) {
        return (c>='A' && c<='Z');
    }
    boolean isDigit(char c) {
        return (c>='0' && c<='9');
    }
    
    boolean charIn(String chars, String s) {
        if (s==null) return false;
        if (chars==null || chars.equals("")) return true;
        for (int i=0; i<s.length(); ++i)
            for (int j=0; j<chars.length(); ++j)
                if (chars.charAt(j)==s.charAt(i)) return true;
        return false;
    }
    
    String stringn(String s, int n) {
        if (n<1 || s==null) return "";
        StringBuilder sb = new StringBuilder(s.length()*n);
        for (int i=0; i<n; ++i) sb.append(s);
        return sb.toString();
    }
    String str(Object o) {
        if (o==null) return "";
        return o.toString();
    }


    long timer = System.currentTimeMillis();
    void startTimer() {
        timer = System.currentTimeMillis();
    }
    void stopTimer() {
        System.err.println("time: "+(System.currentTimeMillis()-timer)/1000.0);
    }


    static class InputReader {
        private byte[] buf;
        private int bufPos = 0, bufLim = -1;
        private InputStream stream;
        public InputReader(InputStream stream, int size) {
            buf = new byte[size];
            this.stream = stream;
        }
        private void fillBuf() throws IOException {
            bufLim = stream.read(buf);
            bufPos = 0;
        }
        char read() throws IOException {
            if (bufPos>=bufLim) fillBuf(); 
            return (char)buf[bufPos++];
        }
        boolean hasInput() throws IOException {
            if (bufPos>=bufLim) fillBuf();
            return bufPos<bufLim;
        }
    }
    
    static InputReader inputReader;
    static BufferedWriter outputWriter;

    char nextChar() throws IOException {
        return inputReader.read();
    }
    char nextNonWhitespaceChar() throws IOException {
        char c = inputReader.read();
        while (c<=' ') c=inputReader.read();
        return c;
    }
    String nextWord() throws IOException {
        StringBuilder sb = new StringBuilder();
        char c = inputReader.read();
        while (c<=' ') c=inputReader.read();
        while (c>' ') {
            sb.append(c);
            c = inputReader.read();
        }
        return new String(sb);
    }
    String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        char c = inputReader.read();
        while (c<=' ') c=inputReader.read();
        while (c!='\n' && c!='\r') {
            sb.append(c);
            c = inputReader.read();
        }
        return new String(sb);
    }
    int nextInt() throws IOException {
        int r = 0;
        char c = nextNonWhitespaceChar();
        boolean neg = false;
        if (c=='-') neg=true;
        else r=c-48;
        c = nextChar();
        while (c>='0' && c<='9') {
            r*=10;
            r+=c-48;
            c=nextChar();
        }
        return neg ? -r:r;
    }
    long nextLong() throws IOException {
        long r = 0;
        char c = nextNonWhitespaceChar();
        boolean neg = false;
        if (c=='-') neg=true;
        else r = c-48;
        c = nextChar();
        while (c>='0' && c<='9') {
            r*=10L;
            r+=c-48L;
            c=nextChar();
        }
        return neg ? -r:r;
    }
    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextWord());
    }
    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i=0; i<size; ++i)
            arr[i] = nextInt();
        return arr;
    }
    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i=0; i<size; ++i)
            arr[i] = nextLong();
        return arr;
    }
    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i=0; i<size; ++i)
            arr[i] = nextDouble();
        return arr;
    }
    String[] nextArrS(int size) throws NumberFormatException, IOException {
        String[] arr = new String[size];
        for (int i=0; i<size; ++i)
            arr[i] = nextWord();
        return arr;
    }
    char[] nextArrCh(int size) throws IOException {
        char[] arr = new char[size];
        for (int i=0; i<size; ++i)
            arr[i] = nextNonWhitespaceChar();
        return arr;
    }
    char[][] nextArrCh(int rows, int columns) throws IOException {
        char[][] arr = new char[rows][columns];
        for (int i=0; i<rows; ++i)
            for (int j=0; j<columns; ++j)
                arr[i][j] = nextNonWhitespaceChar();
        return arr;
    }
    char[][] nextArrChBorders(int rows, int columns, char border) throws IOException {
        char[][] arr = new char[rows+2][columns+2];
        for (int i=1; i<=rows; ++i)
            for (int j=1; j<=columns; ++j)
                arr[i][j] = nextNonWhitespaceChar();
        for (int i=0; i<columns+2; ++i) {
            arr[0][i] = border;
            arr[rows+1][i] = border;
        }
        for (int i=0; i<rows+2; ++i) {
            arr[i][0] = border;
            arr[i][columns+1] = border;
        }
        return arr;
    }

    void printf(String format, Object... args) throws IOException {
        outputWriter.write(String.format(format, args));
    }
    void print(Object o) throws IOException {
        outputWriter.write(o.toString());
    }
    void println(Object o) throws IOException {
        outputWriter.write(o.toString());
        outputWriter.newLine();
    }
    void print(Object... o) throws IOException {
        for (int i=0; i<o.length; ++i) {
            if (i!=0) outputWriter.write(' ');
            outputWriter.write(o[i].toString());
        }
    }
    void println(Object... o) throws IOException {
        print(o);
        outputWriter.newLine();
    }
    void printn(Object o, int n) throws IOException {
        String s = o.toString();
        for (int i=0; i<n; ++i) {
            outputWriter.write(s);
            if (i!=n-1) outputWriter.write(' ');
        }
    }
    void printnln(Object o, int n) throws IOException {
        printn(o, n);
        outputWriter.newLine();
    }
    void printArr(int[] arr) throws IOException {
        for (int i=0; i<arr.length; ++i) {
            if (i!=0) outputWriter.write(' ');
            outputWriter.write(Integer.toString(arr[i]));
        }
    }
    void printArr(long[] arr) throws IOException {
        for (int i=0; i<arr.length; ++i) {
            if (i!=0) outputWriter.write(' ');
            outputWriter.write(Long.toString(arr[i]));
        }
    }
    void printArr(double[] arr) throws IOException {
        for (int i=0; i<arr.length; ++i) {
            if (i!=0) outputWriter.write(' ');
            outputWriter.write(Double.toString(arr[i]));
        }
    }
    void printArr(String[] arr) throws IOException {
        for (int i=0; i<arr.length; ++i) {
            if (i!=0) outputWriter.write(' ');
            outputWriter.write(arr[i]);
        }
    }
    void printArr(char[] arr) throws IOException {
        for (char c: arr) outputWriter.write(c);
    }
    void printlnArr(int[] arr) throws IOException {
        printArr(arr);
        outputWriter.newLine();
    }
    void printlnArr(long[] arr) throws IOException {
        printArr(arr);
        outputWriter.newLine();
    }
    void printlnArr(double[] arr) throws IOException {
        printArr(arr);
        outputWriter.newLine();
    }
    void printlnArr(String[] arr) throws IOException {
        printArr(arr);
        outputWriter.newLine();
    }
    void printlnArr(char[] arr) throws IOException {
        printArr(arr);
        outputWriter.newLine();
    }
    void halt(Object... o) throws IOException {
        if (o.length!=0) println(o);
        outputWriter.flush(); outputWriter.close();
        System.exit(0);
    }
    
    void debug(Object... o) {
        if (showDebug) System.err.println(Arrays.deepToString(o));
    }


    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        if (!useFiles) {
            inputReader = new InputReader(System.in, 1<<16);
            outputWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1<<16);
        } else {
            inputReader = new InputReader(new FileInputStream(new File(inFile)), 1<<16);
            outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFile))), 1<<16);
        }
        new A().solve();
        outputWriter.flush(); outputWriter.close();
    }
}
