import java.io.*;
import java.util.*;

public class Main {
	static int MAXN = 32;
	static int n, identifier, possible;
	static int [] automata = new int [8];
	static int [] precell = new int [MAXN];
	static char [] cell = new char [MAXN + 1];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		while (sc.hasNextInt()) {
			identifier = id;
			n = sc.nextInt();
			cell = sc.next().toCharArray();
			for (int i = 0; i < n; i ++) cell[i] -= '0';
			for (int i = 0; i < 8; i ++) {
				automata[i] = identifier % 2;
				identifier = identifier / 2;
			}
			
			possible = 0;
			for (int i = 0; i < 8; i ++) {
				if (automata[i] == cell[1]) {
					precell[0] = (i/4) % 2;
					precell[1] = (i/2) % 2;
					precell[2] = i % 2;
					back(2);
					if(possible == 1) break;
				}
			}
			
			if (possible == 1) {
				System.out.println("REACHABLE");
			} else
				System.out.println("GARDEN OF EDEN");
			
			if (sc.hasNextInt()) id = sc.nextInt();
		}
	}
	
	public static void back (int a) {
		if (a == n -1) {
			if (automata[precell[a -1] * 4 + precell[a] * 2 + precell[0]] == cell[a] &&
					automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0]) {
				possible = 1;
			}
			return;
		}
		
		for (int i = precell[a-1] * 4 + precell[a] * 2; i <= precell[a-1] * 4 + precell[a] * 2 + 1; i ++) {
			if (automata[i] == cell[a]) {
				precell[a +1] = i % 2;
				back(a + 1);
				if (possible == 1) break;
			}
		}
	}
}