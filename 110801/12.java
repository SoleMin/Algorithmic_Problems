import java.io.*;
import java.util.Scanner;
class Main {
	public static boolean check(int[][] chess,int n,int m){
		int leng = chess.length;
		int i = n-1;
		int j = m-1;
		while(i>=0 && j>=0){
			if(chess[i][j] != 0){
				return false;
			}
			i--;
			j--;
		}
		i = n+1;
		j = m+1;
		while(i<leng && j <leng){
			if(chess[i][j] != 0){
				return false;
			}
			i++;
			j++;
		}
		i = n+1;
		j = m-1;
		while(i<leng && j>=0){
			if(chess[i][j] != 0){
				return false;
			}
			i++;
			j--;
		}
		i = n-1;
		j = m+1;
		while(i >=0 && j<leng){
			if(chess[i][j] != 0){
				return false;
			}
			i--;
			j++;
		}
		return true;
	}
	public static int backT(int[][] chess,int n,int bishops,int start){
		int result =0;
		int i= start/n;
		int j= start%n;
		if(bishops == 0){
			return 1;
		}
		if(start == n*n || n*n-start<bishops){
			return 0;
		}
		if(check(chess,i,j)){
			chess[i][j]++;
			result += backT(chess,n,bishops-1,start+1);
			chess[i][j]--;
		}
		result += backT(chess,n,bishops,start+1);
		return result;
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			int n = scanner.nextInt();
			int bishops = scanner.nextInt();
			
			if(n==0 && bishops ==0){
				break;
			}
			
			int chess[][] = new int[n][n];
			System.out.println(backT(chess,n,bishops,0));
		}
		
	}
}