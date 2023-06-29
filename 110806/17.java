import java.io.*;
import java.util.Scanner;
class Main {
	
	static int n, id, possible;
	static char[] automata = new char[8];
	static char[] precell = new char[32];
	static char[] cell = new char[33];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){	
			id = input.nextInt();
			n = input.nextInt();
			String temp = input.next();
			
			cell = temp.toCharArray();
			
			for (int i = 0; i < n; i++) cell[i] -= '0';
			for (int i = 0; i<8; i++){
				automata[i] = (char)(id%2);
				id /= 2;
			}
				// 오토마타 번호에 의해 결정되는 부분
				//System.out.println("오토마타 : "+Arrays.toString(automata));
				// 인풋 맨 마지막에 의해 결정되는 부분. 프리셀을 오토마타로 바꿨을때 셀이 된다 > reachable!
				//System.out.println("셀: "+Arrays.toString(cell));

			possible = 0;
			for(int i = 0; i<8; i++){
				if(automata[i] == cell[1]){
					//System.out.println("i = " + i);
					precell[0] = (char)((i/4) %2);
					precell[1] = (char)((i/2) %2);
					precell[2] = (char)(i%2);
					back(2);
						//일단 첫 자리가 일치하는 것부터 찾는다.
						//System.out.println("프리셀: "+ Arrays.toString(precell));
					if (possible == 1) break;
				}
			}
			if (possible == 1)
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
		}
	}
	
	public static void back(int a){
		if (a == n - 1) {
			if (automata[precell[a-1]*4 + precell[a]*2 + precell[0]] == cell[a] &&
automata[precell[a]*4 + precell[0]*2 + precell[1]] == cell[0])
				possible = 1;
			return;
		}
		for (int i = precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) {
			if (automata[i] == cell[a]) {
				precell[a+1] = (char)(i % 2);
				back(a + 1);
				if (possible == 1) break;
			}
		}		
	}	
}