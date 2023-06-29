import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
			int n=1, m=1;
		int count=0;
			Scanner input = new Scanner(System.in);
		while(true){
			count++;
			n=input.nextInt();
			m=input.nextInt();
			if(n==0 && m==0){
				break;
			}
			input.nextLine();
			char[][] mine = new char[n][m];
			for(int i=0; i<n; i++){
				String s = input.nextLine();
				for(int j=0; j<m; j++){
					mine[i][j] = s.charAt(j);
					if(mine[i][j] =='.'){
						mine[i][j]='0';
					}
				}
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(mine[i][j]=='*'){
					for(int x=i-1; x<=i+1; x++){
						for(int y=j-1; y<=j+1; y++){
							if(x>=0 && x<n && y>=0 && y<m && mine[x][y]!='*'){
								mine[x][y]++;
							}
						}
					}
					}
				}
			}
			System.out.print("\nField #"+count+":");
			for(int i=0; i<n; i++){
				System.out.print("\n");
				for(int j=0; j<m; j++){
					System.out.print(mine[i][j]);
					
				}
				
			}
			System.out.println();
		}
		
	}
}