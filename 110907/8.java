import java.util.*;
class Main {
	
	static Scanner input = new Scanner(System.in);
	static int n, e, ne, start, finish, front, rear;
	static boolean reachable = false;
	static int[][] edges = new int[1000][4], check = new int[100][4];
	static int[] queue = new int[10000];
	static String[] city = new String[100];
	
	public static void main(String[] args) throws Exception {
		int i, t;
		t = input.nextInt();
		for(i = 1; i <= t; i++) {
			inputS();
			bfs();
			
			System.out.printf("Test Case %d.\n", i);
			if(reachable)
				System.out.printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]);
			else
				System.out.print("There is no route Vladimir can take.\n");
		}
	}
	
	static void inputS() {
		int i, t1, t2;
		String name1, name2;
		
		n = ne = 0;
		e = input.nextInt();
		for(i = 0; i < e; i++) {
			name1 = input.next();
			name2 = input.next();
			t1 = input.nextInt();
			t2 = input.nextInt();
			
			t1 %= 24;
			if((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6-t1) || (t1 >= 18 && t2 > 30 - t1))
				continue;
			
			edges[ne][0] = getcity(name1);
			edges[ne][1] = getcity(name2);
			edges[ne][2] = (t1 + 12) % 24;
			edges[ne][3] = t2;
			ne++;
		}
		
		name1 = input.next();
		name2 = input.next();
		start = getcity(name1);
		finish = getcity(name2);
	}
	
	static int getcity(String name) {
		int i;
		for(i = 0; i < n; i++) {
			if(name.equals(city[i]))
				return i;
		}
		
		city[n] = name;
		return n++;
	}
	
	static void bfs() {
		int i;
		int[] now = new int[3];
		front = 0;
		rear = 0;
		reachable = false;
		
		for(i = 0; i < n; i++)
			check[i][0] = 10000;
		
		queue[rear++] = start;
		check[start][0] = 0;
		check[start][1] = 0;
		
		while(front < rear) {
			now[0] = queue[front++];
			now[1] = check[now[0]][0];
			now[2] = check[now[0]][1];
			if(now[0] == finish) {
				reachable = true;
				continue;
			}
			
			for(i = 0; i < ne; i++) {
				if(edges[i][0] != now[0]) continue;
				if(now[2] <= edges[i][2] && 
						(check[edges[i][1]][0] > now[1] || 
						(check[edges[i][1]][0] == now[1] && 
						check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1];
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
				else if(check[edges[i][1]][0] > now[1] + 1 || 
						(check[edges[i][1]][0] > now[1] || 
						(check[edges[i][1]][0] == now[1] && 
						check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1] + 1;
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
			}
		}
	}
		
		
}