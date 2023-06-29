import java.util.Scanner;

public class Main {

	static int[][] dynamic;
	static int n, max, carlengthsum,carlength, top;
	static int[][][] from;
	static int[] stack;
	static int MAXL=100;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();

		for(int i=0; i<t; i++) {
			dynamic=new int[MAXL*100+1][2];
			from=new int[MAXL*2+1][MAXL*100+1][2];
			stack= new int[MAXL*2];

			n=input.nextInt();
			n*=100;
			for(int j=0; j<=n; j++) {
				dynamic[j][0] = -1; 
				dynamic[j][1] = 0;
			}
			dynamic[0][0] = 0; 
			carlengthsum = 0;
			max = 0;
			carlength=input.nextInt();
			for (int j = 0; carlength!=0; j++){
				if    (carlengthsum    <=    2    *    n) {
					solve(j+ 1); carlengthsum +=carlength;
				}
				carlength=input.nextInt();
			} 
			output(i);
		}
		input.close();
	}

	public static void output(int t) {
		int i,j,k=0;
		top = 0;
		for  (i = dynamic[max][0], j =max;i >  0; j -= from[i][k][1], i = from[i][k][0]) { 
			stack[top++] = 1;
			for    (k= i- 1; k >from[i][j][0]; k--) 
				stack[top++] = 0;
			k = j;
		}
		if    (t  > 0) 
			System.out.println();
		System.out.println(dynamic[max][0]);
	}

	public static void solve(int carnum)    { 
		int i;
		for (i= n; i >= carlength; i--)    {
			if (dynamic[i - carlength][0]  !=-1 &&carlengthsum - i + carlength <= n && dynamic[i][0] < carnum) { 
				dynamic[i][0] = carnum;
				dynamic[i][1] = carlengthsum -  i  + carlength; 
				from[carnum][i][0] = dynamic[i - carlength][0];
				from[carnum][i][1] = carlength;
				if    (dynamic[max][0]    <    dynamic[i][0]    ||    (dynamic[max][0]    ==    dynamic[i][0]    && Math.abs(max-dynamic[max][1])> Math.abs(i -dynamic[i][1])))
					max    =    i; 
			}

		} 
	}

}
