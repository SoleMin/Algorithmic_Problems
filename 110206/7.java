import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {
	static ErdosReader sc = new ErdosReader();
	static HashMap<String, Person> names = new HashMap<>(10000, 1.0f);
	static int t_case = 1;
	static List<String> ln = new ArrayList<>(10000);
	static List<Person> lp = new ArrayList<>(10000);
	
	public static void main(String[] args) throws IOException {
		int cases = sc.nextInt();
		
		for (int i = 0; i < cases; i++)
			testcase();
	}
	
	static void testcase() throws IOException {
		int p, n;
		
		names.clear();
		
		p = sc.nextInt();
		n = sc.nextInt();
		
		for (int i = 0; i < p; i++) {
			lp.clear();
			ln.clear();
			
			String nm;
			LinkedList<String> paper = sc.nextPaper();
			
			while (paper.size() > 1) {
				nm = paper.pollFirst() + ", " + paper.pollFirst();
				Person ps = names.get(nm);
				
				if (ps == null) {
					ps = new Person();
					names.put(nm, ps);
				}
				
				lp.add(ps);
			}
			
			for (Person ps : lp)
				ps.ppl.addAll(lp);
		}
		
		
		//BFS 시작
		//노드의 레벨 = 에르되시 수
		LinkedList<Person> q = new LinkedList<>();
		Person erdos = names.get("Erdos, P.");
	
	
		if (erdos != null) {
			erdos.level = 0;
			q.add(erdos);
		}
	
		int level = 0; // 에르되시 까지의 거리 = 에르되시 수
		int ppl = 0;
	
		while (q.size() > 0) {
			level++;
			ppl = q.size();
		
			Person ps;
			Person nb;
		
			for (int i = 0; i < ppl; i++) {
				ps = q.pollFirst();
				while (ps.ppl.size() > 0) {
					nb = ps.ppl.pollFirst();
				
					if (nb.level < 0) {
						nb.level = level;
						q.addLast(nb);
					}
				}
			}
		}
		
		System.out.println("Scenario " + t_case);
		
		String name;
		Person ps;
		
		for (int i = 0; i < n; i++) {
			name = sc.nextName();
			ps = names.get(name);
			
			if (ps == null || (ps.level < 0)) {
				System.out.println("" + name + " infinity");
			}
			else {
				System.out.println("" + name + " " + ps.level);
			}
		}
		
		t_case++;
	}
}

class Person {
	LinkedList<Person> ppl = new LinkedList<Person>();
	
	int level = -1;
}

class ErdosReader {
	InputStream in = new BufferedInputStream(System.in, 32 * 1024);
	
	public String nextName() throws IOException {
		StringBuilder str = new StringBuilder();
		int chr;
		
		while (true) {
			chr = in.read();
			
			if (chr == '\n') {
				return str.toString().trim();
			}
			
			else {
				str.append((char) chr);
			}
		}
	}
	
	public LinkedList<String> nextPaper() throws IOException {
		LinkedList<String> lst = new LinkedList<String>();
		StringBuilder str = new StringBuilder();
		int chr;
		boolean namesDone = false;
		
		while (true) {
			chr = in.read();
			
			if (chr == '\n') {
				return lst;
			}
			
			else if (!namesDone) {
				if (chr == ':') {
					lst.add(str.toString().trim());
					namesDone = true;
				}
				else if (chr == ',') {
					lst.add(str.toString().trim());
					str.delete(0, str.length());
				}
				else {
					str.append((char) chr);
				}
			}
		}
	}
	
	public int nextInt() throws IOException {
		int num = 0;
		int chr;
		boolean found = false;
		
		while (true) {
			chr = in.read();
			if (chr >= '0' && chr <= '9') {
				num = num * 10 + (chr - '0');
				found = true;
			}
			
			else if (found) {
				return num;
			}
		}
	}
}























