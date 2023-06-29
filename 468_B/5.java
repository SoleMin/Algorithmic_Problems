import java.io.IOException;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zyflair Griffane
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputUtil in = new InputUtil(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();

    public void solve(int testNumber, InputUtil in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int[] res = new int[n];
        int[] arr = in.nextIntArray(n);

        IntDeque[] adj = IntDeque.IntDeques(n);
        boolean[] self = new boolean[n];
        boolean[] assigned = new boolean[n];

        for (int i = 0; i < n; i++) {
            left.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            int x = arr[i];

            boolean canA = left.containsKey(a - x);
            boolean canB = left.containsKey(b - x);
            if (!canA && !canB) {
                out.println("NO");
                return;
            }

            if (left.containsKey(a - x)) {
                self[i] |= x == a - x;
                if (x != a - x) {
                    adj[i].add(left.get(a - x));
                }
            }

            if (left.containsKey(b - x)) {
                self[i] |= x == b - x;
                if (x != b - x) {
                    adj[i].add(left.get(b - x));
                }
            }
        }

        if (a == b) {
            out.println("YES");
            out.println(IntArrayUtil.toString(res));
            return;
        }

        for (int iter = 0; iter < 2; iter++) {
            for (int i = 0; i < n; i++) {
                if (!self[i] && !assigned[i] && (iter == 1 || adj[i].size() == 1)) {
                    int u = i;
                    DFS:
                    while (true) {
                        assigned[u] = true;
                        if (self[u] && arr[u] == b - arr[u]) {
                            res[u] = 1;
                            break;
                        }
                        for (int v : adj[u]) {
                            if (!assigned[v]) {
                                assigned[v] = true;
                                if (arr[u] == b - arr[v]) {
                                    res[u] = res[v] = 1;
                                }
                                for (int newU : adj[v]) {
                                    if (!assigned[newU]) {
                                        u = newU;
                                        continue DFS;
                                    }
                                }
                                break DFS;
                            }
                        }
                        out.println("NO");
                        return;
                    }
                }
                else if (iter == 1 && !assigned[i] && adj[i].size() == 0 && arr[i] == b - arr[i]) {
                    res[i] = 1;
                }
            }
        }

        out.println("YES");
        out.println(IntArrayUtil.toString(res));
    }


}

class InputUtil {

    JoltyScanner in;

    public InputUtil(InputStream istream) {
        in = new JoltyScanner(istream);
    }

    public String next() {
        return in.next();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray (int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

}

class IntDeque implements Iterable<Integer> {

    private int capacity;
    private int size = 0;
    private int front = 0;
    private int back = 0;
    private int[] deque;
    public IntDeque() {
        this(16);
    }
    public IntDeque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
    }
    public static IntDeque[] IntDeques(int length) {
        IntDeque[] arr = new IntDeque[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new IntDeque();
        }
        return arr;
    }
    public <T extends Iterable<Integer>>IntDeque(T intList) {
        this(16);
        addAll(intList);
    }
    public IntDeque(int[] intArr) {
        this(16);
        for (int i: intArr) {
            addLast(i);
        }
    }
    public void add(int x) {
        addLast(x);
    }
    public <T extends Iterable<Integer>>void addAll(T intList) {
        for (int i: intList) {
            addLast(i);
        }
    }
    public void addLast(int x) {
        ensureCapacity();
        size++;
        deque[back++] = x;
        if (back == capacity) {
            back = 0;
        }
    }

    public void ensureCapacity() {
        if (size < capacity) {
            return;
        }
        int[] newDeque = new int[capacity << 1];
        for (int i = 0, j = front; i < size; i++, j++) {
            if (j == capacity) {
                j = 0;
            }
            newDeque[i] = deque[j];
        }
        deque = newDeque;
        capacity <<= 1;
        front = 0;
        back = size;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int done = 0;
            int curr = front;
            public boolean hasNext() {
                return done < size;
            }
            public Integer next() {
                Integer res = deque[curr++];
                if (curr == capacity) {
                    curr = 0;
                }
                done++;
                return res;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i: this) {
            res.append(i);
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }
}

class IntArrayUtil {

    public static String toString(int[] arr) {
        return toString(arr, " ");
    }

    public static String toString(int[] arr, String delimiter) {
        StringBuilder res = new StringBuilder();
        for (int i: arr) {
            res.append(i);
            res.append(delimiter);
        }
        res.setLength(res.length() - delimiter.length());
        return res.toString();
    }

}

class JoltyScanner {
    public static final int BUFFER_SIZE = 1 << 16;
	public static final char NULL_CHAR = (char) -1;

	StringBuilder str = new StringBuilder();
	byte[] buffer = new byte[BUFFER_SIZE];
	boolean EOF_FLAG = false;
	int bufferIdx = 0, size = 0;
	char c = NULL_CHAR;
	BufferedInputStream in;

	public JoltyScanner(InputStream in) {
		this.in = new BufferedInputStream(in, BUFFER_SIZE);
	}

	public int nextInt() {
		long x = nextLong();
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
			throw new ArithmeticException("Scanned value overflows integer");
		}
		return (int) x;
	}

	public long nextLong() {
		boolean negative = false;
		if (c == NULL_CHAR) {
			c = nextChar();
		}
		for (; !EOF_FLAG && (c < '0' || c > '9'); c = nextChar()) {
			if (c == '-') {
				negative = true;
			}				
		}
		checkEOF();
		long res = 0;
		for (; c >= '0' && c <= '9'; c = nextChar()) {
			res = (res << 3) + (res << 1) + c - '0';
		}
		return negative ? -res : res;
	}

    public String next() {
		checkEOF();
		if (c == NULL_CHAR) {
			c = nextChar();
		}
		while (Character.isWhitespace(c)) {
			c = nextChar();
			checkEOF();
		}
		str.setLength(0);
		for (; !EOF_FLAG && !Character.isWhitespace(c); c = nextChar()) {
			str.append(c);
		}
		return str.toString();
	}

    public char nextChar() {
		if (EOF_FLAG) {
			return NULL_CHAR;
		}
		while (bufferIdx == size) {
			try {
				size = in.read(buffer);
				if (size == -1) {
					throw new Exception();
				}
			} catch (Exception e) {
				EOF_FLAG = true;
				return NULL_CHAR;
			}
			if (size == -1) {
				size = BUFFER_SIZE;
			}
			bufferIdx = 0;
		}
		return (char) buffer[bufferIdx++];
	}

    public void checkEOF() {
		if (EOF_FLAG) {
			throw new EndOfFileException();
		}
	}

	public class EndOfFileException extends RuntimeException {
	}
}

