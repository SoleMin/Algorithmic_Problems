import java.io.*;
import java.util.Scanner;

public class Main {
	final static int MAXN = 32;
	static int n, identifier;
	static boolean possible;
	static char[] automata = new char[8];
	static char[] precell = new char[MAXN];
	static char[] cell = new char[MAXN + 1];
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		while(input.hasNextLine()) {
			String s = input.nextLine();
			if(s.equals(""))
				break;
			String[] split = s.split(" ");
			identifier = Integer.parseInt(split[0]);
			n = Integer.parseInt(split[1]);
			for(int i = 0; i < split[2].length(); i++)
				cell[i] = split[2].charAt(i);

			for (int i = 0; i < n; i++) cell[i] -= '0';
			for (int i = 0; i < 8; i++) {
				automata[i] = (char) (identifier%2);
				identifier /= 2;
			}
			possible = false;
			for (int i = 0; i < 8; i++) {
				if (automata[i] == cell[1]) {
					precell[0] = (char) ((i/4)%2);
					precell[1] = (char) ((i/2)%2);
					precell[2] = (char) (i%2);
					back(2);
					if (possible) break;
				}
			}
			if (possible)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}


		input.close();
	}
	static void back(int a) {
		if (a == n - 1) {
			if (automata[precell[a-1]*4 + precell[a]*2 + precell[0]] == cell[a] &&
					automata[precell[a]*4 + precell[0]*2 + precell[1]] == cell[0])
				possible = true;
			return;
		}
		for (int i = precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) {
			if (automata[i] == cell[a]) {
				precell[a+1] = (char) (i % 2);
				back(a + 1);
				if (possible) 
					break;
			}
		}

	}

}