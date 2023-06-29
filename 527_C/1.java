import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class C {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int w = in.nextInt();
        int h = in.nextInt();
        int n = in.nextInt();
        TreeSet<Integer> wt = new TreeSet<Integer>();
        wt.add(0);
        wt.add(w);
        TreeSet<Integer> ht = new TreeSet<Integer>();
        ht.add(0);
        ht.add(h);
        TreeMap<Integer, Integer> mw = new TreeMap<Integer, Integer>();
        mw.put(w, 1);
        TreeMap<Integer, Integer> mh = new TreeMap<Integer, Integer>();
        mh.put(h, 1);
        for (int i = 0; i < n; i++) {
            String s = in.next();
            int c = in.nextInt();
            if (s.charAt(0) == 'H') {
                addNewCut(mh, ht, c);
            } else {
                addNewCut(mw, wt, c);
            }
            long hl = (long)mh.lastKey();
            long wl = (long)mw.lastKey();
            out.println(hl * wl);
        }
        out.close();
    }
    
    private static void addNewCut(TreeMap<Integer, Integer> max, TreeSet<Integer> t, int cut) {
        int l = t.lower(cut);
        int h = t.higher(cut);
        int dif = h - l;
        int k = max.get(dif);
        if (k <= 1) {
            max.remove(dif);
        } else {
            max.put(dif, k - 1);
        }
        t.add(cut);
        
        Integer p = max.get(cut - l);
        if (p == null) {
            max.put(cut - l, 1);
        } else {
            max.put(cut - l, p + 1);
        }

        p = max.get(h - cut);
        if (p == null) {
            max.put(h - cut, 1);
        } else {
            max.put(h - cut, p + 1);
        }
    }
   
}

class InputReader {
public BufferedReader reader;
public StringTokenizer tokenizer;

public InputReader(InputStream stream) {
  reader = new BufferedReader(new InputStreamReader(stream), 32768);
  tokenizer = null;
}

public String next() {
  while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
          tokenizer = new StringTokenizer(reader.readLine());
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }
  return tokenizer.nextToken();
}

public int nextInt() {
  return Integer.parseInt(next());
}

}