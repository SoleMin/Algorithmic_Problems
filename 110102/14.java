import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int row = 1;
		int col = 1;
		int i,j,c=1;
		
		while(true){
			row = sc.nextInt();
			col = sc.nextInt();
			if(row ==0 && col ==0)
				break;
			
			String[][] a = new String[row+2][col+2];
			String[][] mine = new String[row][col];
			
				for(i=0;i<row+2;i++)
				for(j=0;j<col+2;j++)
					a[i][j]="/";

			for(i=0;i<row;i++){
				String input = sc.next();
				String[] arr = input.split("");
				for(j=0;j<col;j++){
					a[i+1][j+1] = arr[j];
				}
			}

			for(i=1;i<row+1;i++){
				for(j=1;j<col+1;j++){
					if(a[i][j].equals("*")){
						mine[i-1][j-1]="*";
					}
					else if(a[i][j].equals(".")){
						int count=0;

						if(a[i-1][j-1].equals("*"))
							count++;
						if(a[i-1][j].equals("*"))
							count++;
						if(a[i-1][j+1].equals("*"))
							count++;
						if(a[i][j-1].equals("*"))
							count++;
						if(a[i][j+1].equals("*"))
							count++;
						if(a[i+1][j-1].equals("*"))
							count++;
						if(a[i+1][j].equals("*"))
							count++;
						if(a[i+1][j+1].equals("*"))
							count++;

						mine[i-1][j-1] = Integer.toString(count);
					}
				}
			}



			System.out.println("Field #"+c+":");
			for(i=0;i<row;i++){
			for(j=0;j<col;j++)
				System.out.print(mine[i][j]);
			System.out.println();
			}
			System.out.println();
			c++;
		}
	}
		
}