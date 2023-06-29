import java.util.Scanner;

public class Main {

	static int puzzle[][] = new int[4][4];
	static int move[][] = { {0,-1}, {1,0}, {0,1}, {-1,0} };
	static char moveC[] = { 'U', 'R', 'D', 'L' };
	static int solution[] = new int[51];
	static boolean solve;
	static int MAXD, stop;
	
	public static void main(String[] args) {
		/* 문제 15-퍼즐 */
		Scanner sc = new Scanner(System.in);
		
		int n; //퍼즐 수
		
		n = sc.nextInt();
		for(int t=0; t<n; t++) {
			for(int i=0; i<4; i++)
				for(int j=0; j<4; j++)
					puzzle[i][j] = sc.nextInt();
			
			solve = false;
			stop = 0;
			inversion();
			
			if(solve) {
				for(int i=0; i<stop; i++)
					System.out.print(moveC[solution[i]]);
				System.out.println();
			} else
				System.out.println("This puzzle is not solvable.");
		}
		sc.close();
	}
	
	//heuristic function - manhattan distance 총합 구함
	// = 0일 때 퍼즐 해결
	static int manhattan(int[][] p) {
		int m1, m2; //m1 열 m2 행
		
		m1 = 0; m2 = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(p[i][j] != 0) {
					m1 += Math.abs(i - ((p[i][j] - 1) / 4));
					m2 += Math.abs(j - ((p[i][j] - 1) % 4));
				}
		
		return m1 + m2;
	}
	
	//전도수 계산 - 문제 풀이 가능 여부 확인
	static void inversion() {
		int cnt = 0;
		int row = 0, x = 0, y = 0;
		
		find: for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(puzzle[i][j] == 0) { 
					row = i; x = j; y = i;
					break find;
				}
		
		int tmp = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int m=i; m<4; m++) {
					if(m==i) { tmp = j + 1; } //시작 줄일때 다음 순서부터
					else { tmp = 0; }
					for(int n=tmp; n<4; n++) {
						if(puzzle[m][n]!=0 && (puzzle[i][j] > puzzle[m][n]))
							cnt++;
					}
				}
			}
		}
		
		//짝수 행=홀수 / 홀수 행=짝수 여야 가능함
		if( (row+cnt) % 2 == 0 )
			return;
		
		for(MAXD = manhattan(puzzle); !solve&&MAXD<=50; MAXD+=2)
			puzz(0, x, y);
	}
	
	static void puzz(int a, int tx, int ty) {
		int nx=0, ny=0; //이동할 위치
		int i, c;
		
		c = manhattan(puzzle);
		if(c == 0) { solve = true; return; }
		if(c+a > MAXD) { return; }
		
		//이동시 이득이 최대가 되는 방향으로 이동
		for(i=0; i<4; i++) {
			//이전 위치 복귀시 다음 방향 수행
			if(stop > 0)
				if((solution[stop-1]+2)%4 == i)
					continue;
			
			nx = tx + move[i][0];
			ny = ty + move[i][1];
			
			if(nx<0 || nx>3 || ny<0 || ny>3) { continue; }
			
			puzzle[ty][tx] = puzzle[ny][nx];
			puzzle[ny][nx] = 0;
			
			solution[stop++] = i;
			puzz(a+1, nx, ny);
			if(solve) return;
			stop--;
			
			puzzle[ny][nx] = puzzle[ty][tx];
			puzzle[ty][tx] = 0;
		}
	}

}