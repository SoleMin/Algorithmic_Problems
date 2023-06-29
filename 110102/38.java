import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		char[][] matrix = null;
		String[] mine = null;
		int cnt = 0;
		while(!(input = br.readLine()).equals("0 0")){

			cnt++;
			System.out.println("Field #"+cnt+":");
			String inputStr[] = input.split(" ");
			int col = 0;
			int row = 0;
			int mineCnt, colIndex, rowIndex, x, y = 0;
			
			if(inputStr.length>1){
				col = Integer.parseInt(inputStr[0]);
				row = Integer.parseInt(inputStr[1]);
				matrix = new char[col][row];
				mine = new String[col];
			}
			
			for(x = 0; x < col; x++){
				mine[x] = br.readLine();
				for(y=0; y<row; y++){
					matrix[x][y] = mine[x].charAt(y);
				}
			}
			
			for(x=0; x<col ;x++){
				for(y=0; y<row; y++){
					switch(matrix[x][y]){
							case'*':
								System.out.print(matrix[x][y]);
								break;
						default:
							mineCnt = 0;
							int colInit = (x>0) ? x-1 : 0;
							for(colIndex = colInit; colIndex <= x+1 && colIndex <= col-1; colIndex++){
								int rowInit = (y>0) ? y-1 : 0;
								for(rowIndex=rowInit; rowIndex<= y+1 && rowIndex <= row-1; rowIndex++)
									if(matrix[colIndex][rowIndex] == '*') mineCnt++;
							}
							System.out.print(mineCnt);
							break;
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}