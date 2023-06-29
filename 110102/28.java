import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int m=0; int n=0; int cout=1;
		
		while (true){
			
			m=input.nextInt();
			n=input.nextInt();
			
			if(m !=0 && n !=0){
				
				int[][] result = new int[m][n];
				int[][]	matrix = new int[m+2][n+2];
				
				for(int i=1; i<=m; i++){
					String str = input.next();
					for (int j=1; j<=n; j++){
						if(str.charAt(j-1)=='*')
							matrix[i][j]=1;
						else
							matrix[i][j]=0;
					}
					
				}
				for (int i=1; i<=m; i++){
					for(int j=1; j<=n; j++){
						int count =0;
						
						for(int k=i-1; k<=i+1; k++)
							for(int l=j-1; l<=j+1; l++){
								if(k == i && l==j)
									continue;
								if(matrix[k][l]==1)
									count++;
							}
						result[i-1][j-1]=count;
					}
					
				}
				System.out.println("Field #"+ cout + ":");
				
				for(int i =0; i<m; i++){
					for(int j=0; j<n; j++){
						if(matrix[i+1][j+1]==1)
							System.out.print("*");
						else
							System.out.print(result[i][j]);
					}
					
					System.out.println("");
				}
				cout++;
				System.out.println();
				
			}	else{
				break;
			}
			
		}
		
		
	}
}