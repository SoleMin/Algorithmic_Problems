import java.io.*;
import java.util.*;

class Main {
	static int MAXN = 100;
	static int MAXE = 1000;
	static int MAXNAME = 32;
	static int MAXQUEUESIZE = 10000;
	
	static int n, e, ne, start, fin, reachable;
	static int [][] edges = new int [MAXE][4];
	static int [][] check = new int [MAXN][2];
	static String [] city = new String[MAXN];
	static int front, rear;
	static int [] queue = new int [MAXQUEUESIZE];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 1; i <= t; i ++) {
			String name1, name2;
			int t1, t2;
			
			n = ne = 0;
			
			e = sc.nextInt();
			
			for (int j = 0; j < e; j ++) {
				name1 = sc.next();
				name2 = sc.next();
				t1 = sc.nextInt();
				t2 = sc.nextInt();
				
				t1 %= 24;
				
				if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
					continue;
				}
				
				edges[ne][0] = getcity(name1);
				edges[ne][1] = getcity(name2);
				edges[ne][2] = (t1 + 12) % 24;
				edges[ne][3] = t2;
				ne ++;
			}
			
			name1 = sc.next();
			name2 = sc.next();
			
			start = getcity(name1);
			fin = getcity(name2);
			bfs();
			
			System.out.println("Test Case " + i + ".");
			if (reachable == 1)
				System.out.println("Vladimir needs " + check[fin][0] + " litre(s) of blood.");
			else
				System.out.println("There is no route Vladimir can take.");
		}
	}
	
	static public void input() {
		Scanner sc = new Scanner(System.in);
		String name1, name2;
		int t1, t2;
		
		n = ne = 0;
		
		e = sc.nextInt();
		
		for (int i = 0; i < e; i ++) {
			name1 = sc.next();
			name2 = sc.next();
			t1 = sc.nextInt();
			t2 = sc.nextInt();
			
			t1 %= 24;
			
			if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
				continue;
			}
			
			edges[ne][0] = getcity(name1);
			edges[ne][1] = getcity(name2);
			edges[ne][2] = (t1 + 12) % 24;
			edges[ne][3] = t2;
			ne ++;
		}
		
		name1 = sc.next();
		name2 = sc.next();
		
		start = getcity(name1);
		fin = getcity(name2);
	}
	
	static int getcity(String name) {
		for (int i = 0; i < n; i ++) {
			if (name.compareTo(city[i]) == 0)
				return i;
		}
		
		city[n] = name;
		return n++;
	}
	
	static void bfs () {
		int [] now = new int [3];
		front = 0;
		rear = 0;
		reachable = 0;
		
		for (int i = 0; i < n; i++) {
			check[i][0] = 10000;
		}
		queue[rear++] = start;
		check[start][0] = 0;
		check[start][1] = 0;
		while (front < rear) {
			now[0] = queue[front++];
			now[1] = check[now[0]][0];
			now[2] = check[now[0]][1];
			if (now[0] == fin) {
				reachable = 1;
				continue;
			}
			for (int i = 0; i < ne; i++) {
				if (edges[i][0] != now[0]) continue;
				if (now[2] <= edges[i][2] &&
					 (check[edges[i][1]][0] > now[1] || 
					 (check[edges[i][1]][0] == now[1] &&
					 check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1];
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
				
				if (check[edges[i][1]][0] > now[2] + 1 || 
					 (check[edges[i][1]][0] == now[2] + 1  &&
					 check[edges[i][1]][1] > edges[i][2] + edges[i][3])) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1] + 1;
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
			}
		}
	}
}