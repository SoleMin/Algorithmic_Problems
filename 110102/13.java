import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		ArrayList<int[][]> array = new ArrayList<>();
		
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0&&m==0)
				break;
			int arr[][] = new int[n+2][m+2];
			for(int i =0;i<n+2;i++){for(int j =0; j<m+2;j++) arr[i][j]=0;}
			for( int i=0; i<n; i++){
				String temp = sc.next();
				for(int j=0; j<m; j++){
					if(temp.charAt(j)=='*'){
						for(int x =i; x<=i+2;x++){
							for(int y = j; y<=j+2;y++)
								arr[x][y] += 1;
						}
						arr[i+1][j+1] = -100;
					}
				}
			}
		
			array.add(arr);
		}
		
		for(int i =1; i<=array.size(); i++){
			
			System.out.println("Field #"+i+":");
			for(int a =1; a<array.get(i-1).length-1;a++){
				for(int b = 1; b<array.get(i-1)[a].length-1;b++){
					if(array.get(i-1)[a][b]<0)
						System.out.print("*");
					else
						System.out.print(array.get(i-1)[a][b]);
				}
				System.out.println();
			}
			System.out.println();
			
		}
	}
}