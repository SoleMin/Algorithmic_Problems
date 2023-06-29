import java.io.*;
import java.util.Scanner;
class Main {
	
	public static void makePi(int[] pi, String p){
		int j = 0;
		int i = 1;
		while(i < p.length()){
			if(p.charAt(j) == p.charAt(i)){
				if(i >= p.length())
					break;
				pi[i] = ++j;
				i++;
			}
			else{
				if(j-1 < 0)
					i++;
				else
					j = pi[j-1];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String p = sc.nextLine();
		int[] pi = new int[p.length()];
		makePi(pi, p);
		
		int i = 0, j = 0;
		int count = 0;
		String position = "";
		if(p.length() == 1){
			for(int k = 0; k < t.length(); k++){
				if(t.charAt(k) == p.charAt(0)){
					count++;
					position += k+1 + " ";
				}
			}
			System.out.println(count);
			System.out.println(position.strip());
		}
		else{
		while(i < t.length()){
			if(t.charAt(i) == p.charAt(j)){
				if(i >= t.length())
					break;
				if(j == p.length() - 1){
					count++;
					position += (i-p.length()+2)+" ";
					j = pi[j-1];
				}
				else{
					j++;
					i++;
				}
			}
			else{
				if(j-1 < 0)
					i++;
				else
					j = pi[j-1];
			}
		}
		System.out.println(count);
		System.out.println(position.strip());
		}
	}
}