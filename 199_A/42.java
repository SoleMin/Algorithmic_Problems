import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class Hexadec implements Runnable {

    final static String taskname = "filename";

    public void solve() throws Exception {
    //	int n = iread();	
    	int n = Integer.parseInt(in.readLine());
    	
    	
    	
    	out.write(n + " "+0+" "+0);
    //    out.write(ans_path + "\n");
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
//             in = new BufferedReader(new FileReader(taskname + ".in"));
//             out = new BufferedWriter(new FileWriter(taskname + ".out"));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int iread() throws Exception {
        return Integer.parseInt(readword());
    }

    public double dread() throws Exception {
        return Double.parseDouble(readword());
    }

    public long lread() throws Exception {
        return Long.parseLong(readword());
    }

    BufferedReader in;

    BufferedWriter out;

    public String readword() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = in.read();
        while (c >= 0 && c <= ' ')
            c = in.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = in.read();
        }
        return b.toString();
    }

    public static void main(String[] args) {
        // Locale.setDefault(Locale.US);
        new Thread(new Hexadec()).start();
    }
}