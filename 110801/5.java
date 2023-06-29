import java.util.Scanner;

public class Main {

	static int n,k,count, size;
	static int[][] ar;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		while(true){
			n=input.nextInt();
			k=input.nextInt();
			if(n==0 && k==0){
				break;
			}
			ar= new int[n][n];
			count=0;
			size=n*n;

			sol(0,0);

			System.out.println(count);

		}

		input.close();
	}

	public static void sol(int start, int cnt) {
		
		if(cnt==k) {
			count+=1;
		}
		else {
			for(int i=start; i<size; i++){
				int x=i/n;	
				int y= i%n;
				if(ar[x][y]==0 && ispo(x, y)) {
					ar[x][y]=1;

					sol(i+1,cnt+1);

					ar[x][y]=0;
				}
			}

		}
	}

	public static boolean ispo(int x, int y) {
		for(int i=1; i<n; i++) {
			int nextx1=x-i;
			int nexty1=y-i;
			int nextx2=x-i;
			int nexty2=y+i;
			int nextx3=x+i;
			int nexty3=y-i;
			int nextx4=x+i;
			int nexty4=y+i;

			if(!ispo2(nextx1, nexty1))
				return false;
			if(!ispo2(nextx2, nexty2))
				return false;
			if(!ispo2(nextx3, nexty3))
				return false;
			if(!ispo2(nextx4, nexty4))
				return false;
		}
		return true;
	}

	public static boolean ispo2(int nextX, int nextY) {
		if(!(nextX<0 || nextY<0 || nextX>=n || nextY>=n))
			if(ar[nextX][nextY]==1)
				return false;
		return true;
	}
}