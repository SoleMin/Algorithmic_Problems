import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<>();
		String T = scan.nextLine();
		String P = scan.nextLine();
		int Tsize = T.length();
		int Psize = P.length();
		int[] table = setTable(P);
		
		int count = 0;
		int index = 0;		
		for(int i = 0 ; i < Tsize; i++){
			while(index > 0 && T.charAt(i) != P.charAt(index)){
				index = table[index -1];
			}
			if(T.charAt(i) == P.charAt(index)){
				if(index == Psize -1){
					num.add(i - index + 1);
					count++;
					index = table[index];
				} else {
					index += 1;
				}
			}
		}
		System.out.println(count);
		for(int n : num){
			System.out.print(n + " ");
		}
	}
	static int[] setTable(String P){
		int n = P.length();
		int[] table = new int[n];
		
		int index = 0;
		for(int i = 1; i < n ; i++ ){
			while(index > 0 && P.charAt(i) != P.charAt(index)){
				index = table[index -1];
			}
			if(P.charAt(i) == P.charAt(index)){
				index += 1;
				table[i] = index;
			}
		}
		return table;
	}
}