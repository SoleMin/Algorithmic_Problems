import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	public static boolean [][] mat;
	public static boolean [] visited;
	
	public static void fill (int id) {
		if (!visited[id]) {
			visited[id]=true;
			for (int i=0;i<mat.length;i++) {
				if (mat[id][i]) {
					fill(i);
				}
			}
		}
	}
	
	public static int computeCC (int disabled) {
		Arrays.fill(visited,false);
		if (disabled!=-1) {
			visited[disabled]=true;
		}
		int count=0;
		for (int i=0;i<mat.length;i++) {
			if (!visited[i]) {
				fill(i);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		while (true) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				break;
			}
			String [] name=new String [N];
			HashMap<String,Integer> map=new HashMap<>();
			for (int i=0;i<N;i++) {
				name[i]=br.readLine();
				map.put(name[i], i);
			}
			
			mat=new boolean [N][N];
			int R=Integer.parseInt(br.readLine());
			for (int i=0;i<R;i++) {
				String [] city=br.readLine().split(" ");
				int id0=map.getOrDefault(city[0],-1);
				int id1=map.getOrDefault(city[1],-1);
				if (id0!=id1 && id0>=0 && id0<N && id1>=0 && id1<N) {
					mat[id0][id1]=true;
					mat[id1][id0]=true;
				}
			}
			
			visited=new boolean [N];
			int initCC=computeCC(-1);
			String [] camera=new String [N];
			int cameraCount=0;
			for (int i=0;i<visited.length;i++) {
				int currCC=computeCC(i);
				if (currCC>initCC) {
					camera[cameraCount++]=name[i];
				}
			}
			Arrays.sort(camera,0,cameraCount);
			
			if (t>1) {
				System.out.println();
			}
			StringBuilder sb=new StringBuilder();
			sb.append("City map #");
			sb.append(t++);
			sb.append(": ");
			sb.append(cameraCount);
			sb.append(" camera(s) found\n");
			for (int i=0;i<cameraCount;i++) {
				sb.append(camera[i]);
				sb.append('\n');
			}
			System.out.print(sb.toString());
		}
	}
}