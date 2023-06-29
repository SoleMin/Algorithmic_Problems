import java.util.*;

class Main {
	static int zeroindex, depth, mtop;
	static int[] movestack = new int[50];
	static int[][] puzzle = new int[4][4];
	static char[] movechar = {'L', 'D', 'R', 'U'};
	static boolean solved;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = Integer.parseInt(input.nextLine());
		for(int n=0; n<testcase; n++) {
			int x = 0, y = 0;
			for(int i=0; i<4; i++) {
				String[] arr = input.nextLine().split(" ");
				for(int j=0; j<4; j++) {
					puzzle[i][j] = Integer.parseInt(arr[j]);
					if(puzzle[i][j] == 0) {
						x = i;
						y = j;
					}
				}
			}
			
			mtop = 0;
			solved = false;
			if(!isSolvable(x))
				System.out.println("This puzzle is not solvable.");
			else {
				for(depth = cost(); !solved && depth <= 50; depth+=2)
					back(0, x, y);
				
				if(solved) {
					for (int i=0; i<mtop; i++)
						System.out.print(movechar[movestack[i]]);
					System.out.println();
				}
				else
					System.out.println("This puzzle is not solvable.");
			}
		}
	}
	
	static void back(int a, int x, int y) {
		int c = cost(), nx = 0, ny = 0;
		if(c == 0) {
			solved = true;
			return;
		}
		if(a+c > depth) return;
		
		for(int i=0; i<4; i++) {
			if(mtop > 0 && (movestack[mtop-1] + 2) % 4 == i)
				continue;
			
			if(x == 0 && i == 3) continue;
			if(x == 3 && i == 1) continue;
			if(y == 0 && i == 0) continue;
			if(y == 3 && i == 2) continue;
			
			int dx = -1 * ((i-2) % 2);
			int dy = (i-1) % 2;
			nx = x + dx;
			ny = y + dy;
			
			int temp = puzzle[nx][ny];
			puzzle[nx][ny] = 0;
			puzzle[x][y] = temp;
			
			movestack[mtop++] = i;
			back(a+1, nx, ny);
			if(solved) return;
			
			mtop--;
			temp = puzzle[x][y];
			puzzle[x][y] = 0;
			puzzle[nx][ny] = temp;
		}
	}
	
	static int cost() {
		int md = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(puzzle[i][j] != 0)
					md += Math.abs(i - ((puzzle[i][j]-1) / 4)) + Math.abs(j - ((puzzle[i][j]-1) % 4));
		return md;
	}
	
	static boolean isSolvable(int x) {
		int icount = 0;
		for(int i=0; i<16; i++) {
			int row = i/4, column = i%4;
			int cell = puzzle[row][column];
			for(int j=i+1; j<16; j++) {
				row = j/4;
				column = j%4;
				if(puzzle[row][column] < cell && puzzle[row][column] != 0)
					icount++;
			}
		}
		
		if((icount + x)%2 == 0)
			return false;
		else
			return true;
	}
}