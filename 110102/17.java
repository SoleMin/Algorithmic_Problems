import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int fieldNum = 0;
		
		while(input.hasNextLine()){
			String inputS = input.nextLine();
			String[] nums = inputS.split(" ");
			fieldNum++;
			
			int row = Integer.parseInt(nums[0]);
			int col = Integer.parseInt(nums[1]);
			
			if(row == 0 || col == 0)
				break;
			
			String[][] board = new String[row][col];
			int[][] field = new int[row][col];
			
			for(int i=0; i<row; i++){
				String line = input.nextLine();
				for(int j=0; j<col; j++){
					char k = line.charAt(j);
					board[i][j] = Character.toString(k);
				}
			}
			
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					if(board[i][j].equals("*")){
						if(i-1 >= 0 && j-1 >= 0)
							field[i-1][j-1] += 1;
						if(i-1 >= 0)
							field[i-1][j] += 1;
						if(i-1 >= 0 && j+1 < col)
							field[i-1][j+1] += 1;
						
						if(j-1 >= 0)
							field[i][j-1] += 1;
						if(j+1 < col)
							field[i][j+1] += 1;
						
						if(i+1 < row && j-1 >= 0)
							field[i+1][j-1] += 1;
						if(i+1 < row)
							field[i+1][j] += 1;
						if(i+1 < row && j+1 < col)
							field[i+1][j+1] += 1;	
					}
				}
			}
			
			String[][] finalField = new String[row][col];
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					if(board[i][j].equals("*"))
						finalField[i][j] = "*";
					else
						finalField[i][j] = Integer.toString(field[i][j]);
				}
			}
			
			System.out.println("Field #" + fieldNum + ":");
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					System.out.print(finalField[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		input.close();
	}
}