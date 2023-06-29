import java.io.*;
import java.util.Scanner;

class Main {
	
	static int identifier;
	static int n;
	static int possible; // 1을 true로 햇음...
	static int[] automata = new int[8];
	static int[] precell = new int[32];
	static int[] cell = new int[33];
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int i;
		while(sc.hasNextLine()){
			String input = sc.nextLine();
			
			String[] in = input.split(" ");
			
			identifier = Integer.parseInt(in[0]);
			n = Integer.parseInt(in[1]);
			String cell_ = in[2];
			
			for(int k=0; k<cell_.length();k++){
				//cell[k] = Integer.parseInt(cell_.charAt(k));
				cell[k] = Integer.parseInt(Character.toString(cell_.charAt(k)));
			} //////// 입력 완....
			
			//for(i = 0; i<n; i++){
				//cell[i] -= '0';
				//System.out.println("cell[" + i + "] = " + cell[i]);
			//}
			for(i = 0; i<8; i++){
				//automata[i] = (char)(identifier%2 + '0');
				automata[i] = identifier%2;
				//System.out.println("automata[i] = " + automata[i]);
				identifier /= 2;
			}
			
			possible = 0;
			for(i=0; i<8; i++){
				if(automata[i]==cell[1]){
					//System.out.println("automata[i]==cell[1] 이빈다..");
					//precell[0] = (char)((i/4)%2 + '0');
					precell[0] = (i/4)%2 ;
					//System.out.println("precell[0] = " + precell[0]);
					//precell[1] = (char)((i/2)%2 + '0');
					precell[1] = (i/2)%2;
					//precell[2] = (char)(i%2 + '0');
					precell[2] = i%2;
					back(2);
					if(possible == 1) break;
				}
			}
			
			if(possible == 1)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
			
			
			
		}//// 케이스 담당 while
	}

	public static void back(int a) throws Exception {
		int i;
		if(a == n-1){
			if(automata[precell[a-1]*4 + precell[a]*2 + precell[0]] == cell[a] &&
				automata[precell[a]*4 + precell[0]*2 + precell[1]] == cell[0])
				possible = 1;
			return;
		}
		for(i = precell[a-1]*4 + precell[a]*2; i<= precell[a-1]*4 + precell[a]*2 + 1; i++){
			if(automata[i] == cell[a]){
				//precell[a+1] = (char)(i%2 + '0');
				precell[a+1] = i%2;
				back(a+1);
				if (possible == 1) break;
			}
		}
	}
	
		
}