import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		char[][] key={{'1','2','3','4','5','6','7','8','9','0','-','='},
					{'Q','W','E','R','T','Y','U','I','O','P','[',']','\\'},
					{'A','S','D','F','G','H','J','K','L',';','\''},
					{'Z','X','C','V','B','N','M',',','.','/'}};
		
		while(input.hasNext()){
			String s= input.nextLine();
			String result="";
			for(int i=0; i<s.length(); i++){
				char c=s.charAt(i);
				boolean stop=false;
				for(int j=0; j<4; j++){
					if(stop)
						break;
					for(int k=0; k<key[j].length; k++){
						if(c==key[j][k]){
							result+=key[j][k-1];
							stop=true;
							break;
						}
					}
				}
				if(!stop)
					result+=c;
			}
			System.out.println(result);
		}
		input.close();
	}
}