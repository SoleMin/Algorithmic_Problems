import java.io.*;
import java.util.*;

class Main {
	static class Tuple implements Comparable<Tuple> {
		String name, time;
		boolean enter;
		int pos;
		
		Tuple(String name, String time, boolean enter, int pos) {
			this.name = name;
			this.time = time;
			this.enter = enter;
			this.pos = pos;
		}
		
		public int compareTo(Tuple t) {
			return time.compareTo(t.time);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[24];
			for (int i = 0; i < 24; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			List<Tuple> list = new ArrayList<>();
			while (true) {
				String line = br.readLine();
				if (line == null || line.length() == 0) {
					break;
				}
				st = new StringTokenizer(line);
				String name = st.nextToken();
				String time = st.nextToken();
				boolean enter = st.nextToken().equals("enter");
				int pos = Integer.parseInt(st.nextToken());
				list.add(new Tuple(name, time, enter, pos));
			}
			Collections.sort(list);
			TreeMap<String, Tuple> map1 = new TreeMap<>();
			TreeMap<String, Integer> map2 = new TreeMap<>();
			for (Tuple t : list) {
				map2.put(t.name, 200);
			}
			for (Tuple t : list) {
				if (t.enter) {
					map1.put(t.name, t);
					continue;
				}
				Tuple u = map1.remove(t.name);
				if (u == null) {
					continue;
				}
				int price = A[Integer.parseInt(u.time.substring(6, 8))] * Math.abs(u.pos - t.pos) + 100;
				map2.put(t.name, map2.get(t.name) + price);
			}
			for (Map.Entry<String, Integer> entry : map2.entrySet()) {
				String key = entry.getKey();
				int val = entry.getValue();
				if (val == 200) {
					continue;
				}
				out.append(String.format("%s $%d.%02d\n", key, val / 100, val % 100));
			}
			out.append('\n');
		}
		out.deleteCharAt(out.length() - 1);
		
		System.out.print(out);
		
		br.close();
	}
}