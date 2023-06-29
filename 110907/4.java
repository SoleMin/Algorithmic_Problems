import java.util.*;

class Main {
	static int n, e, ne, start, finish, front, rear;
	static int[] queue = new int[10000];
	static int[][] check = new int[100][2], edges = new int[1000][4];
	static String[] city = new String[100];
	static boolean reachable;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = Integer.parseInt(input.nextLine())+1;
		for(int t=1; t<testcase; t++) {
			int e = Integer.parseInt(input.nextLine());
			
			n = 0;
			ne = 0;
			for(int i=0; i<e; i++) {
				String[] arr = input.nextLine().split(" ");
				String name1 = arr[0];
				String name2 = arr[1];
				int t1 = Integer.parseInt(arr[2]);
				int t2 = Integer.parseInt(arr[3]);
				t1 %= 24;
				if((t1>=6 && t1<18) || (t1<6 && t2 > 6-t1) || (t1>=18 && t2 > 30-t1))
					continue;

				edges[ne][0] = getcity(name1);
				edges[ne][1] = getcity(name2);
				edges[ne][2] = (t1+12) % 24;
				edges[ne][3] = t2;
				ne++;
			}
			
			String[] arr = input.nextLine().split(" ");
			String name1 = arr[0];
			String name2 = arr[1];
			
			start = getcity(name1);
			finish = getcity(name2);
			
			bfs();
			
			System.out.println("Test Case " + t + ".");
			if(reachable)
				System.out.println("Vladimir needs " + check[finish][0] + " litre(s) of blood.");
			else
				System.out.println("There is no route Vladimir can take.");
		}
	}

	private static int getcity(String name) {
		for(int i=0; i<n; i++)
			if(name.equals(city[i]))
				return i;
		city[n] = name;
		return n++;
	}
	
	static void bfs() {
		int[] now = new int[3];
		front = 0;
		rear = 0;
		reachable = false;
		
		for(int i=0; i<n; i++)
			check[i][0] = 10000;
		queue[rear++] = start;
		check[start][0] = 0;
		check[start][1] = 0;
		
		while(front < rear) {
			now[0] = queue[front++];		// 현재 "도시" 번호
			now[1] = check[now[0]][0];		// 필요 누적 "혈액량"
			now[2] = check[now[0]][1];		// 다음 도시 "도착시각"
			if(now[0] == finish){
				reachable = true;
				continue;
			}
			
			/*
			 * edges[i][0]	출발 도시번호
			 * edges[i][1]	도착 도시번호
			 * edges[i][2]	출발 시각 (6 <= edges[i][2] <= 18)
			 * edges[i][3]	여행 시간
			 */
			for(int i=0; i<ne; i++) {
				if(edges[i][0] != now[0]) continue;
				if(now[2] <= edges[i][2] &&
						(check[edges[i][1]][0] > now[1] ||
						(check[edges[i][1]][0] == now[1] &&
						check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1];
					check[edges[i][1]][1] = (edges[i][2] + edges[i][3]);
				}
				
				if(now[2] > edges[i][2] &&
						(check[edges[i][1]][0] > now[1] ||
						(check[edges[i][1]][0] == now[1] &&
						check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) {
					queue[rear++] = edges[i][1];
					check[edges[i][1]][0] = now[1]+1;
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
			}
		}
	}
}