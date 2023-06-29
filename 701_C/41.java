import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
	BufferedReader in =
	    new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(in.readLine());
	char[] ps = in.readLine().toCharArray();
	HashMap<Character, TreeSet<Integer>> locs =
	    new HashMap<Character, TreeSet<Integer>>();
	HashSet<Character> poks = new HashSet<Character>();
	int lastNew = n;
	for (int i = 0; i < n; i++) {
	    if (!poks.contains(ps[i])) {
		poks.add(ps[i]);
		locs.put(ps[i], new TreeSet<Integer>());
		lastNew = i;
	    }
	    locs.get(ps[i]).add(i);
	}
	int max = lastNew;
	int minRange = max+1;
	for (int min = 0; min < n; min++) {
	    char pAtMin = ps[min];
	    Integer nextInd = locs.get(pAtMin).higher(min);
	    if (nextInd == null) break;
	    max = Math.max(max, nextInd);
	    minRange = Math.min(minRange, max-min);
	}
	System.out.println(minRange);
    }
}
