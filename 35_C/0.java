import java.util.*;
import java.io.*;

public class readFromFile {

	public static void main(String[] args) throws Exception {
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		
		int n=sc.nextInt(),m=sc.nextInt();
		int k=sc.nextInt();
		int dist[][]=new int[n][m];
		for(int i=0;i<n;i++)
			Arrays.fill(dist[i], -1);
		ArrayDeque<Integer> x=new ArrayDeque<>(),y=new ArrayDeque<>();
		for(int i=0;i<k;i++) {
			int xi=sc.nextInt()-1,yi=sc.nextInt()-1;
			dist[xi][yi]=0;
			x.add(xi);
			y.add(yi);
		}
		int xd[]= {1,-1,0,0},yd[]= {0,0,1,-1};
		while(!x.isEmpty()) {
			int xs=x.remove(),ys=y.remove();
			for(int i=0;i<4;i++) {
				int x_to=xs+xd[i],y_to=ys+yd[i];
				if(legal(x_to,y_to,dist)) {
					dist[x_to][y_to]=dist[xs][ys]+1;
					x.add(x_to);
					y.add(y_to);
				}
			}
		}
		int ans=-1,xc=0,yc=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(dist[i][j]>ans) {
					ans=dist[i][j];
					xc=i+1;
					yc=j+1;
				}
			}
		}
		StringBuilder r=new StringBuilder();
		r.append(xc+" ");
		r.append(yc);
		String result=r.substring(0);
		
		
		
		try {
			FileWriter writer = new FileWriter("output.txt");
			writer.write(result);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static boolean legal(int x,int y,int a[][]) {
		return x>=0 && y>=0 && x<a.length && y<a[0].length && a[x][y]==-1;
	}
	

}
