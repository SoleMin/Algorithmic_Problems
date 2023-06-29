import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String T = scanner.nextLine();
		String P = scanner.nextLine();
		
		
		int [] KMPtable = new int[P.length()];
		
		int j=0;
		for(int i=1; i<P.length(); i++){
			while(j>0 && P.charAt(i) != P.charAt(j)){
				j = KMPtable[j-1];
			}
			if(P.charAt(i) == P.charAt(j)){
				KMPtable[i] = ++j;
			}
		}
		//System.out.println(Arrays.toString(KMPtable));
		
		int count =0;
		String result="";
		j=0;
		
		for(int i=0; i<T.length();i++){
			while(j>0 && T.charAt(i)!= P.charAt(j)){
				j = KMPtable[j-1];
			}
			if(T.charAt(i)==P.charAt(j)){
				if(j == P.length()-1){
					count++;
					result+=(i-P.length()+2)+" ";
					j = KMPtable[j];
				}
				else{
					j++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(result);
		
	}
}