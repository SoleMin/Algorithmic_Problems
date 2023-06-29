import java.io.*;
import java.util.Scanner;
class Main {
	static int m,n;
	static char[][] g;
	static String s;
	static int[] dx={1,-1,0,0,1,1,-1,-1};
	static int[] dy={0,0,1,-1,-1,1,1,-1};
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0; i<t; i++){
			m=input.nextInt();
			n=input.nextInt();
			g=new char[m][n];
			for(int x=0; x<m; x++){
				String ss= input.next().toLowerCase();
				for(int y=0; y<n; y++){
					g[x][y]=ss.charAt(y);
				}
			}
			
			int k=input.nextInt();
			for(int j=0; j<k; j++){
				s= input.next().toLowerCase();
				printResult();
			}
			System.out.println();
		}
		
		input.close();
	}
	
	public static void printResult(){
		char first=s.charAt(0);
		boolean stop=false;
		for(int a=0; a<m; a++){
			if(stop)
				break;
			for(int b=0; b<n; b++){
				if(first==g[a][b]){
					if(right(a,b)){
						System.out.println((a+1)+" "+(b+1));
						stop=true;
						break;
					}
				}
			}
		}
	}
	
	public static boolean right(int a, int b){
		for(int j=0; j<8; j++){
			boolean r=true;
			int nextX=a;
			int nextY=b;
			for(int i=1; i<s.length(); i++){
				nextX=nextX+dx[j];
				nextY=nextY+dy[j];
				if(nextX<0 || nextY<0 || nextX>=m || nextY>=n){
					r=false;
					break;
				}
				if(s.charAt(i)!=g[nextX][nextY]) {
					r=false;
					break;
				}
			}
			if(r)
				return true;
		}
		return false;
	}
}