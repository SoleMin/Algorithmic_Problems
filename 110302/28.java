import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		String input = "";
		
		for (int testCase = 0; testCase < testCaseCount; testCase++) {
			br.readLine();
			input = br.readLine();
			
			int row = Integer.parseInt(input.split(" ")[0]);
			int col = Integer.parseInt(input.split(" ")[1]);
			
			char table[][] = new char[row][col];
			
			if (testCase != 0) {
				System.out.println();
			}
			
			for (int i = 0; i < row; i++) {
				String line = br.readLine().toLowerCase();
				for (int j = 0; j < col; j++) {
					table[i][j] = line.charAt(j);
				}
			}
			
			int wordCount = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < wordCount; i++) {
				String word = br.readLine().toLowerCase();
				boolean found = false;
				
				String coordinate = "";
				
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < col; c++) {
						if (table[r][c] == word.charAt(0)) {
							int wordLength = word.length();
							boolean upSize = false;
							boolean downSize = false;
							boolean leftSize = false;
							boolean rightSize = false;
							
							if (r >= wordLength -1) {
								upSize = true;
							}
							if (row - r >= wordLength) {
								downSize = true;
							}
							if (c >= wordLength - 1) {
								leftSize = true;
							}
							if (col - c >= wordLength) {
								rightSize = true;
							}
							
							if (upSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r - k][c]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (downSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r + k][c]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (leftSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r][c - k]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (rightSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r][c + k]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (upSize && leftSize && !found) {
								boolean check = true;
								for (int k = 0; k < wordLength; k++) {
									if (word.charAt(k) != table[r - k][c - k]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (upSize && rightSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r - k][c + k]) {
										check =  false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (downSize && leftSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r + k][c - k]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
							
							if (downSize && rightSize && !found) {
								boolean check = true;
								for (int k = 1; k < wordLength; k++) {
									if (word.charAt(k) != table[r + k][c + k]) {
										check = false;
										break;
									}
								}
								if (check) {
									found = true;
									coordinate = (r + 1) + " " + (c + 1);
								}
							}
						}
					}
				}
				System.out.println(coordinate);
			}
		} 
	}
}