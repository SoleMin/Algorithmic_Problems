import java.io.*;
import java.util.Scanner;
class Main {
	
	static int n,m;
	static int[] dx={-1,1,0,0,-1,1,-1,1};
	static int[] dy={0,0,-1,1,-1,-1,1,1};
	static int[][] result;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int field=1;
		
		while(true){
			n=input.nextInt();
			m=input.nextInt();
			String[][] matrix = new String[n][m];
			result = new int[n][m];
			if (n==0 && m==0)
				break;
			
			for (int i=0; i<n; i++){
				String s =input.next();
				for (int j=0; j<m; j++){
					matrix[i][j]=s.substring(j,j+1);
					if (matrix[i][j].equals("*")) {
						result[i][j]=-1;
						count(i,j);
					}
				}
			}
			
			System.out.println("Field #"+field+":");
			for (int i=0; i<n; i++){
				for (int j=0; j<m; j++){
					if (result[i][j]==-1){
						System.out.print("*");
					}
					else {
						System.out.print(result[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println();
			field++;
		}
		input.close();
	}
	
	public static void count (int x, int y){
		for (int i=0; i<8; i++){
			int nextX=x+dx[i];
			int nextY=y+dy[i];
			
			if (nextX<0 || nextY<0 || nextX>=n || nextY>=m || result[nextX][nextY]==-1) {
				continue;
			}
			else{
				result[nextX][nextY]++;
			}
		}
	}
}