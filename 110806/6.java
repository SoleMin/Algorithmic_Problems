import java.io.*;
import java.util.Scanner;

class Main {
	static int n, identifier;
	static boolean possible;
	static char automata[], precell[], cell[];

	public static void back(int a) {
		if (a==n-1) {
			if (automata[precell[a-1]*4 + precell[a]*2 + precell[0]]==cell[a] && automata[precell[a]*4 + precell[0]*2 + precell[1]]==cell[0])
				possible = true;
			return;
		}
		for (int i=precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) {
			if (automata[i] == cell[a]) {
				precell[a+1] = (char)(i%2);
				back(a+1);
				if (possible)
					break;
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			automata = new char[8];
			precell = new char[32];
			cell = new char[33];
			String input = scanner.nextLine();
			String[] tmp = input.split(" ");
			identifier = Integer.parseInt(tmp[0]);
			n = Integer.parseInt(tmp[1]);
			cell = tmp[2].toCharArray();
			for (int i=0; i<n; i++)
				cell[i] -= '0';
			for (int i=0; i<8; i++) {
				automata[i] = (char) (identifier%2);
				identifier = identifier/2;
			}

			possible = false;
			for (int i=0; i<8; i++) {
				if (automata[i] == cell[1]) {
					precell[0] = (char)((i/4)%2);
					precell[1] = (char)((i/2)%2);
					precell[2] = (char)(i%2);
					back(2);
					if (possible)
						break;
				}
			}

			if (possible)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}
	}
}