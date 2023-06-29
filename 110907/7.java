import java.util.Scanner;

public class Main {

	static String name1, name2;
	static int n, e, ne, start, finish, reachable, front, rear;
	static String[] city= new String[100];
	static int[][] edges= new int[1000][4];
	static int[][] check=new int[100][2];
	static int[] queue=new int[10000];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t=input.nextInt();

		for(int i=1; i<=t; i++) {
			n =0;
			ne = 0;
			int e=input.nextInt();
			for (int j = 0; j < e; j++) {
				name1=input.next();
				name2=input.next();
				int t1=input.nextInt();
				int t2=input.nextInt();

				t1%=24; // 24시를 0시로 변경
				if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
					continue;
				}

				// 정오를 0시로 치환하여 저장한다.
				edges[ne][0] = getcity(name1); // 출발 도시 번호
				edges[ne][1] = getcity(name2); // 도착 도시 번호
				edges[ne][2] = (t1 + 12) % 24; // 출발 시각
				edges[ne][3] = t2; // 여행 시간
				ne++;
			}
			name1=input.next();
			name2=input.next();
			start = getcity(name1); // 출발지 도시 번호
			finish = getcity(name2); // 도착지 도시 번호


			bfs();
			System.out.printf("Test Case %d.\n", i);
			if (reachable!=0)
				System.out.printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]);
			else
				System.out.println("There is no route Vladimir can take.");
		}

		input.close();
	}

	public static int getcity(String name) {
		for (int i = 0; i < n; i++) {
			if (name.equals(city[i]))
				return i;
		}
		city[n]= name;
		return n++;
	}

	public static void bfs() {
		int[] now=new int[3];
		front = 0;
		rear = 0;
		reachable = 0;
		for (int i = 0; i < n; i++)
			check[i][0] = 10000; // 큰 수로 초기화 (최소값을 찾기 위함)
		queue[rear++] = start;
		check[start][0] = 0; // 필요한 혈액량(여행 날짜)
		check[start][1] = 0;
		while (front < rear) {
			now[0] = queue[front++]; // 현재 도시 번호
			now[1] = check[now[0]][0]; // 현재까지 필요 혈액량(리터)
			now[2] = check[now[0]][1]; // 다음 도시에서의 도착 시각
			if (now[0] == finish){
				reachable = 1;
				continue;
			}

			for (int i = 0; i < ne; i++) {
				if (edges[i][0] != now[0]) continue; // 출발 도시 불일치

				if (now[2] <= edges[i][2] && // 출발 시각 확인
						(check[edges[i][1]][0] > now[1] || // 누적 날짜 확인
								(check[edges[i][1]][0] == now[1] &&
								check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) { // 도착 시각 확인
					queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
					check[edges[i][1]][0] = now[1];
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}


				else if(check[edges[i][1]][0] > now[1]+1 || check[edges[i][1]][0] == now[1]+1 ) {
					queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
					check[edges[i][1]][0] = now[1]+1;
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
			}
		}
	}
}