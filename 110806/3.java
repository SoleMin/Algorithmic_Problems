import java.util.*;

class Main {
	static int n, id;
	static boolean reachable;
	static String[] automata, cell;
	static char[] precell = new char[32];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String[] strArr = input.nextLine().split(" ");
			id = Integer.parseInt(strArr[0]);
			n = Integer.parseInt(strArr[1]);
			automata = String.format("%8s", Integer.toBinaryString(id)).split("");
			cell = strArr[2].split("");
			
			reachable = false;
			for(int i = 0; i < 8; i++) {
				if(automata[i].equals(cell[1])) {
					precell[0] = (char)((i/4)%2 + '0');
					precell[1] = (char)((i/2)%2 + '0');
					precell[2] = (char)(i%2 + '0');
					back(2);
					if(reachable) break;
				}
			}
			
			if(reachable)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}
	}
	
	static void back(int a) {
		if(a == n - 1) {
			if(automata[(precell[a-1]-'0')*4 + (precell[a]-'0')*2 + (precell[0]-'0')].equals(cell[a]) &&
			automata[(precell[a]-'0')*4 + (precell[0]-'0')*2 + (precell[1]-'0')].equals(cell[0]))
				reachable = true;
			return;
		}
		
		int calc = (precell[a-1]-'0')*4 + (precell[a]-'0')*2;
		for(int i=calc; i <= calc+1; i++) {
			if(automata[i].equals(cell[a])) {
				precell[a+1] = (char)(i%2 + '0');
				back(a+1);
				if(reachable) break;
			}
		}
	}
}