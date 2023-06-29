import java.util.Scanner;

public class Main {

	static int[] vcolor = new int[200];
	static boolean[][] edge = new boolean[200][200];
	static int n = 0, l = 0; // 정점, 모서리 수
	static boolean colorable = false;
	
	public static void main(String[] args) {
		/* 문제65 두 색으로 칠하기 */
		Scanner sc = new Scanner(System.in);
		
		int x, y; //좌표
		
		while(sc.hasNextLine()) {
			n = sc.nextInt();
			if(n == 0) { break; }
			l = sc.nextInt();
			
			// 정점, 엣지 초기화
			for(int i=0; i<n; i++)
				vcolor[i] = -1;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					edge[i][j] = false;
			
			// 엣지 입력
			for(int i=0; i<l; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				edge[x][y] = true;
				edge[y][x] = true;
			}
			
			colorable = true;
			coloring(0,1);
			if(colorable)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
		
		sc.close();
	}
	
	static void coloring(int i, int c) {
		int color;
		
		vcolor[i] = c;
		for(int cnt=0; cnt<n && colorable; cnt++) {
			if(!edge[i][cnt]) { continue; } // 연결 정점만 탐색
			
			if(vcolor[cnt] == -1) //탐색하려는 정점 색상이 아직 미정일 때
				coloring(cnt, (c%2 + 1));
			else {
				if(vcolor[cnt] == c) { // 연결 정점이 같은 색일때
					colorable = false;
					return;
				}
			}
		}
	}
}