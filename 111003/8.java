import java.util.Scanner;

public class Main {

	static int[] pos;
	static int[][] Dis;
	static int inf=9999999;
	static int[] result;

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int t=input.nextInt();
		for(int k=0; k<t; k++) {
			int nf=input.nextInt();
			int ni=input.nextInt();
			pos= new int[ni+1];
			Dis= new int[ni+1][ni+1];
			result=new int[ni+1];

			for (int i=0; i<nf; i++) {
				int n=input.nextInt();
				pos[n]=1;
			}
			input.nextLine();

			initialize(ni);

			while(input.hasNext()) {
				String s= input.nextLine();
				if(s.equals(""))
					break;
				String[] ss= s.split(" ");
				int x=Integer.parseInt(ss[0]);
				int y=Integer.parseInt(ss[1]);
				int L=Integer.parseInt(ss[2]);
				Dis[x][y] = L;
				Dis[y][x] = L;
			}


			floyd(ni);

			int[] s_l= new int[ni+1]; // shortest length
			int max_s_l = 0; // max shortest length
			for (int i = 1; i <= ni; i++) {
				s_l[i] = inf;
				for (int j = 1; j <= ni; j++) {
					if(pos[j]==1)
						s_l[i] = Math.min(s_l[i], Dis[i][j]);
				}
				max_s_l = Math.max(max_s_l, s_l[i]);
			}
			int z=max_s_l;
			int zz=0;
			for (int i = 1; i <= ni; ++i) {
				if(z == s_l[i]) {
					zz=i;
					break;
				}
			}


			for(int x=1; x<=ni; x++) {
				if(pos[x]==0) {
					pos[x]=1;
					s_l= new int[ni+1];
					max_s_l = 0; 
					for (int i = 1; i <= ni; i++) {
						s_l[i] = inf;
						for (int j = 1; j <= ni; j++) {
							if(pos[j]==1)
								s_l[i] = Math.min(s_l[i], Dis[i][j]);
						}
						max_s_l = Math.max(max_s_l, s_l[i]);
					}

					result[x]=max_s_l;
					pos[x]=0;

				}
			}

			int Ans = 1;
			boolean ex=false;

			int min=result[1];
			for (int i = 1; i <= ni; ++i) {
				if(result[i]!=0 && min>result[i]) {
					min=result[i];
					Ans=i;
					ex=true;
				}


			}
			if(!ex) {

				Ans=zz;
			}
			System.out.println(Ans+"\n");

		}
		input.close();

	}

	public static void initialize(int N)
	{
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j)
				Dis[i][j] = inf;
			Dis[i][i] = 0;
		}
	}

	public static void floyd(int N) {
		for (int k = 1; k <= N; ++k)
			for (int i = 1; i <= N; ++i)
				for (int j = 1; j <= N; ++j)
					if (Dis[i][k] + Dis[k][j] < Dis[i][j])
						Dis[i][j] = Dis[i][k] + Dis[k][j];
	}


}
