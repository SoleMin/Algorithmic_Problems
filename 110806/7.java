import java.util.Scanner;

public class Main {
	
	static int n, identifier, possible;
	static int[] automata=new int[8];
	static int[] precell=new int[32];
	static int[] cell;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		
		while(input.hasNext()) {
			identifier = input.nextInt();
			n=input.nextInt();
			String s=input.next();
			cell=new int[n];
			
			for(int i=0; i<n; i++) {
				cell[i]=s.charAt(i)-'0';
			}
			for(int i=0; i<8; i++) {
				automata[i]=identifier%2;
				identifier/=2;
			}
			
			possible=0;
			for(int i=0; i<8; i++) {
				if(automata[i]==cell[1]) {
					precell[0]=(i/4)%2;
					precell[1]=(i/2)%2;
					precell[2]=i%2;
					back(2);
					if(possible==1)
						break;
				}
			}
			
			if(possible==1)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}
		input.close();
	}
	
	public static void back(int a) {
		if(a==n-1) {
			if(automata[precell[a-1]*4+precell[a]*2+precell[0]] == cell[a] && automata[precell[a]*4+precell[0]*2+precell[1]]==cell[0])
				possible=1;
			return;
		}
		for(int i=precell[a-1]*4+precell[a]*2; i<=precell[a-1]*4+precell[a]*2+1; i++) {
			if(automata[i]==cell[a]) {
				precell[a+1]=i%2;
				back(a+1);
				if(possible==1)
					break;
			}
		}
	}

}