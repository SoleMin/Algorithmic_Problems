import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class CFJava {
    private static void println(Integer n) {
        System.out.println(n);
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void print(Integer n) {
        System.out.print(n);
    }

    private static void print(String s) {
        System.out.print(s);
    }


    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] a = scanner.getIntArray(n);
        Arrays.sort(a);
        TreeSet<Integer> res = new TreeSet<Integer>();
        for (Integer i: a){
            if (!res.contains(i/k)||(i%k!=0))
                res.add(i);
        }
        println(res.size());
    }
}

class Pair {
    public int x;
    public int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MyScanner {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String[] buffer;
    private int pos = 0;

    public Integer nextInt() throws IOException {
        if (buffer == null) {
            buffer = in.readLine().split(" ");
            pos = 0;
        }
        if (buffer.length <= pos) {
            buffer = in.readLine().split(" ");
            pos = 0;
        }
        pos++;
        return Integer.parseInt(buffer[pos - 1]);
    }

    public String nextString() throws IOException {
        if (buffer == null) {
            buffer = in.readLine().split(" ");
            pos = 0;
        }
        if (buffer.length <= pos) {
            buffer = in.readLine().split(" ");
            pos = 0;
        }
        pos++;
        return buffer[pos - 1];
    }

    public ArrayList<Integer> getIntList(Integer n) throws IOException {
        ArrayList<Integer> result = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++)
            result.add(nextInt());
        return result;
    }

    public Integer[] getIntArray(Integer n) throws IOException {
        Integer[] result = new Integer[n];
        for (int i = 0; i < n; i++)
            result[i]= (nextInt());
        return result;
    }

}
