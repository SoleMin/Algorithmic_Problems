import java.io.*;
import java.util.StringTokenizer;
class Main {
	static int[] dx = {1,1,0,-1,-1,-1,0,1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int fieldCount=1;
		StringBuilder sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0) break;
			int[][] array = new int[n][m];
			for(int i=0; i<n; i++){
				String s = br.readLine();
				for(int j=0; j<m; j++){
					if(s.charAt(j)=='*'){
						array[i][j] = -8;
						int startI = i;
						int startJ = j;
						for(int k=0; k<8; k++){
							int newI = startI+dx[k];
							int newJ = startJ+dy[k];
							if(newI<n && newI>=0 && newJ<m && newJ>=0){
								array[newI][newJ]++;
							}
						}
					}
					
					
				}
			}
			sb.append("Field #").append(fieldCount).append(':').append('\n');
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(array[i][j]<0) sb.append('*');
					else sb.append(array[i][j]);
				}
				sb.append('\n');
			}
			fieldCount++;
			sb.append('\n');
			
			
		}
		System.out.println(sb);
		
		
	}
}