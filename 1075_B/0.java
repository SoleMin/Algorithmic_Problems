import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int[] data = parseInts(in.readLine().split(" "));
	int n = data[0];
	int m = data[1];
	List<Integer> riders = new ArrayList<>(n);
	NavigableMap<Integer, Integer> drivers = new TreeMap<>();	
	{
	    int[] xs = parseInts(in.readLine().split(" "));
	    int[] ts = parseInts(in.readLine().split(" "));
	    for (int i = 0; i < ts.length; i++) {
		if (ts[i] == 1) {
		    drivers.put(xs[i], 0);
		} else {
		    riders.add(xs[i]);
		}
	    }
	}
	for (int r : riders) {
	    int distLeft = Integer.MAX_VALUE;
	    Integer left = drivers.lowerKey(r);
	    if (left != null) {
		distLeft = r - left;
	    }
	    int distRight = Integer.MAX_VALUE;
	    Integer right = drivers.higherKey(r);
	    if (right != null) {
		distRight = right - r;
	    }
	    if (distLeft <= distRight) {
		drivers.put(left, drivers.get(left) + 1);
	    } else {
		drivers.put(right, drivers.get(right) + 1);
	    }
	}
	PrintWriter out = new PrintWriter(System.out);
	Iterator<Integer> it = drivers.values().iterator();
	out.print(it.next());
	while (it.hasNext()) {
	    out.print(' ');
	    out.print(it.next());
	}
	out.println();
	out.close();
    }

    private static int[] parseInts(String[] numerals) {
	int[] xs = new int[numerals.length];
	for (int i = 0; i < numerals.length; i++) {
	    xs[i] = Integer.parseInt(numerals[i]);
	}
	return xs;
    }
}
