import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Code implements Runnable {

    public static void main(String[] args) throws IOException {
        new Thread(new Code()).start();
    }

    private void solve() throws IOException {
        taskB();
    }

    private void taskB() throws IOException {
        int n = nextInt(), k = nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i)  arr[i] = nextInt();

        int i = 0;
        while(i < n - 1 && arr[i] == arr[i + 1])    ++i;

        if(k == 1)
            writer.println(1 + " " + 1);
        else if(k == 2 && i == n - 2)
            writer.println(n - 1 + " " + n);
        else {
            if(i == n - 1)
                writer.println(-1 + " " + -1);
            else {
                int l = i;
                Map<Integer, Integer> set = new HashMap<Integer, Integer>(n);
                while(i < n && set.size() < k) {
                    if(set.containsKey(arr[i])) set.put(arr[i], set.get(arr[i]) + 1);
                    else    set.put(arr[i], 1);
                    i += 1;
                }
                if(set.size() < k)  writer.println(-1 + " " + -1);
                else {
                    while(l < i && i - l > k && set.get(arr[l]) > 1) {
                        set.put(arr[l], set.get(arr[l]) - 1);
                        l += 1;
                    }
                    writer.println((l + 1) + " " + i);
                }
            }
        }
    }

    private class Pair<E extends Comparable, V extends Comparable> implements Comparable<Pair<E, V>> {
        public Pair(E first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair<E, V> obj) {
            if(first.equals(obj.first))  return second.compareTo(obj.second);
            return first.compareTo(obj.first);
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair)obj;
            return first.equals(other.first) && second.equals(other.second);
        }

        public E first;
        public V second;
    }

    @Override
    public void run() {
        try {
            if(in.equals(""))   reader = new BufferedReader(new InputStreamReader(System.in));
            else    reader = new BufferedReader(new FileReader(in));

            if(out.equals(""))  writer = new PrintWriter(new OutputStreamWriter(System.out));
            else    writer = new PrintWriter(new FileWriter(out));
            solve();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    private String nextToken() throws IOException {
        while(st == null || !st.hasMoreTokens())    st = new StringTokenizer(reader.readLine());
        return st.nextToken();
    }

    private String in = "", out = "";
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer st;
}