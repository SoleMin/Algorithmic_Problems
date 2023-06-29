import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		int sum = 5;
		for (int i = 3;; i++) {
			int x = list.get(i - 1);
			sum += x * i;
			while (x-- > 0) {
				list.add(i);
			}
			if (sum >= 2000000000) {
				break;
			}
		}
		for (int i = 1; i < list.size(); i++) {
			list.set(i, list.get(i - 1) + list.get(i));
		}
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			for (int i = 1; i < list.size(); i++) {
				if (N <= list.get(i)) {
					out.append(i + 1).append('\n');
					break;
				}
			}
		}
		
		System.out.print(out);
		
		br.close();
	}
}