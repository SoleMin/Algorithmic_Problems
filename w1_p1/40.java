import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		while(s!=null){
			int countWord=0;
			int countChar=0;
		
			if(s.charAt(0)!=' ' && s.charAt(0)!='	'){
				countWord++;
				countChar++;
			}
			for(int i=1; i<s.length(); i++){
				if(s.charAt(i)!=' ' && s.charAt(i)!='	') {
					countChar++;
					if(s.charAt(i-1)==' ' || s.charAt(i-1)=='	') countWord++;
					
				}
				
			}
			
				
			
			sb.append(countChar).append(' ').append(countWord).append('\n');
			s = br.readLine();
			
			
			
		
			
			
		}
		System.out.println(sb);
		
		
	}
}