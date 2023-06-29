import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

    public static void solve() throws Exception {
	int n = nextInt();
	int[] S = new int[n];
	for(int i=0;i<n;i++) {
	    S[i] = nextInt();
	    if(i > 0) {
		S[i] += S[i-1];
	    }
	}
	Map<Integer, List<L>> map = new HashMap<>();
	for(int j=0;j<n;j++) {
	    for(int i=j;i>=0;i--) {
		int sum = S[j];
		if(i > 0) {
		    sum -= S[i-1];
		}
		L l = new L();
		l.a = i;
		l.b = j;
		List<L> list = map.get(sum);
		if(list == null) {
		    list = new ArrayList<>();
		    map.put(sum, list);
		}
		list.add(l);
	    }
	}
	List<L> longest = null;
	for(Integer sum: map.keySet()) {
	    List<L> list = map.get(sum);
	    Collections.sort(list);
	    List<L> list2 = new ArrayList<>(list.size());
	    int from = list.get(0).a;
	    for(L l: list) {
		if(l.a >= from) {
		    list2.add(l);
		    from = l.b + 1;
		}
	    }
	    if(longest == null || longest.size() < list2.size()) {
		longest = list2;
	    }
	}
	
	println(longest.size());
	for(int i=0;i<longest.size();i++) {
	    L l = longest.get(i);
	    println((l.a+1) + " " + (l.b+1));
	}
    }
    
    private static class L implements Comparable<L>{
	int a;
	int b;
	
	@Override
	public int compareTo(L l2) {
	    return Integer.valueOf(b).compareTo(l2.b);
	}
    }
    
    public static void main(String[] args) throws Exception {
	try {
	    fastReader = new FastReader(System.in);
	    systemOut = new BufferedOutputStream(System.out);
	    solve();
	} finally {
	    systemOut.close();
	}
    }

    private static FastReader fastReader = null;
    private static BufferedOutputStream systemOut = null;

    public static void print(Object obj) {
	print(obj.toString());
    }

    public static void print(String str) {
	try {
	    systemOut.write(str.getBytes("utf-8"));
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static void println(Object obj) {
	println(obj.toString());
    }

    public static void println(String str) {
	try {
	    print(str);
	    systemOut.write('\n');
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static String next() {
	return fastReader.readNextToken(false);
    }

    public static String nextLine() {
	return fastReader.readNextToken(true);
    }

    public static int nextInt() {
	return Integer.parseInt(fastReader.readNextToken(false));
    }

    public static long nextLong() {
	return Long.parseLong(fastReader.readNextToken(false));
    }

    public static double nextDouble() {
	return Double.parseDouble(fastReader.readNextToken(false));
    }

    static class FastReader {
	private byte[] buf = new byte[65536];
	private int ind = 0;
	private int maxInd = -1;
	private InputStream is = null;
	private boolean eof = false;
	private boolean lastCharRead = false;

	public FastReader(InputStream is) {
	    this.is = is;
	}

	public String readNextToken(boolean endOfLine) {
	    try {
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		while (true) {
		    if (lastCharRead) {
			return null;
		    } else if (ind > maxInd) {
			if (eof) {
			    lastCharRead = true;
			} else {
			    fillBuffer();
			}
		    }
		    byte b = '\n';
		    if (!lastCharRead) {
			b = buf[ind++];
		    }

		    if (b == '\r') {
			// ignore
		    } else if ((b == '\n' && endOfLine) || (Character.isWhitespace(b) && !endOfLine)) {
			if (found) {
			    break;
			}
		    } else {
			sb.append((char) b);
			found = true;
		    }
		}
		return sb.toString();
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}

	private void fillBuffer() {
	    try {
		int read = is.read(buf, 0, buf.length);
		if (read < buf.length) {
		    eof = true;
		}
		ind = 0;
		maxInd = read - 1;
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}
    }

    public static class LST {
	public long[][] set;
	public int n;

	public LST(int n) {
	    this.n = n;
	    int d = 1;
	    for (int m = n; m > 1; m >>>= 6, d++)
		;

	    set = new long[d][];
	    for (int i = 0, m = n >>> 6; i < d; i++, m >>>= 6) {
		set[i] = new long[m + 1];
	    }
	}

	// [0,r)
	public LST setRange(int r) {
	    for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
		for (int j = 0; j < r >>> 6; j++) {
		    set[i][j] = -1L;
		}
		if ((r & 63) != 0)
		    set[i][r >>> 6] |= (1L << r) - 1;
	    }
	    return this;
	}

	// [0,r)
	public LST unsetRange(int r) {
	    if (r >= 0) {
		for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
		    for (int j = 0; j < r + 63 >>> 6; j++) {
			set[i][j] = 0;
		    }
		    if ((r & 63) != 0)
			set[i][r >>> 6] &= ~((1L << r) - 1);
		}
	    }
	    return this;
	}

	public LST set(int pos) {
	    if (pos >= 0 && pos < n) {
		for (int i = 0; i < set.length; i++, pos >>>= 6) {
		    set[i][pos >>> 6] |= 1L << pos;
		}
	    }
	    return this;
	}

	public LST unset(int pos) {
	    if (pos >= 0 && pos < n) {
		for (int i = 0; i < set.length && (i == 0 || set[i - 1][pos] == 0L); i++, pos >>>= 6) {
		    set[i][pos >>> 6] &= ~(1L << pos);
		}
	    }
	    return this;
	}

	public boolean get(int pos) {
	    return pos >= 0 && pos < n && set[0][pos >>> 6] << ~pos < 0;
	}

	public LST toggle(int pos) {
	    return get(pos) ? unset(pos) : set(pos);
	}

	public int prev(int pos) {
	    for (int i = 0; i < set.length && pos >= 0; i++, pos >>>= 6, pos--) {
		int pre = prev(set[i][pos >>> 6], pos & 63);
		if (pre != -1) {
		    pos = pos >>> 6 << 6 | pre;
		    while (i > 0)
			pos = pos << 6 | 63 - Long.numberOfLeadingZeros(set[--i][pos]);
		    return pos;
		}
	    }
	    return -1;
	}

	public int next(int pos) {
	    for (int i = 0; i < set.length && pos >>> 6 < set[i].length; i++, pos >>>= 6, pos++) {
		int nex = next(set[i][pos >>> 6], pos & 63);
		if (nex != -1) {
		    pos = pos >>> 6 << 6 | nex;
		    while (i > 0)
			pos = pos << 6 | Long.numberOfTrailingZeros(set[--i][pos]);
		    return pos;
		}
	    }
	    return -1;
	}

	private static int prev(long set, int n) {
	    long h = set << ~n;
	    if (h == 0L)
		return -1;
	    return -Long.numberOfLeadingZeros(h) + n;
	}

	private static int next(long set, int n) {
	    long h = set >>> n;
	    if (h == 0L)
		return -1;
	    return Long.numberOfTrailingZeros(h) + n;
	}

	@Override
	public String toString() {
	    List<Integer> list = new ArrayList<Integer>();
	    for (int pos = next(0); pos != -1; pos = next(pos + 1)) {
		list.add(pos);
	    }
	    return list.toString();
	}
    }
}
