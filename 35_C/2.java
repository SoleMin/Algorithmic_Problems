import java.io.*;
import java.util.*;
import java.math.*;



public class Main{
	
	public static void main(String[] Args) throws Exception {
	     Scanner sc = new Scanner(new FileReader("input.txt"));
	     int n,m,k;
	     Integer lx,ly;
	     boolean d[][];
	     n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
	     d = new boolean [n+1][m+1];
	     for(int i=0;i<=n;++i)
	      for(int j=0;j<=m;++j)
	       d[i][j]=false;
	     
	     Queue< pair > q = new LinkedList< pair >();
	     lx = ly = -1;
	     for(int i=0;i<k;++i){
	     	int x,y; x = sc.nextInt(); y = sc.nextInt();
	     	q.add(new pair(x,y)); lx = x; ly = y;
	     	d[x][y]=true;
	     }
	     
	     int dx [] = {0,0,1,-1};
	     int dy [] = {-1,1,0,0};
	     
	     
	     while(!q.isEmpty()){
	     	 pair tp = q.remove();
	     	 int x = tp.x; int y = tp.y;
	     	 for(int i=0;i<4;++i){
	     	 	 int nx = x+dx[i]; int ny = y+dy[i];
	     	 	 if(nx<1 || nx>n || ny<1 || ny>m || d[nx][ny] ) continue;
	     	     d[nx][ny]=true;
	     	     q.add(new pair(nx,ny));
	     	     lx = nx; ly = ny;
	     	 }
	     }
	     FileWriter fw = new FileWriter("output.txt");
	     fw.write(lx.toString()); fw.write(" "); fw.write(ly.toString());;
	     fw.flush();
	     	
	}
}
class pair {

  public int x,y;
  public pair(int _x,int _y){ x = _x; y = _y; }

}