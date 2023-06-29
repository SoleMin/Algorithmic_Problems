import java.io.*;
import java.util.Scanner;

class Main {
	static int max = 50;
	static int MAXDEPTH, mtop;
	static int[][] array = new int[4][4];
	static int move[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static char direction[] = {'U', 'R', 'D', 'L'};
	static int[] stack = new int[max];
	static boolean solved;

	public static void solve() {
		int value = 0, x=0, y=0, l;

		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (array[i][j]==0 && (i+j)%2==1)
					value++;
				if (array[i][j]==0) {
					x = i;
					y = j;
				}
				
				for (int k=i; k<4; k++) {
					if (k==i)
						l = j+1;
					else
						l = 0;
					for (; l<4; l++) {
						if (array[i][j] == 0 || (array[k][l] != 0 && array[i][j]>array[k][l]))
							value++;
					}
				}
			}
		}
		if (value%2==1)
			return;

		for (MAXDEPTH=cost(); !solved && MAXDEPTH <= max; MAXDEPTH +=2)
			back(0, x, y);
	}

	public static int cost() {
		int md1=0, md2=0;
		int one[] = new int[16];
		int conv[] = {0, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12};
		int cnvp[] = {0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};

		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (array[i][j] != 0)
					md1 += Math.abs(i-((array[i][j]-1)/4));
			}
		}

		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (array[i][j] != 0)
					md2 += Math.abs(j-((array[i][j]-1)%4));
			}
		}

		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				one[i*4+j] = array[i][j];
			}
		}

		int inv1 = 0;
		for (int i=0; i<16; i++) {
			if (one[i]==0)
				continue;
			for (int j=i+1; j<16; j++) {
				if (one[j]==1 && one[j]<one[i])
					inv1++;
			}
		}

		int inv2 = 0;
		for (int i=0; i<16; i++) {
			if (conv[one[cnvp[i]]]!=1)
				continue;
			for (int j= i+1; j< 16; j++) {
				if (conv[one[cnvp[j]]]==1 && conv[one[cnvp[j]]] < conv[one[cnvp[i]]])
					inv2++;
			}
		}

		int id1 = (inv1/3)+(inv1%3);
		int id2 = (inv2/3)+(inv2%3);

		int lowb1 = (id1>md1)? id1:md1;
		int lowb2 = (id2>md2)? id2:md2;

		return lowb1+lowb2;
	}

	public static void back(int a, int x, int y) {
		int nextx, nexty;

		int c = cost();
		if (c==0) {
			solved = true;
			return;
		}
		if (a+c>MAXDEPTH)
			return;

		for (int i=0; i<4; i++) {
			if (mtop > 0 && (stack[mtop-1]+2)%4==i)
				continue;

			nextx = x+move[i][0];
			nexty = y+move[i][1];

			if (nextx < 0 || nextx >= 4 || nexty < 0 || nexty >= 4)
				continue;

			array[x][y] = array[nextx][nexty];
			array[nextx][nexty] = 0;

			stack[mtop++] = i;
			back(a+1, nextx, nexty);
			if (solved)
				return;
			mtop--;

			array[nextx][nexty] = array[x][y];
			array[x][y] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int n = Integer.parseInt(input);

		for (int i=0; i<n; i++) {

			for (int j=0; j<4; j++) {
				input = scanner.nextLine();
				String[] numbers = input.split(" ");
				array[j][0] = Integer.parseInt(numbers[0]);
				array[j][1] = Integer.parseInt(numbers[1]);
				array[j][2] = Integer.parseInt(numbers[2]);
				array[j][3] = Integer.parseInt(numbers[3]);
			}

			mtop = 0;
			solved = false;
			solve();

			if (solved) {
				for (int j=0; j<mtop; j++)
					System.out.print(direction[stack[j]]);
				System.out.println();
			}
			else {
				System.out.println("This puzzle is not solvable.");
			}
		}
		scanner.close();
	}
}