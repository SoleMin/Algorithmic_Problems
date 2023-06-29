import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
	static boolean possible;
	static int[] precell;
	static int[] automata;
	static int n;
	static int[] cell;
		
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String[] s = input.nextLine().split(" ");
			int num = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			automata = new int[8];
			precell = new int[32];
			cell = Stream.of(s[2].split("")).mapToInt(Integer::parseInt).toArray();
			
				for (int j = 0; j < 8; j++) {
					automata[j] = num%2;
					num /= 2;
				}
			
				possible = false;
				for (int h = 0; h < 8; h++) {
					if (automata[h] == cell[1]) {
						precell[0] = (h/4)%2;
						precell[1] = (h/2)%2;
						precell[2] = h%2;
						back(2);
						if (possible) break;
					}
				}
				if (possible == true)
					System.out.println("REACHABLE");
				else
					System.out.println("GARDEN OF EDEN");
		}
	}


public static void back(int a) {
	int i;
	if (a == n - 1) {
		if (automata[precell[a-1]*4 + precell[a]*2 + precell[0]] == cell[a] &&
		automata[precell[a]*4 + precell[0]*2 + precell[1]] == cell[0])
			possible = true;
			return;
	}
	for (i = precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) {
		if (automata[i] == cell[a]) {
			precell[a+1] = i % 2;
			back(a + 1);
			if (possible == true) break;
			}
		}
	}
}