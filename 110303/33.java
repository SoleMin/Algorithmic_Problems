import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		while(true){
			StringBuilder tmp = new StringBuilder();
			StringBuilder s1,s2;
			try{
				s1 = new StringBuilder(br.readLine());
				s2 = new StringBuilder(br.readLine());
			}
			catch(NullPointerException e){
				break;
			}
			
			for(int i=0; i<s1.length(); i++){
				for(int j=0; j<s2.length(); j++){
					if(s1.charAt(i)==s2.charAt(j)){
						tmp.append(s1.charAt(i));
						s1.delete(i, i+1);
						s2.delete(j, j+1);
						i--;
						break;
					}
				}
			}
			
			char[] cArray = tmp.toString().toCharArray();
			Arrays.sort(cArray);
			for(int i=0; i<cArray.length; i++){
				result.append(cArray[i]);
			}
			result.append('\n');
			
			
			
		}
		System.out.println(result);
		
		
		
		
		
	}
}