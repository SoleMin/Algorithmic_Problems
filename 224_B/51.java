import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

public class Array implements Runnable {

    void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int a[] = new int[n];
        int startIdx = 0;
        int endIdx = -1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i ++) {
            a[i] = readInt();
            if(map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
            if(map.size() == k && endIdx == -1) {
                endIdx = i;
                break;
            }
        }

        if(endIdx != -1) {
            while(startIdx < n && map.get(a[startIdx])>1) {
                map.put(a[startIdx], map.get(a[startIdx]) - 1);
                startIdx ++;
            }
            startIdx ++;
            endIdx   ++;
        } else
            startIdx = -1;

        out.println((startIdx)+" "+(endIdx));


    }



    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Array().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("/Users/shenchen/input.txt"));
                out = new PrintWriter("/Users/shenchen/output.txt");
            }
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }


}