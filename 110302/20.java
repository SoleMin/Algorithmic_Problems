import java.io.*;
import java.util.*;
class Main {
	static int[] dx = {1,1,0,-1,-1,-1,0,1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testCase-->0){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			char[][] field = new char[n][m];
			for(int i=0; i<n; i++){
				field[i] = br.readLine().toLowerCase().toCharArray();
			}
			int tmp = Integer.parseInt(br.readLine());
			while(tmp-->0){
				
				char[] cArray = br.readLine().toLowerCase().toCharArray();
				
				boolean exit = false;
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++){
						if(cArray[0]==field[i][j]){
							int startI = i;
							int startJ = j;
							
							for(int k=0; k<8; k++){
								boolean tf = true;
								for(int l=1; l<cArray.length; l++){
									startI += dx[k];
									startJ += dy[k];
									if(startI>=0 && startI<n && startJ>=0 && startJ<m && field[startI][startJ]==cArray[l]){
										continue;
									}
									else{
										startI = i;
										startJ = j;
										tf = false;
										break;
									}
									
								}
								if(tf){
									sb.append(i+1).append(' ').append(j+1).append('\n');
									exit = true;
									break;
								}
							}
							
						}
						
						if(exit) break;
					}
					if(exit) break;
				}
				
				
			}
			
			sb.append('\n');
		}
		System.out.println(sb);
		
		
		
		
	}
}