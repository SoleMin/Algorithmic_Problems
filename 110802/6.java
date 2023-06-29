import java.util.*;
class Main {
	
	static Scanner input = new Scanner(System.in);
	static int MAXDEPTH, mtop;
	static int[][] move = { {-1,0}, {0,1}, {1,0}, {0,-1} };
	static char[] movechar = {'U', 'R', 'D', 'L'};
	static boolean solved = false;
	static int[][] puzzle = new int[4][4];
	static int[] movestack = new int[50];
	
	public static void main(String[] args) throws Exception {
		int cases, i;
		
		cases = input.nextInt();
		for(i = 0; i < cases; i++) {
			input();
			mtop = 0;
			solved = false;
			solve();
			
			output();
		}
	}
	
	static void input() {
		int i, j;
		for(i = 0; i < 4; i++)
			for(j = 0; j < 4; j++)
				puzzle[i][j] = input.nextInt();
	}
	
	static void output() {
		int i;
		if(solved) {
			for(i = 0; i < mtop; i++)
				System.out.print(movechar[movestack[i]]);
			System.out.println();
		}
		else
			System.out.print("This puzzle is not solvable.\n");
	}
	
	static int cost() {
		int i, j, mid1, mid2;
		
		mid1 = 0;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4; j++) {
				if(puzzle[i][j] != 0)
					mid1 += Math.abs(i - ((puzzle[i][j] -1)/4));
			}
		}
		
		mid2 = 0;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4; j++) {
				if(puzzle[i][j] != 0)
					mid2 += Math.abs(j - ((puzzle[i][j] -1)%4));
			}
		}
		return mid1+mid2;
	}
	
	static void solve() {
		int i, j, k, l, value, x = 0, y = 0;
		value = 0;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4; j++) {
				if(puzzle[i][j] == 0) {
					value += i;
					x = i;
					y = j;
				}
				for(k = i; k < 4; k++) {
					if(k == i)
						l = j + 1;
					else
						l = 0;
					for(; l < 4; l++) {
						if(puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
							value++;
					}

				}
			}
		}
		if(value % 2 == 0)
			return;
		
		for(MAXDEPTH = cost(); !solved && MAXDEPTH <= 50; MAXDEPTH += 2){
			back(0, x, y);
		}
	}
	
	static void back(int a, int nowx, int nowy) {
		int i, c;
		int nextx, nexty;
		
		c = cost();
		if(c == 0) {
			solved = true;
			return;
		}
		if(a + c > MAXDEPTH) return;
		
		for(i = 0; i < 4; i++) {
			if(mtop > 0 && (movestack[mtop-1] + 2)%4 == i) 
				continue;
			
			nextx = nowx + move[i][0];
			nexty = nowy + move[i][1];
			if(nextx < 0 || nextx > 3 || nexty < 0 || nexty > 3) 
				continue;
			int temp = puzzle[nowx][nowy];
			puzzle[nowx][nowy] = puzzle[nextx][nexty];
			puzzle[nextx][nexty] = temp;
			movestack[mtop++] = i;
			
			back(a+1, nextx, nexty);
			if(solved) return;
			mtop--;
			puzzle[nextx][nexty] = puzzle[nowx][nowy];
			puzzle[nowx][nowy] = temp;
		}
	}
}