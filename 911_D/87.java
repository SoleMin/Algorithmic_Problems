
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.math.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws Exception{
        IO io = new IO(null,null);
        int n = io.getNextInt(),ans = 0;
        int [] A = new int[n];
        for (int i = 0;i < n;i++) {
            A[i] = io.getNextInt();
            for (int j = 0;j < i;j++)
                ans ^= (A[j] > A[i]) ? 1 : 0;
        }
        String [] word = {"even","odd"};
        int m = io.getNextInt();
        for (int i = 0;i < m;i++) {
            int l = io.getNextInt(),r = io.getNextInt();
            int len = r - l + 1;
            long tot = len*(len - 1L)/2;
            ans ^= tot & 1;
            io.println(word[ans]);
        }
        io.close();
    }
}



class IO{
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter writer;
    private String inputFile,outputFile;

    public boolean hasMore() throws IOException{
        if(st != null && st.hasMoreTokens()) return true;
        if(br != null && br.ready()) return true;
        return false;
    }
    public String getNext() throws FileNotFoundException, IOException{
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public String getNextLine() throws FileNotFoundException, IOException{
        return br.readLine().trim();
    }

    public int getNextInt() throws FileNotFoundException, IOException{
        return Integer.parseInt(getNext());
    }
    public long getNextLong() throws FileNotFoundException, IOException{
        return Long.parseLong(getNext());
    }

    public void print(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f" ,x);
    }
    public void println(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f\n" ,x);
    }
    public void print(Object o) throws  IOException{
        writer.print(o.toString());
    }

    public void println(Object o) throws  IOException{
        writer.println(o.toString());
    }
    public IO(String x,String y) throws FileNotFoundException, IOException{
        inputFile = x;
        outputFile = y;
        if(x != null) br = new BufferedReader(new FileReader(inputFile));
        else br = new BufferedReader(new InputStreamReader(System.in));
        if(y != null) writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        else writer = new PrintWriter(new OutputStreamWriter(System.out));
    }

    protected void close() throws IOException{
        br.close();
        writer.close();
    }
    public void outputArr(Object [] A) throws IOException{
        int L = A.length;
        for (int i = 0;i < L;i++) {
            if(i > 0) writer.print(" ");
            writer.print(A[i]);
        }
        writer.print("\n");
    }
}

