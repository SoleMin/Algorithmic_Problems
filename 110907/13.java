import java.io.*;
import java.util.Scanner;

/**오후 여섯시 ~ 오전 여섯시만 이동 가능 그 외는 불가**/
/**표로 그래프 만드는게 좋을듯**/

class Main {
	
	static boolean reachable;
	static int start, finish;
	static int[][] edges = new int[1000][4];
	static int [][]check = new int [100][2];
	static int front;
	static int [] queue = new int[10000];
	static int num, ne;
	static int n, train;
	static String[] city = new String[100];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		n = Integer.parseInt(input.nextLine());
		for(int i =0; i<n; i++) {
			int train = Integer.parseInt(input.nextLine());
			num = ne = 0;
			for (int j = 0; j < train; j++) {
				String[] s = input.nextLine().split(" ");
				String name1 = s[0];
				String name2 = s[1];
				int time1 = Integer.parseInt(s[2]);
				int time2 = Integer.parseInt(s[3]);
				
				time1 %= 24; 
				if ((time1 >= 6 && time1 < 18) || (time1 < 6 && time2 > 6 - time1) || (time1 >= 18 && time2 > 30 - time1)) {
				continue;
				}
				
				edges[ne][0] = getcity(name1); // 출발 도시 번호
				edges[ne][1] = getcity(name2); // 도착 도시 번호
				edges[ne][2] = (time1 + 12) % 24; // 출발 시각
				edges[ne][3] = time2; // 여행 시간
				ne++;
			}
			
			String[] s2 = input.nextLine().split(" ");
			start = getcity(s2[0]); 
			finish = getcity(s2[1]);
			
			bfs();
		
			System.out.println("Test Case " + (i+1) + ".");
			if (reachable)
				System.out.println("Vladimir needs " + check[finish][0] + " litre(s) of blood.");
			else
				System.out.println("There is no route Vladimir can take.");
		}
	}
	
	
	public static int getcity(String name)
	{
		for (int i = 0; i < num; i++) {
			if (name.equals(city[i]))
				return i;
		}
			city[num] = name;
			return num++;
	}
	
	
	public static void bfs() {
	reachable = false;
	int[] now = new int[3];
	front = 0;
	int rear = 0;
	/**reachable = 0;**/
	for (int i = 0; i < num; i++)
		check[i][0] = 10000; // 큰 수로 초기화 (최소값을 찾기 위함)
	queue[rear++] = start;
	check[start][0] = 0; // 필요한 혈액량(여행 날짜)
	check[start][1] = 0;
	while (front < rear) {
		now[0] = queue[front++]; // 현재 도시 번호
		now[1] = check[now[0]][0]; // 현재까지 필요 혈액량(리터)
		now[2] = check[now[0]][1]; // 다음 도시에서의 도착 시각
		if (now[0] == finish){
			reachable = true;
			continue;
		}
		for (int i = 0; i < ne; i++) {
			if (edges[i][0] != now[0])  {
				continue; // 출발 도시 불일치
			}
			if (now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) { // 도착 시각 확인
				queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
				check[edges[i][1]][0] = now[1];
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}
		/**(만약 하루 후에 출발해야 한다면)**/
			else if((check[edges[i][1]][0] >= now[1] +1) || (check[edges[i][1]][0] == now[1]+1 && check[edges[i][1]][1] > edges[i][2] + edges[i][3])){
				queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
				check[edges[i][1]][0] = now[1] + 1;
				check[edges[i][1]][1] = edges[i][2] + edges[i][3] + 12;
			}
		}
	}
}
	
}