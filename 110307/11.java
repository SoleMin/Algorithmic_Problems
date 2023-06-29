import java.io.*;
import java.util.*;

class Main {
		static final int INF = 25143;
		static TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		static String[] umap = new String[25143];
		static int[] parent, tmp;
		static int N;

	static int find(String s1, String s2) {
		tmp = new int[N];
		parent = new int[N];
		
		Arrays.fill(parent, -1);
		Arrays.fill(tmp, INF);
		
		tmp[map.get(s1)] = 0;
		
		Queue<String> q = new LinkedList<String>();
		q.add(s1);
		
		while(!q.isEmpty()) {
			String cur = q.remove();
			int x = map.get(cur);
			
			if(cur.equals(s2))
				return x;
			
			for (int i = 0; i < cur.length(); i++) {
				StringBuilder sb = new StringBuilder(cur);
				for(int j = 0; j < 26; j++) {
					if(cur.charAt(i) != j + 'a') {
						String next = sb.replace(i, i+1, "" + (char)(j+'a')).toString();
						Integer y = map.get(next);
						
						if(y != null && tmp[y] == INF) {
							tmp[y] = tmp[x] + 1;
							parent[y] = x;
							q.add(next);
						}
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		boolean first = true;
		
		while(!(line = br.readLine()).equals("")) {
			umap[N] = line;
			map.put(line, N++);
		}
		
		while(br.ready()) {
			if(first)
				first = false;
			else
				sb.append("\n");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			if(!map.containsKey(s1) || !map.containsKey(s2)) {
				sb.append("No solution.\n");
				continue;
			}
			
			int index = find(s1, s2);
			
			if(index == -1)
				sb.append("No solution.\n");
			else {
				Stack<String> stk = new Stack<String>();
				
				while(index != -1) {
					stk.push(umap[index]);
					index = parent[index];
				}
				
				while(!stk.isEmpty())
					sb.append(stk.pop()).append("\n");
			}
		}
		System.out.print(sb);
	}
}