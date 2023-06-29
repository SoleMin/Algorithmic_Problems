import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int count = 1;

		while(true){
		int n = scan.nextInt();
		int m = scan.nextInt();
		if(n == 0 && m == 0) break;
		char[][] board = new char[n][m];
		
			for(int i = 0; i < n;i++){
				String miset = scan.next();
				for(int j = 0; j < m;j++){
					board[i][j] = miset.charAt(j);
				}
			}
			
			System.out.println("Field #"+ count+ ":");
			count++;
			
			for(int i = 0 ; i< n;i++){
				for(int j = 0; j < m ; j++){
					if(board[i][j]=='*')
					{
						System.out.print('*');
					}
					else{
						int minum = 0;
						for(int ii =((i>0)?i-1:0); ii<i+2&&ii<n;ii++)
							for(int jj=((j>0)?j-1:0);jj<j+2&&jj<m;jj++)
								if(board[ii][jj]=='*')minum +=1;
						System.out.print(minum);
					}
				}
			System.out.println("");
		}
			System.out.println("");
		
		}
		}
	
}