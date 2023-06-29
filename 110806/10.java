import java.util.Scanner;

class Main {
	static int[] automata, precell, cell;
	static int n, identifier;
	static boolean possible;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String temp;
		int i;

		automata = new int[8];
		precell = new int[32];
		cell = new int[33];
		
	
		
		while(input.hasNext()) {
			identifier = input.nextInt();
			n = input.nextInt();
			temp = input.next();


			for(i=0; i < n; i++) 
				cell[i] = (int)(temp.charAt(i) - 48);
			for(i=0; i < 8; i++) {
				automata[i] = identifier % 2;
				identifier /= 2;
			}

			possible = false;
			for(i=0; i < 8; i++) {
				if(automata[i] == cell[1]) {
					precell[0] = (i / 4) % 2;
					precell[1] = (i / 2) % 2;
					precell[2] = i % 2;
					back(2);
					if(possible) break;
				}
			}

			if(possible)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
			
			
		}
		input.close();
	}

	static void back(int a) {
		int i;
		if(a == n - 1) {
			if(automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a] &&
				automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
				possible = true;
			return;
		}
		for(i=precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) 
			if(automata[i] == cell[a]) {
				precell[a+1] = i % 2;
				back(a + 1);
				if(possible) break;
			}
	}
}