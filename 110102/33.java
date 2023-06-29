import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		int n,m;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if( n == 0 && m == 0 )
				break;
			count += 1;
			char[][] mw = new char[n][m];
			int[][] nums = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				for(int j = 0; j < m; j++) {
					mw[i][j] = s.charAt(j);
				}
			}
			
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < m; j++) {
					if(mw[i][j] == '*')
						continue;
					for(int i_ = i -1; i_ <= i+1; i_++)
						for(int j_ = j -1; j_ <= j+1; j_++) {
							if( ((0 <= i_)&&(i_ < n))&& ((0 <= j_)&&(j_ < m))) 
								if(mw[i_][j_] == '*')
									nums[i][j] += 1;
						}
				}
			
			System.out.printf("Field #%d:\n",count);
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++) {
					if(mw[i][j] == '*')
						System.out.printf("%c",mw[i][j]);
					else
						System.out.printf("%d",nums[i][j]);
					if(j == m-1) {
						System.out.println();
					}
				}
			System.out.println();
		
		}
	}
}