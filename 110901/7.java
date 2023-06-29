import java.util.Scanner;

public class Main {

	static int size;
	static int[][] g = null;
	static int[] color = null;
	static boolean result= true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ip =new Scanner(System.in);
		//g=new int[3][3];
		
		
		while(true) {
			String n1= ip.nextLine();
			int n= Integer.parseInt(n1);
			if(n==0)
				break;
			size= n;
			g=new int[n][n];
			color = new int [n];
			String l = ip.nextLine();
			int l2 = Integer.parseInt(l);
			while(l2!=0) {
				String s = ip.nextLine();
				String[] sb= s.split(" ");
				g[Integer.parseInt(sb[0])][Integer.parseInt(sb[1])]=1;
				g[Integer.parseInt(sb[1])][Integer.parseInt(sb[0])]=1;
				l2--;
			}
			result = true;
			dfs(0,1);
			
			if(result==false)
				System.out.println("NOT BICOLORABLE.");
			else 
				System.out.println("BICOLORABLE.");
			
		}
	}
	
	static void dfs(int start,int c) {
		int i=0;
		color[start]=c;
		for(i=0;i<size && result;i++) {
			if (g[start][i] == 0) continue;
			
			if (color[i] == 0)
				dfs(i, c%2 + 1);
			else {
				if (color[i] == c)
				{
					result = false;
					return;
				}
			}
		}
		
	}

}