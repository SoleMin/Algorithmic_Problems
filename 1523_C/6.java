import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import java.lang.*;

public class Practice {
	public static long mod = (long) Math.pow(10, 9) + 7;
	public static long tt = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int c = 1;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			// map.put(1, 0);
			int curr = 0;
			for (int i = 0; i < n; i++) {
				int tt = Integer.parseInt(br.readLine());
				if (tt == 1) {
					curr++;
					map.put(curr, 1);
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
					Collections.sort(list);
					for (int a = list.size() - 1; a >= 0; a--) {
						if (map.get(list.get(a)) == tt - 1) {
							map.put(list.get(a), tt);
							break;
						} else {
							curr--;
							map.remove(list.get(a));
						}
					}
				}
				ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
				Collections.sort(list);
				StringBuilder str=new StringBuilder();
				for(int a=0;a<list.size();a++) {
					if(list.size()-1==a) {
						str.append(map.get(list.get(a)));
						continue;
					}
					str.append(map.get(list.get(a))+".");
				}pw.println(str);

			}

		}
		pw.close();
	}

//	private static long getGCD(long l, long m) {
//		// TODO Auto-generated method stub
//
//		long t1 = Math.min(l, m);
//		long t2 = Math.max(l, m);
//		while (true) {
//			long temp = t2 % t1;
//			if (temp == 0) {
//				return t1;
//			}
//			t2 = t1;
//			t1 = temp;
//		}
//	}
}
