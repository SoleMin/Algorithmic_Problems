import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class mine {
	int n, m, field;
	char mine[][];
	
	public mine(int size1, int size2, int num) {
		mine = new char[100][100];
		field = num;
		n = size1;
		m = size2;
	}
	
	public void reset() {
		for(int i=1; i<=n; i++)
			for (int j=1; j<=m; j++)
				mine[i][j] = '0';
	}
	
	public void insert(int i, String bomb) {
		for (int l=1; l<=m; l++) {
			if (bomb.charAt(l-1)=='*') {
				for (int b=i-1; b<=i+1; b++)
					for (int v=l-1; v<=l+1; v++)
						if (mine[b][v]!='*')
							mine[b][v]++;
				mine[i][l]='*';
			}
		}
	}
	
	public void print() {
		System.out.println("Field #" + field + ":");
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++)
				System.out.print(mine[i][j]);
			System.out.println();
		}
		System.out.println();
	}
}

class Main {
	public static void main(String[] args) {
		int field = 0;
		Scanner scanner = new Scanner(System.in);
		List<mine> array = new ArrayList<>();
		int n, m;
		
		while(true) {
			String size = scanner.nextLine();
			String[] numbers = size.split(" ");
			n = Integer.parseInt(numbers[0]);
			m = Integer.parseInt(numbers[1]);
			if (n==0 && m==0)
				break;
			field++;
			mine minesweeper = new mine(n, m, field);
			array.add(minesweeper);
			minesweeper.reset();
			
			for (int k=1; k<=n; k++) {
				String bomb = scanner.nextLine();
				minesweeper.insert(k, bomb);
			}
		}
		for (int i=0; i<field; i++) {
			array.get(i).print();
		}
	}
}