import java.util.*;
class Main {
	
	static int MAXDEPTH = 16;
	static int[][] remainto = {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
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
	static int[] finalstate = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 };
	static int[] state = new int[24], point = new int[2];
	static int[] count = new int[2], stack = new int[MAXDEPTH], result = new int[MAXDEPTH];
	static int rn;
	static boolean solveable;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, i, j;
		
		n = input.nextInt();
		for(i = 0; i < n; i++) {
			
			for(j = 0; j < 24; j++)
				state[j] = input.nextInt();
			
			count[0] = count[1] = 0;
			point[0] = 0;
			point[1] = 12;
			rn = MAXDEPTH + 1;
			solveable = false;
			back(0);
			
			if(solveable) {
				if(rn == 0)
					System.out.print("PUZZLE ALREADY SOLVED\n");
				else {
					for(j = 0; j < rn; j++)
						System.out.print(result[j]);
					System.out.println();
				}
			}
			else {
				System.out.printf("NO SOLUTION WAS FOUND IN %d STEPS\n", MAXDEPTH);
			}
				
		}
	}
	
	static int left(int base, int offset) {
		if(base < 12) {
			base += offset;
			if(base >= 12)
				base -= 12;
		}
		else {
			base += offset;
			if(base >= 24)
				base -= 12;
		}
		return base;
	}
	
	static int right(int base, int offset) {
		if(base < 12) {
			base -= offset;
			if(base < 0)
				base += 12;
		}
		else {
			base -= offset;
			if(base < 12)
				base += 12;
		}
		return base;
	}
	
	static void back(int a) {
		int i, j, temp1, temp2, minmove;
		boolean issame;
		
		if(a == rn)
			return;
		
		issame = true;
		for(i = 0; i < 12 && issame; i++)
			if(state[left(point[0], i)] != finalstate[i])
				issame = false;
		for(i = 0; i < 12 && issame; i++)
			if(state[left(point[1], i)] != finalstate[i+12])
				issame = false;
		
		if(issame) {
			for(i = 0; i < a; i++) 
				result[i] = stack[i];
			rn = a;
			solveable = true;
			return;
		}
		
		minmove = 0;
		for(i = 0; i < 21; i++) {
			temp1 = state[left(point[i/12], i % 12)];
			if(minmove < remainto[i/2][temp1])
				minmove = remainto[i/2][temp1];
		}
		
		if(a == MAXDEPTH || a + minmove > MAXDEPTH || a + minmove >= rn)
			return;
		
		for(i = 1; i <= 4; i++) {
			if(a >= rn -1)
				break;
			stack[a] = i;
			switch(i) {
			case 1: //왼쪽을 시계
				if(count[0] > 0 || count[0] == -5) break; //왼쪽을 시계방향으로 5번 돌린 것인지 판단
				
				point[0] = right(point[0], 2); //왼쪽을 시계방향으로 돌림
				for(j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)]; //중앙을 같게 하기 위함
				
				temp1 = count[0];
				temp2 = count[1];
				count[0]--;
				count[1] = 0;
				
				back(a+1);
				
				count[0] = temp1;
				count[1] = temp2;
				point[0] = left(point[0], 2);
				for(j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				break;
			

			case 2: //오른쪽을 시계
				if(count[1] > 0 || count[1] == -5) break; //오른쪽을 시계방향으로 5번 돌린 것인지 판단
				
				point[1] = left(point[1], 2); //오른쪽을 시계방향으로 돌림
				for(j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]--;
				
				back(a+1);
				
				count[0] = temp1;
				count[1] = temp2;
				point[1] = right(point[1], 2);
				for(j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				break;
				
			case 3: //왼쪽을 반시계
				if(count[0] < 0 || count[0] == 5) break; //왼쪽을 시계방향으로 5번 돌린 것인지 판단
				
				point[0] = left(point[0], 2); //왼쪽을 시계방향으로 돌림
				for(j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)]; //중앙을 같게 하기 위함
				
				temp1 = count[0];
				temp2 = count[1];
				count[0]++;
				count[1] = 0;
				
				back(a+1);
				
				count[0] = temp1;
				count[1] = temp2;
				point[0] = right(point[0], 2);
				for(j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				break;
				
			case 4: //오른쪽을 반시계
				if(count[1] < 0 || count[1] == 5) break; //오른쪽을 시계방향으로 5번 돌린 것인지 판단
				
				point[1] = right(point[1], 2); //오른쪽을 시계방향으로 돌림
				for(j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]++;
				
				back(a+1);
				
				count[0] = temp1;
				count[1] = temp2;
				point[1] = left(point[1], 2);
				for(j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				break;
			}
		}
	}
}