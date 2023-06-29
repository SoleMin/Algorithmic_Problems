import java.util.Scanner;

public class Main {

	static double dot[][] = new double[100][2]; // 주근깨 좌표 저장
	static boolean tree[] = new boolean[100]; // 탐색 위한 노드 저장
	static double dist[] = new double[100]; // 거리 저장
	static int connected[] = new int[100]; // 연결된 최단거리 정점 저장
	static int fc; // 주근깨 개수 저장
	static double result;
	
	public static void main(String[] args) {
		/* 문제 주근깨 */
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		double x, y; //좌표
		
		for(int t=0; t<tc; t++) {
			fc = sc.nextInt();
			for(int f=0; f<fc; f++) {
				x = sc.nextDouble();
				y = sc.nextDouble();
				//노드 삽입
				dot[f][0] = x;
				dot[f][1] = y;
			}
			
			//탐색 연산
			search();
			
			//결과 출력
			System.out.printf("%.2f\n", result);
			System.out.println();
		}
		sc.close();
	}
	
	static double distance(int a, int b) {
		return (Math.sqrt(Math.pow((dot[a][0]-dot[b][0]),2)
						  + Math.pow((dot[a][1]-dot[b][1]), 2)));
	}
	
	static void search() {
		result = 0;
		
		//초기화
		tree[0] = false;
		dist[0] = 0;
		connected[0] = 0;
		for(int i=1; i<fc; i++) {
			tree[i] = false;
			dist[i] = distance(0, i);
			connected[i] = 0;
		}
		
		//prim algorithm
		dist[0] = 0;
		int v = 0;
		double weight, dst = 0;
		while(!tree[v]) {
			tree[v] = true;
			result += dst;
			
			//현재 v에 대해 거리 갱신
			for(int i=0; i<fc; i++) {
				if(v == i) { continue; }
				weight = distance(v, i); //****
				if((dist[i] > weight) && (!tree[i])) {
					dist[i] = weight;
					connected[i] = v;
				}
			}
			
			//다음으로 트리에 삽입할 노드 탐색
			dst = Double.MAX_VALUE;
			for(int i=0; i<fc; i++) {
				if(v == i) { continue; }
				if((!tree[i]) && (dst > dist[i])) {
					dst = dist[i];
					v = i;
				}
			}
		}
	}

}