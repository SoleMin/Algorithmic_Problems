import java.awt.Point;
import java.io.*;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.*;


public class Main {

    final boolean ONLINE_JUDGE = !new File("input.txt").exists();
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
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

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class LOL implements Comparable<LOL> {
        int x;
        int y;


        public LOL(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(LOL o) {

            if (o.x != x)
                return (int) (o.x - x); // ---->
            return (int) (y - o.y); // <----
        }

    }

    long modulo = 1000 * 1000 * 1000 + 7;
    long binPow (long a, long b) {
        if(b == 0) return 1;
        long c = binPow(a, b / 2);
        long ans = (c * c) % modulo;
        if(b % 2 == 1) ans = (ans * a) % modulo;
        return ans;
    }



    int[] gcd (int a, int b) {
        int[] res = new int[3];
        if (a == 0) {
            res[0] = b; res[1] = 0; res[2] = -1;
            return res;
        }
        res = gcd (b%a, a);
        int x = -(res[2] + (b / a) * res[1]);
        int y = - res[1];
        res[1] = x;
        res[2] = y;
        return res;
    }


    public void solve() throws IOException {
        int n = readInt();
        HashMap<Character,Integer> mapa = new HashMap<>();

        char[] s = readString().toCharArray();

        for(int i = 0; i < n; i++) {
            if(mapa.containsKey(s[i])) {
                int x = mapa.get(s[i]);
                mapa.replace(s[i], x + 1);
            }
            else mapa.put(s[i], 1);
        }

        int sz = mapa.size();
        mapa = new HashMap<>();
        int i = 0;
        while (mapa.size() < sz) {
            if(mapa.containsKey(s[i])) {
                int x = mapa.get(s[i]);
                mapa.replace(s[i], x + 1);
            }
            else mapa.put(s[i], 1);
            i++;
        }
        int ans = i;

        int left = 0;
        int right = i - 1;

        while(right < n) {
            while(left < right) {
                int y = mapa.get(s[left]);
                if(y == 1) mapa.remove(s[left]);
                else mapa.replace(s[left], y - 1);
                if(mapa.size() == sz) {
                    ans = Math.min(ans, right - left);
                    left++;
                }
                else {
                    left++;
                    break;
                }
            }

            right++;
            if(right < n) {
                if (mapa.containsKey(s[right])) {
                    int x = mapa.get(s[right]);
                    mapa.replace(s[right], x + 1);
                } else mapa.put(s[right], 1);
            }

        }

        out.print(ans);

    }
}