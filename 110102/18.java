import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
	
		Scanner input = new Scanner (System.in);
		int field = 1;
		char star = '*';
		
		while(true) {

			int row = input.nextInt();
			int col = input.nextInt();
			
			if (row == 0 && col == 0)
				break;
			
			char [][] arr = new char [row][col];
			
			for (int i = 0; i < row; i++) {
				String s = input.next();
				for (int j = 0; j < col; j++)
					arr[i][j] = s.charAt(j);
				}
			
			System.out.println("Field #" + field + ":");
			
			int count;
			
			for (int i = 0; i < row; i++)
				for (int j = 0;  j < col; j++) {
					
					if (arr[i][j] == star) continue;
					
					count = 0;
					
					if (i > 0 && j > 0)
						if (arr[i-1][j-1] == star) count++;
					if (i > 0 && j < col - 1)
						if (arr[i-1][j+1] == star) count++;
					if (i < row - 1 && j > 0)
						if (arr[i+1][j-1] == star) count++;
					if (i < row - 1 && j < col - 1)
						if (arr[i+1][j+1] == star) count++;
					if (i > 0)
						if (arr[i-1][j] == star) count++;
					if (i < row -1)
						if (arr[i+1][j] == star) count++;
					if (j > 0)
						if (arr[i][j-1] == star) count++;
					if (j < col -1)
						if (arr[i][j+1] == star) count++;
					
					
					arr[i][j] = (char)(count + '0');
					
			}
			
			for (int i = 0; i < row; i++){
				for (int j = 0; j < col; j++)
					System.out.print(arr[i][j]);
				System.out.println();	
			}
			System.out.println();
			
			field++ ;
		}
	}
	
}