import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public Integer[][] setMine(boolean[][] matrix) {
		
		Integer[][] result = new Integer[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int sum = 0;
				
				for (int x = i - 1; x <= i + 1; x++) {
					for (int y = j - 1; y <= j + 1; y++) {
						
						if (x > -1 && y > -1 && x < matrix.length && y < matrix[0].length) {
							if (matrix[x][y] == true)
								sum = sum + 1;
						}
					}
				}
				
				if (matrix[i][j] == true)
					result[i][j] = -1; // -1을 지뢰로 마크 
				else
					result[i][j] = sum; // 힌트 세팅 
			}
		}
		
		return result;
	}
	
	
	
	
	public void printField(Integer[][] field) {
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j] == -1 ? "*" : field[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		List<Integer[][]> result = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		Main ms = new Main();
		
		while (true) {
			int m = input.nextInt();
			int n = input.nextInt();
			
			input.nextLine();
			
			if (m == 0 && n == 0)
				break;
			
			boolean[][] matrix = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				String line = input.nextLine();
				
				for (int j = 0; j < n; j++) {
					char ch = line.charAt(j);
					matrix[i][j] = ch == '*' ? true : false;
				}
			}
			
			result.add(ms.setMine(matrix));
			
		}
		
		
		// 결과 출력
		for (int i = 0; i < result.size(); i++) {
			Integer[][] field = result.get(i);
			System.out.println(String.format("Field #%d:", i+1));
			
			ms.printField(field);
			
			if (i+1 < result.size()) // 마지막 공백라인 제외
				System.out.println();
		}
		
		input.close();
	
	}
}