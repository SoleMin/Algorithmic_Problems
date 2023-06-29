import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		
		for(int i =0 ; i< t ; i++){
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			scanner.nextLine();
			k+=8;
			
			int [] arr1 = new int[n+1];
			int [][] d = new int[3][5010];
			
		 	for(int x = 0; x<3; x++){
				for(int y=0; y<5010;y++){
					d[x][y]= 10000;
				}
			}
			
			d[0][0]=0;
			d[1][0]=0;
			d[2][0]=0;
			for(int j=n; j >=1; j--)
					arr1[j] = scanner.nextInt();
			
			scanner.nextLine();
		//	System.out.println(k);
		//	System.out.println(d[1][1]);			
			
			for(int j =3 ; j<=n;j++){
				for(int x =1; x*3<=j;x++){
					d[j%3][x] = Math.min(d[(j-1)%3][x], d[(j-2)%3][x-1]+(arr1[j]-arr1[j-1])*(arr1[j]-arr1[j-1]));
				}
			}
			
			
			System.out.println(d[n%3][k]);
			
			
			
 		}
		
		
	}
}