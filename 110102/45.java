import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String inputString;
		
		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> columnList = new ArrayList<>();
		ArrayList<char[][]> fieldList = new ArrayList<>();
		
		String[] inputArr;
		int fieldNumber = 0;
		int[] dx = {-1, -1, -1 ,0 ,0, +1, +1 ,+1};
		int[] dy = {-1, 0, +1, -1, +1, -1, 0 , +1};
		int row, column;
		
		while(true){
			inputString = input.nextLine();
			inputArr = inputString.split(" ");
			
			row = Integer.parseInt(inputArr[0]);
			column = Integer.parseInt(inputArr[1]);
			
			if(row == 0 && column ==0){
				break;
			}
			
			rowList.add(row);
			columnList.add(column);
			
			char[][] field = new char[row][column];
			for(int i = 0 ;i < row; i++){
				inputString = input.nextLine();
				field[i] = inputString.toCharArray();
			}
			fieldList.add(field);
		
	}
	while(fieldNumber <= fieldList.size()-1){
		char[][] field = fieldList.get(fieldNumber);
		row = rowList.get(fieldNumber);
		column = columnList.get(fieldNumber);
		
		for(int i=0; i < row; i++){
			for(int j=0; j < column; j++){
				if(field[i][j] == '*')
					continue;
				else{
					int counter =0;
					for(int k =0 ; k < 8; k++){
						int x = dx[k];
						int y = dy[k];
						if((x+i) < row && (x+i) >= 0 && (y+j) < column && (y + j) >= 0){
							if(field[x+i][y+j] == '*')
								counter++;
						}
					}
					field[i][j] = Character.forDigit(counter, 10);
				}
			}
		}
		fieldNumber++;
		System.out.println("Field #"+fieldNumber +":");
		
		for(int x = 0 ; x< row ; x++){
			for(int y = 0 ; y < column ; y++ ){
				System.out.print(field[x][y]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	}
}