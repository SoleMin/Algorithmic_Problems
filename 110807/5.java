import java.util.Scanner;

public class Main {

	static int MAXDEPTH =16;
	static int[][] remainto= {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
			{1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
			{0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
			{1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
			{0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
			{1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
			{0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
			{1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
			{0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
			{1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
			{0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1} };
	static int[] finalstate = { 0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 };
	static int[] state, point, count, stack, result;
	static int rn, solveable;

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		int n=input.nextInt();
		for(int i=0; i<n; i++) {
			state=new int[24];
			point=new int[2];
			count=new int[2];
			stack=new int[MAXDEPTH];
			result=new int[MAXDEPTH];

			for(int j=0; j<24; j++) {
				state[j]=input.nextInt();
			}

			count[0]=count[1]=0;
			point[0]=0;
			point[1]=12;
			rn=MAXDEPTH+1;
			solveable=0;
			back(0);

			if(solveable!=0) {
				if(rn==0)
					System.out.println("PUZZLE ALREADY SOLVED");
				else {
					for(int j=0; j<rn; j++) 
						System.out.print(result[j]);
					System.out.println();
				}
			}
			else {
				System.out.println("NO SOLUTION WAS FOUND IN "+MAXDEPTH+" STEPS");
			}
		}

		input.close();
	}

	public static void back(int a) {
		int temp1, temp2, issame, minmove;

		if (a == rn)
			return;

		issame = 1;
		for (int i = 0; i < 12 && issame!=0; i++)
			if (state[left(point[0], i)] != finalstate[i])
				issame = 0;
		for (int i = 0; i < 12 && issame!=0; i++)
			if (state[left(point[1], i)] != finalstate[i + 12])
				issame = 0;
		if (issame!=0) {
			for (int i = 0; i < a; i++) {
				result[i] = stack[i];
			}
			rn = a;
			solveable = 1;
			return;
		}

		minmove = 0;
		for (int i = 0; i < 21; i++)
		{
			temp1 = state[left(point[i / 12], i % 12)];
			if (minmove < remainto[i / 2][temp1])
				minmove = remainto[i / 2][temp1];
		}


		if (a == MAXDEPTH || a + minmove > MAXDEPTH || a + minmove >= rn)
			return;
		for (int i = 1; i <= 4; i++) {
			if (a >= rn - 1)
				break;
			stack[a] = i;
			int n=0;
			if(i==1)
				n=0;
			else if (i==2)
				n=1;
			else if (i==3)
				n=0;
			else if (i==4)
				n=1;

			if(i==1 || i==4) {
				if (count[n] > 0 || count[n] == -5) 
					continue;

				point[n] = right(point[n], 2);
				for (int j = 1; j <= 3; j++)
					state[right(point[1-n], j)] = state[right(point[n], j)];

				temp1 = count[0];
				temp2 = count[1];
				count[n]--;
				count[1-n] = 0;

				back(a + 1);

				count[0] = temp1;
				count[1] = temp2;

				point[n] = left(point[n], 2);
				for (int j = 1; j <= 3; j++)
					state[right(point[1-n], j)] = state[right(point[n], j)];
			}
			else {
				if (count[n] < 0 || count[n] == 5) 
					continue;

				point[n] = left(point[n], 2);
				for (int j = 1; j <= 3; j++)
					state[right(point[1-n], j)] = state[right(point[n], j)];

				temp1 = count[0];
				temp2 = count[1];
				count[n]++;
				count[1-n] = 0;

				back(a + 1);

				count[0] = temp1;
				count[1] = temp2;

				point[n] = right(point[n], 2);
				for (int j = 1; j <= 3; j++)
					state[right(point[1-n], j)] = state[right(point[n], j)];
			}

		}
	}

	public static int left(int base, int offset) {
		if (base < 12) {
			base += offset;
			if (base >= 12)
				base -= 12;
		}
		else {
			base += offset;
			if (base >= 24)
				base -= 12;
		}
		return base;
	}

	public static int right(int base, int offset) {
		if (base < 12) {
			base -= offset;
			if (base < 0)
				base += 12;
		}
		else {
			base -= offset;
			if (base < 12)
				base += 12;
		}
		return base;
	}
}
