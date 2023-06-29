import java.util.*;

class Main {
	static final int LIMIT = 16;
	static int minMV[][] = {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
							{1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
							{0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
							{1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
							{0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
							{1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
							{0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
							{1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
							{0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
							{1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
							{0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}};
	static int correct[] = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1};
	static int clrhash[] = new int[24], point[] = new int[2], count[] = new int[2];
	static int stack[] = new int[LIMIT], res[] = new int[LIMIT];
	static int num, possible;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t, i, j;
		t = in.nextInt();
		for(i=0; i<t; i++) {
			for(j=0; j<24; j++) {
				clrhash[j] = in.nextInt();
			}
			count[0] = count[1] = 0;
			point[0] = 0; point[1] = 12;
			num = LIMIT+1;
			possible = 0;
			btrack(0);

			if(possible==1) {
				if(num==0) {
					System.out.println("PUZZLE ALREADY SOLVED");
				}
				else {
					for(j=0; j<num; j++) {
						System.out.print(res[j]);
					}
					System.out.println();
				}
			}
			else {
				System.out.println("NO SOLUTION WAS FOUND IN 16 STEPS");
			}
		}
		in.close();
	}

	public static int lefthash(int sp, int offset) {
		if(sp<12) {
			sp += offset;
			if(sp>=12) {
				sp -= 12;
			}
		}
		else {
			sp += offset;
			if(sp>=24) {
				sp -= 12;
			}
		}
		return sp;
	}

	public static int righthash(int sp, int offset) {
		if(sp<12) {
			sp -= offset;
			if(sp<0) {
				sp += 12;
			}
		}
		else {
			sp -= offset;
			if(sp<12) {
				sp += 12;
			}
		}
		return sp;
	}

	public static void btrack(int x) {
		int i, j, temp1, temp2, minmv, issame;

		if(x==num) {
			return;
		}

		issame = 1;
		for(i=0; i<12 && issame==1; i++) {
			if(clrhash[lefthash(point[0], i)]!=correct[i]) {
				issame = 0;
			}
		}
		for(i=0; i<12 && issame==1; i++) {
			if(clrhash[lefthash(point[1], i)]!=correct[i+12]) {
				issame = 0;
			}
		}
		if(issame==1) {
			for(i=0; i<x; i++) {
				res[i] = stack[i];
			}
			num = x;
			possible = 1;
			return;
		}

		minmv = 0;
		for(i=0; i<21; i++) {
			temp1 = clrhash[lefthash(point[i/12], i%12)];
			if(minmv<minMV[i/2][temp1]) {
				minmv = minMV[i/2][temp1];
			}
		}
		if(x==LIMIT || x+minmv>LIMIT || x+minmv>=num) {
			return;
		}
		for(i=1; i<=4; i++) {
			if(x>=(num-1)) {
				break;
			}
			stack[x] = i;
			switch(i) {
			case 1:
				if(count[0]>0 || count[0]==-5) {
					break;
				}
				point[0] = righthash(point[0], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[1], j)] = clrhash[righthash(point[0], j)];
				}
				temp1 = count[0];
				temp2 = count[1];
				count[0]--;
				count[1] = 0;
				btrack(x+1);
				count[0] = temp1;
				count[1] = temp2;
				point[0] = lefthash(point[0], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[1], j)] = clrhash[righthash(point[0], j)];
				}
				break;

			case 2:
				if(count[1]<0 || count[1]==5) {
					break;
				}
				point[1] = lefthash(point[1], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[0], j)] = clrhash[righthash(point[1], j)];
				}
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]++;
				btrack(x+1);
				count[0] = temp1;
				count[1] = temp2;
				point[1] = righthash(point[1], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[0], j)] = clrhash[righthash(point[1], j)];
				}
				break;
				
			case 3:
				if(count[0]<0 || count[0]==5) {
					break;
				}
				point[0] = lefthash(point[0], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[1], j)] = clrhash[righthash(point[0], j)];
				}
				temp1 = count[0];
				temp2 = count[1];
				count[0]++;
				count[1] = 0;
				btrack(x+1);
				count[0] = temp1;
				count[1] = temp2;
				point[0] = righthash(point[0], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[1], j)] = clrhash[righthash(point[0], j)];
				}
				break;
				
			case 4:
				if(count[1]>0 || count[1]==-5) {
					break;
				}
				point[1] = righthash(point[1], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[0], j)] = clrhash[righthash(point[1], j)];
				}
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]--;
				btrack(x+1);
				count[0] = temp1;
				count[1] = temp2;
				point[1] = lefthash(point[1], 2);
				for (j=1; j<=3; j++) {
					clrhash[righthash(point[0], j)] = clrhash[righthash(point[1], j)];
				}
				break;
			}
		}
	}
}