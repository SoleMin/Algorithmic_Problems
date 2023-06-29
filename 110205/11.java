import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		int testcase, n, i, k, j;
		
		int[] set1 = new int[53];
		int[] set2 = new int[53];
		String[] result = new String[53];
		String w;
		Scanner scan = new Scanner(System.in);
		testcase = scan.nextInt();
		
		for(k=0; k<testcase; k++) {
			n = scan.nextInt();
			
			int[][] shuffle = new int[101][53];
			
			for(i=1; i<=n; i++) {
				for(j=1; j<=52; j++) {
					shuffle[i][j] = scan.nextInt();
				}
			}
			
			for(i=1; i<=52; i++) {
				set1[i] = i;
			}
			scan.nextLine();
			
			while(scan.hasNextLine()) {
				w = scan.nextLine();
				if(w.equals("")) {
					break;
				}
				else {
					int q = Integer.parseInt(w);
					for(i=1; i<=52; i++) {
						set2[i] = set1[i];
					}
					for(j=1; j<=52; j++) {
						set1[j] = set2[shuffle[q][j]];
					}
				}
			}
			if(k>0) {
				System.out.println();
			}
			
			for(i=1; i<=52; i++) {
				int value = (set1[i]-1)%13;
				int pattern = (set1[i]-1)/13;
				
				switch(value) {
					case 9: result[i] = "Jack"; break;
					case 10: result[i] = "Queen"; break;
					case 11: result[i] = "King"; break;
					case 12: result[i] = "Ace"; break;
					default: result[i] = Integer.toString(value+2); break;
				}
				result[i] += " of ";
				switch(pattern) {
					case 0: result[i] += "Clubs"; break;
					case 1: result[i] += "Diamonds"; break;
					case 2: result[i] += "Hearts"; break;
					case 3: result[i] += "Spades"; break;
				}
			}
			for(i = 1; i<=52; i++) {
				System.out.println(result[i]);
			}
		}
	}
}