import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int field = 0;
		
		while(input.hasNextLine()){
			int row = input.nextInt();
			int col = input.nextInt();
			if(row == 0 && col == 0){
				break;
			}
			else {
				field++;
			}
			
			String[][] mine = new String[row][col]; // 입력 받는 배열
			int[][] one = new int[row][col];	// count하는 배열
			String[][] result = new String[row][col]; // 출력 배열

			for(int i = 0; i<row; i++){
				String s = input.next();
				for(int j = 0; j<col; j++){
					mine[i] = s.split("");
				}
			}

			for(int i = 0; i<row; i++){
				for(int j = 0; j<col; j++){
					if(mine[i][j].equals("*"))
						one[i][j] = 1;
					else
						one[i][j] = 0;
				}
			}
			
			int count = 0;
			
			if(row == 1){
				for(int j = 0; j<col; j++){
					if(j == 0){
						count = one[0][1];
					}
					else if(j == (col-1)){
						count = one[0][col-2];
					}
					else{
						count = one[0][j+1] + one[0][j-1];
					}
				
				result[0][j] = Integer.toString(count);
				}
			}
			
			else if (col == 1){
				for(int i = 0; i<row; i++){
					if(i == 0){
						count = one[1][0];
					}
					else if(i == (row-1)){
						count = one[row-2][0];
					}
					else{
						count = one[i+1][0] + one[i-1][0];
					}
				result[i][0] = Integer.toString(count);
				}
			}
			else{
				for(int i = 0; i < row ; i++){
					for(int j = 0; j< col; j++){
						//맨 위
						if(i == 0){
							if(j == 0){	// 맨위 맨앞
								count = one[i][j+1] + one[i+1][j] + one[i+1][j+1];
							}
							else if (j == (col - 1)){ // 맨위 맨끝
								count = one[i][j-1] + one[i+1][j] + one[i+1][j-1];
							}
							else{ // 맨위 그외
								count = one[i][j-1] + one[i+1][j-1] + one[i+1][j] + 
									one[i+1][j+1] + one[i][j+1];
							}					
						}	
						//맨 밑
						else if(i == (row-1)){ //맨밑 맨앞
							if(j == 0){
								count = one[i-1][j] + one[i-1][j+1] + one[i][j+1];
							}
							else if (j == (col-1)){ // 맨밑 맨뒤
								count = one[i][j-1] + one[i-1][j-1] + one[i-1][j];
							}
							else { // 맨밑 그외
								count = one[i][j-1] + one[i-1][j-1] + one[i-1][j] + 
									one[i-1][j+1] + one[i][j+1];
							}
						}
						//맨위도 맨밑도 아닌 중간부분
						else{
							if(j == 0){
									count = one[i-1][j] + one[i-1][j+1]+ 
									one[i][j+1] + one[i+1][j+1] + one[i+1][j];
							}
							else if (j == (col-1)){
								count = one[i-1][j] + one[i-1][j-1] +
									one[i][j-1] + one[i+1][j-1]+ one[i+1][j];
							}
							else{
								count = one[i-1][j-1]+one[i-1][j]+one[i-1][j+1]+
								one[i+1][j-1]+one[i+1][j]+one[i+1][j+1]+
								one[i][j+1]+one[i][j-1];
							}
						}
						result[i][j] = Integer.toString(count);
					}
				}
			}	
			System.out.println("Field #"+field+":");
			for(int i = 0 ;i<row ; i++){
				for(int j = 0 ; j<col; j++){
					if(mine[i][j].equals("*"))
						result[i][j] = "*";
					System.out.print(result[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}		
	}
}