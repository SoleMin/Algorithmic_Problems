//package codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class CodeForces {

    //private static MyScanner sc;
    private static MyPrinter out;

    public static void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        String ls = Long.toBinaryString(l);
        String rs = Long.toBinaryString(r);
        while (ls.length() < rs.length()) {
            ls = "0" + ls;
        }
        String res = "";
        boolean ok = false;
        for (int i = 0; i < ls.length(); i++) {
            if (ok) {
                res += "1";
            } else {
                if (ls.charAt(i) != rs.charAt(i)) {
                    res += "1";
                    ok = true;
                }
            }
        }
        long all = 0;
        for (int i = 0; i < res.length(); i++) {
            all += (long) Math.pow((long) 2, (long) res.length() - 1 - i);
        }
        System.out.println(all);
    }

    public static void main(String[] args) throws IOException {
        //sc = new MyScanner(System.in);
        out = new MyPrinter(System.out);
        solve();
        out.close();
    }
}

class MyScanner {

    private StreamTokenizer st;

    public MyScanner(InputStream is) {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
    }

    public MyScanner(File f) throws FileNotFoundException {
        st = new StreamTokenizer(new BufferedReader(new FileReader(f)));
    }

    public int nextInt() throws IOException {
        st.nextToken();
        return ((int) st.nval);
    }

    public double nextDouble() throws IOException {
        st.nextToken();
        return (st.nval);
    }

    public String nextString() throws IOException {
        st.nextToken();
        if (st.ttype == StreamTokenizer.TT_WORD) {
            return (st.sval);
        } else {
            return ("not found");
        }
    }
}

class MyPrinter {

    private BufferedWriter out;

    public MyPrinter(OutputStream os) {
        out = new BufferedWriter(new PrintWriter(os));
    }

    public MyPrinter(File f) throws IOException {
        out = new BufferedWriter(new FileWriter(f));
    }

    public void println(int i) throws IOException {
        out.write(Integer.toString(i));
        out.newLine();
    }

    public void println(double d) throws IOException {
        out.write(Double.toString(d));
        out.newLine();
    }

    public void println(long l) throws IOException {
        out.write(Long.toString(l));
        out.newLine();
    }

    public void println(String s) throws IOException {
        out.write(s);
        out.newLine();
    }

    public void println(char c) throws IOException {
        out.write(Character.toString(c));
        out.newLine();
    }

    public void print(int i) throws IOException {
        out.write(Integer.toString(i));
    }

    public void print(double d) throws IOException {
        out.write(Double.toString(d));
    }

    public void print(long l) throws IOException {
        out.write(Long.toString(l));
    }

    public void print(String s) throws IOException {
        out.write(s);
    }

    public void print(char c) throws IOException {
        out.write(Character.toString(c));
    }

    public void close() throws IOException {
        out.flush();
        out.close();
    }
}