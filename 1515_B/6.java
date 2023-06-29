//package Round14Global;

import java.util.*;
import java.io.*;

public class phoenixandpuzzle {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(fin.readLine());
		StringBuilder fout = new StringBuilder();
		HashSet<Integer> dict = new HashSet<Integer>();
		int pointer = 1;
		int area = 0;
		while(area >= 0) {
			area = (pointer * pointer) * 2;
			dict.add(area);
			pointer ++;
		}
		pointer = 1;
		area = 0;
		while(area >= 0) {
			area = (pointer * pointer) * 4;
			dict.add(area);
			pointer ++;
		}
		while(t-- > 0) {
			int n = Integer.parseInt(fin.readLine());
			if(dict.contains(n)) {
				fout.append("YES\n");
			}
			else {
				fout.append("NO\n");
			}
		}
		System.out.print(fout);
	}
}
