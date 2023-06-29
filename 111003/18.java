import java.util.Scanner;

public class Main {
	
	static int station, inter; // 소방서 수, 교차로 수
	static int fire[] = new int[101]; // 소방서 위치
	static int road[][] = new int[501][501]; // 교차로 저장
	
	public static void main(String[] args) {
		/* 문제 소방서 */
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int a, b, x;
		
		for(int t=0; t<tc; t++) {
			station = sc.nextInt();
			inter = sc.nextInt();
			for(int i=0; i<station; i++)
				fire[i] = sc.nextInt();
			
			for(int i=1; i<=inter; i++) {			//거리 초기화
				for(int j=1; j<=inter; j++) 
					road[i][j] = 99999999;
				road[i][i] = 0;
			}
			
			for(int i=1; i<=inter; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				x = sc.nextInt();
				road[a][b] = x; road[b][a] = x;
			}
			
			//floyd algorithm으로 최단거리 갱신
			floyd(inter);
			
			//가장 먼 최단거리 찾기
			int sl[] = new int[501]; // shortest length
			int msl = 0; // max shortest length
			for(int i=1; i<=inter; i++) {
				sl[i] = 99999999;
				for(int j=0; j<station; j++)
					sl[i] = Math.min(sl[i], road[i][fire[j]]);
				msl = Math.max(msl, sl[i]);
			}
			
			//소방서 세울 위치 찾기
			//소방서가 없는 모든 교자로에 새 소방서가 만들어졌다 가정
			//가장 먼 교차로까지의 거리 계산 후 이 거리가 가장 짧은 교차로 번호
			int here = 1, now = 0; // 위치, msl 저장
			int tsl[] = new int[501]; // temp shortest length
			for(int i=1; i<=inter; i++) {
				now = 0;
				//교차로별 sl 갱신
				for(int j=1; j<=inter; j++) {
					tsl[j] = Math.min(sl[j], road[j][i]);
					now = Math.max(tsl[j], now);
				}
				//msl > now 면 msl, here 갱신
				if(msl > now) {
					msl = now;
					here = i;
				}
			}
			
			//결과 출력
			System.out.println(here);
			if(t != tc-1)
				System.out.println();
		}
		sc.close();
	}
	
	static void floyd(int n) {
		for(int k=1; k<=n; k++)
			for(int i=1; i<=n; i++)
				for(int j=1; j<=n; j++)
					if(road[i][k] + road[k][j] < road[i][j])
						road[i][j] = road[i][k] + road[k][j];
	}

}