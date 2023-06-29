import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		int times = 1;
		while(input.hasNext()){
			
			int n = input.nextInt();
			int m = input.nextInt();
			char arr[][] = new char[n][m];
			
			
			for(int i = 0;i<n;i++){
				String s = input.next();
				for(int j =0;j<m;j++){
					arr[i][j]=s.charAt(j);
				}
				
			}
			
			if(input.hasNextInt()){
				System.out.printf("Field #%d:\n",times);
			}
			
			
			
			for(int i =0;i<n;i++){
				for(int j =0;j<m;j++){
					if(arr[i][j]=='*'){
					System.out.printf("*");
					}
					else{
						int a =0;
						for(int x =i-1;x<i+2;x++){
							for(int y=j-1;y<j+2;y++){
								if(x>=0 && y>=0 && x<n && y<m && arr[x][y]=='*'){
									a++;
								}
							}
						}
						System.out.printf("%d",a);
					}
				}
				System.out.println();
			}
			times++;
			System.out.println();
		}
		
	}
}