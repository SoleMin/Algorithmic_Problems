import java.util.*;

public class Main{
	static int row;
	static int col;
	static String[] line;
	static int waldorfs;
	static boolean goUp;
	static boolean goLeft;
	static boolean goRight;
	static boolean goDown;
	static int startRow = -1;
	static int startCol = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			sc.nextLine();
		row = sc.nextInt();
		col = sc.nextInt();
		
		sc.nextLine();
		
		line = new String[row];
		for (int j = 0; j < row; j++) {
			line[j] = sc.nextLine().toLowerCase();
		}
		waldorfs = sc.nextInt();
		
		sc.nextLine();
		
		for (int j = 0; j < waldorfs; j++) {
			String name = sc.nextLine().toLowerCase();
			startRow = -1;
			startCol = -1;
			
			checkWald(name);
			
			System.out.println(startRow + " " + startCol);
			
		}
		System.out.println("");
	}
}

	public static void checkWald(String name) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				 //만약 waldorf의 첫글자('w')와 일치하는 인덱스를 찾았다면 거기서부터 8방향 탐색 시작한다.
				if (line[i].charAt(j) == name.charAt(0)) {
					//waldorf의 길이 저장
					int length = name.length();
					goUp = (i + 1) >= length;
					goLeft = (j + 1) >= length;
					goRight = (col - j) >= length;
					goDown = (row - i) >= length;
					//오른쪽으로 탐색
					if (goUp) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i - k].charAt(j)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//왼쪽으로 탐색
					if (goLeft) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i].charAt(j - k)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//오른쪽 탐색
					if (goRight) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i].charAt(j + k)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//아래 탐색
					if (goDown) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i + k].charAt(j)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//북서쪽 탐색
					if (goUp && goLeft) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i - k].charAt(j - k)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//북동쪽 탐색
					if (goUp && goRight) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i - k].charAt(j + k)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					
					//남서쪽 탐색
					if (goDown && goLeft) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i + k].charAt(j - k)) {
								exist = false;
								break;
							}
						}
						if (exist){
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
					//남동쪽 탐색
					if (goDown && goRight) {
						boolean exist = true;
						for (int k = 0; k < length; k++) {
							if (name.charAt(k) != line[i + k].charAt(j + k)) {
								exist = false;
								break;
							}
						}
						if (exist) {
							startRow = i + 1;
							startCol = j + 1;
							break;
						}
					}
				}
			}
			if (startRow != -1 && startCol != -1) break;
		}
	}
}















