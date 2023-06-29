import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int n, num=0;
	static String[] pos;
	static int[][] map;
	static int[] visit, found;
	static ArrayList<String> ar;

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		int index=0;
		while(true) {
			n=input.nextInt();
			if(n==0)
				break;

			index++;
			pos=new String[n+1];
			map=new int[n+1][n+1];
			visit= new int[n+1];
			ar=new ArrayList<String>();
			found=new int[n+1];
			for(int i=1; i<=n; i++) {
				pos[i]=input.next();
			}

			int r=input.nextInt(); 
			for(int i=0; i<r; i++) {
				String a=input.next();
				String b=input.next();
				int x=0,y=0;
				for(int j=1; j<=n; j++) {
					if(pos[j].equals(a))
						x=j;
					if(pos[j].equals(b))
						y=j;
				}
				map[x][y]=1;
				map[y][x]=1;
			}


			for(int i=1; i<=n; i++) {
				if(visit[i]==0)
					dfs(i, true);
			}


			System.out.printf("City map #%d: %d camera(s) found\n", index, ar.size());
			Collections.sort(ar);
			for(String s: ar) {
				System.out.println(s);
			}

			System.out.println();

		}

		input.close();
	}

	public static int dfs(int cur, boolean root) {
		visit[cur]=++num;
		int ret=visit[cur];
		int child=0;

		for(int i=1; i<=n; i++) {
			if(map[cur][i]==1) {
				if(visit[i]==0) {

					child++;
					int low=dfs(i, false);
					if(!root && visit[cur]<=low) {
						if(found[cur]==0) {
							ar.add(pos[cur]);
							found[cur]=1;
						}
					}

					ret=Math.min(ret, low);
				}
				else{
					ret=Math.min(ret, visit[i]);
				}
			}
		}

		if(root && child>=2) {
			if(found[cur]==0) {
				ar.add(pos[cur]);
				found[cur]=1;
			}
		}
		return ret;

	}
}
