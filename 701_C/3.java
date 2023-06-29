import java.io.*;
import java.util.*;

/*
 * And now I wonder if I should delete these comments cause they might throw me off. 
 * Lol who cares though?
 */

public class R364C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner s = new Scanner(System.in);
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		char[] a = f.readLine().toCharArray();
		int difTypes = 0;
		TreeSet<Character> types = new TreeSet<Character>();
		for(int i = 0; i < n; i++) {
			if(!types.contains(a[i])) {
				types.add(a[i]);
			}
		}
		int i = 0, j = 0;
		difTypes = types.size();
		int curTypes = 0;
		int min = Integer.MAX_VALUE;
		TreeSet<Character> has = new TreeSet<Character>();
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		while(i < n && j < n) {
//			System.out.println(i + " " + j);
			has.add(a[j]);
			if(!freq.containsKey(a[j])) {
				freq.put(a[j], 1);
			} else {
				freq.put(a[j], freq.get(a[j])+1);
			}
			j++;
			curTypes = has.size();
			if(curTypes == difTypes) min = Math.min(min, j-i);
//			System.out.println(freq.toString());
//			System.out.println(curTypes);
//			System.out.println();
			while(i < n && has.size() == difTypes) {
				int Freq = freq.get(a[i]);
//				System.out.println(Freq);
				if(Freq - 1 == 0) {
					has.remove(a[i]);
					freq.put(a[i], freq.get(a[i])-1);
					i++;
					break;
				}
				freq.put(a[i], freq.get(a[i])-1);
				i++;
				if(curTypes == difTypes) min = Math.min(min, j-i);
			}
			curTypes = has.size();
		}
//		if(curTypes == difTypes) min = Math.min(min, j-i);
		System.out.println(min);
	}
}