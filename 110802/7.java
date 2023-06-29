import java.util.Scanner;

public class Main {

	static int MAXMOVE=50, MAXDEPTH, solved, mtop;
	static int[][] puzzle;
	static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};
	static char[] movechar= {'U','R','D','L'};
	static int[] movestack;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t=input.nextInt();
		for(int i=0; i<t; i++) {
			
			puzzle=new int[4][4];
			movestack=new int[MAXMOVE];
			
			for(int j=0; j<4; j++) {
				for(int k=0; k<4; k++) {
					puzzle[j][k]=input.nextInt();
				}
			}
			
			mtop=0;
			solved=0;
			solve();
			
			if(solved!=0) {
				for(int l=0; l<mtop; l++) {
					System.out.print(movechar[movestack[l]]);
				}
				System.out.println();
			}
			else {
				System.out.println("This puzzle is not solvable.");
			}
		}

		input.close();

	}

	public static void solve() {
		int x=0,y=0,l,value=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(puzzle[i][j]==0) {
					value+=i;
					x=i;
					y=j;
				}
				for(int k=i; k<4; k++) {
					if(k==i)
						l=j+1;
					else
						l=0;
					for(; l<4; l++) {
						if(puzzle[k][l] != 0 && puzzle[i][j]>puzzle[k][l])
							value++;
					}
				}
			}
		}
		if(value%2==0)
			return;

		for(MAXDEPTH=cost(); solved==0 && MAXDEPTH <= MAXMOVE; MAXDEPTH+=2)
			back(0,x,y);
	}

	public static int cost() {
		int md1=0, md2=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(puzzle[i][j]!=0) {
					md1+=Math.abs(i-((puzzle[i][j]-1) / 4));
					md2+=Math.abs(j-((puzzle[i][j]-1) % 4));
				}
			}
		}
		return md1+md2;
	}
	
	public static void back(int a, int nowx, int nowy) {
		int c=cost();
		if(c==0) {
			solved=1;
			return;
		}
		if(a+c>MAXDEPTH)
			return;
		
		for(int i=0; i<4; i++) {
			if(mtop>0 && (movestack[mtop-1]+2)%4==i)
				continue;
			
			int nextx=nowx+move[i][0];
			int nexty=nowy+move[i][1];
			
			if(nextx<0 || nexty<0 || nextx>=4 || nexty>=4)
				continue;
			
			puzzle[nowx][nowy]=puzzle[nextx][nexty];
			puzzle[nextx][nexty]=0;
			
			movestack[mtop++]=i;
			back(a+1, nextx, nexty);
			
			if(solved!=0)
				return;
			mtop--;
			
			puzzle[nextx][nexty]=puzzle[nowx][nowy];
			puzzle[nowx][nowy]=0;
			
		}
	}

}
