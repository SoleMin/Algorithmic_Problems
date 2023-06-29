import java.io.*;
import java.util.Scanner;

class Main {
	// 저번에 배운거
	static int[][] dis = {{0,0,0,1},{0,0,0,-1},
						{0,0,1,0},{0,0,-1,0},
						{0,1,0,0},{0,-1,0,0},
						{1,0,0,0},{-1,0,0,0}};

	// origin 확인용
	static int[] Afind = new int[4];
	static int[] Bfind = new int[4];
	
	static int[] cA1 = new int[10000];
	static int[] checkArray = new int[10000];
	static int[] cA2 = new int[10000];

	static int bfs(int oN, int fN) {
		if(oN == fN) return 0;
		
		int turn = 0;
		int check = 0;
		checkArray[check++] = oN;
		cA1[oN] = 1;
		cA2[oN] = 0;
		while ( turn < check ) {
			int now = checkArray[turn];
			for ( int i = 0 ; i < 4 ; ++ i ) {
				Afind[3-i] = now%10;
				now /= 10;
			}
			for ( int i = 0 ; i < 8 ; ++ i ) {
				for ( int j = 0 ; j < 4 ; ++ j ) {
					Bfind[j] = Afind[j] + dis[i][j];
					if ( Bfind[j] == -1 ) {
						Bfind[j] = 9;
					}
					if ( Bfind[j] == 10 ) {
						Bfind[j] = 0;
					}
				}

				if ( Bfind[0] * 1000 + Bfind[1] * 100 + Bfind[2] * 10 + Bfind[3] == fN ) {
					return cA2[checkArray[turn]]+1;
				}
				if ( cA1[Bfind[0] * 1000 + Bfind[1] * 100 + Bfind[2] * 10 + Bfind[3]] != 1 ) {
					cA1[Bfind[0] * 1000 + Bfind[1] * 100 + Bfind[2] * 10 + Bfind[3]] = 1;
					cA2[Bfind[0] * 1000 + Bfind[1] * 100 + Bfind[2] * 10 + Bfind[3]] = cA2[checkArray[turn]]+1;
					checkArray[check++] = Bfind[0] * 1000 + Bfind[1] * 100 + Bfind[2] * 10 + Bfind[3];
				}
			}
			turn++;
		}
		return -1;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int loopCount = input.nextInt();
		int stop = 0;
		String trash = input.nextLine();
		String trash_2 = input.nextLine();
		
		while(stop != loopCount) {
			cA1 = new int[10000];
			
			if(stop != 0) {
				String trash_3 = input.nextLine();
			}
			int answer = 0;
			int count = 0;
			// 문자열로 입력받아서
			String a = input.nextLine() + " ";
			String b = input.nextLine() + " ";
			
			// 쪼개기
			String[] origin_s = a.split(" ");
			String[] fin_s = b.split(" ");
			
			int[] origin = new int[4];
			int[] fin = new int[4];
			
			// 문자 int로 변환
			for(int i = 0; i < 4; i++) {
				origin[i] = Integer.parseInt(origin_s[i]);
				fin[i] = Integer.parseInt(fin_s[i]);
			}
			
			// 금지용 클래스
			class No{
				int sa;
				int sam;
				int e;
				int ill;
				
				public No(int a, int b, int c, int d) {
					this.sa = a;
					this.sam = b;
					this.e = c;
					this.ill = d;
				}
			}
			
			// 금지 받기
			int no = input.nextInt();
			
			// 금지 클래스 초기화
			No[] beep = new No[no];
			for(int i = 0; i < no; i++) {
				beep[i] = new No(0,0,0,0);
			}
			
			// 쓰레기처리
			String trashh = input.nextLine();
			
			// 금지 입력받기
			for(int i = 0; i < no; i++) {
				String aa = input.nextLine() + " ";
				String[] a_s = aa.split(" ");
				beep[i].sa = Integer.parseInt(a_s[0]);
				beep[i].sam = Integer.parseInt(a_s[1]);
				beep[i].e = Integer.parseInt(a_s[2]);
				beep[i].ill = Integer.parseInt(a_s[3]);
				cA1[beep[i].sa * 1000 + beep[i].sam * 100 + beep[i].e * 10 + beep[i].ill] = 1;
			}
			
			System.out.println(bfs(origin[0] * 1000 + origin[1] * 100 + origin[2] * 10 + origin[3], fin[0] * 1000 + fin[1] * 100 + fin[2] * 10 + fin[3]));
			
			stop++;
		}

	}
}
