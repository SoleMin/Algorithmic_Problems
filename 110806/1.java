import java.io.*;

public class Main {
	public static int n, identifier;
	public static boolean ispossible;
	public static final int MAXN = 32;
	public static char[] automata = new char[8];
	public static char[] precell = new char[MAXN];
	public static char[] cell = new char[MAXN + 1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		String line;
		while ((line = br.readLine()) != null) {
			identifier = Integer.parseInt(line.split(" ")[0]);
			n = Integer.parseInt(line.split(" ")[1]);
			cell = line.split(" ")[2].toCharArray();
			for (i = 0; i < n; i++) cell[i] -= '0';
			for (i = 0; i < 8; i++) {
				automata[i] = (char) (identifier % 2);
				identifier /= 2;
			}
			ispossible = false;
			for (i = 0; i < 8; i++) {
				if (automata[i] == cell[1]) {
					precell[0] = (char) ((i / 4) % 2);
					precell[1] = (char) ((i / 2) % 2);
					precell[2] = (char) (i % 2);
					backTrack(2);
					if (ispossible) break;
				}
			}
			if (ispossible)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}
	}

	public static void backTrack(int a) {
		int i;
		if (a == n - 1) {
			if (automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a] &&
				automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
				ispossible = true;
			return;
		}
		for (i = precell[a - 1] * 4 + precell[a] * 2; i <= precell[a - 1] * 4 + precell[a] * 2 + 1; i++) {
			if (automata[i] == cell[a]) {
				precell[a + 1] = (char) (i % 2);
				backTrack(a + 1);
				if (ispossible) break;
			}
		}
	}
}