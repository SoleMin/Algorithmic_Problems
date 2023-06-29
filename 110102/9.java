import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String[][]> list = new ArrayList<>();
		
		while(true) {
			int n = input.nextInt();
			int m = input.nextInt();
			
			if(n==0 && m==0) break;
			String[][] bomb = new String[n][m]; //mxn 지뢰밭
			
			String[] temp = input.nextLine().split("");
			for(int i = 0; i < n; i++) {
				temp = input.nextLine().split("");
				bomb[i] = temp;
			}
			list.add(sub(n, m, bomb));																
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Field #"+(i+1)+":");
			for(int a = 1; a < list.get(i).length; a++) {
				for(int b = 1; b < list.get(i)[a].length; b++) {
					System.out.print(list.get(i)[a][b]);
				}
				System.out.println();
			}
			System.out.println();
		}
}
	
	public static String[][] sub(int n, int m, String[][] bomb) {
		int a = n+2; 
		int b = m+2;
		int[][] field = new int[a][b];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(bomb[i][j].equals("*"))
					bomb[i][j] = Integer.toString(9); //임의의 수
				else if(bomb[i][j].equals("."))
					bomb[i][j] = Integer.toString(0);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				field[i+1][j+1] = Integer.valueOf(bomb[i][j]);
			}
		}
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(field[i][j] == 9) {
					if(field[i-1][j-1] != 9) //*이 들어있으면 (지뢰)
						field[i-1][j-1]++;
					if(field[i-1][j] != 9)
						field[i-1][j]++;
					if(field[i-1][j+1] != 9)
						field[i-1][j+1]++;
					
					if(field[i][j-1] != 9)
						field[i][j-1]++;
					if(field[i][j+1] != 9)
						field[i][j+1]++;
					
					if(field[i+1][j-1] != 9)
						field[i+1][j-1]++;
					if(field[i+1][j] != 9)
						field[i+1][j]++;
					if(field[i+1][j+1] != 9)
						field[i+1][j+1]++;
				}
			}
		}
		String[][] result = new String[a-1][b-1];
		for(int i = 1; i < a-1; i++) {
			for(int j = 1; j < b-1; j++) {
				if(field[i][j] == 9)
					result[i][j] = "*";
				else
					result[i][j] = Integer.toString(field[i][j]);
			}
		} 
		return result;
	}
	}