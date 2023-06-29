import java.io.*;
class Main {
	static char[][] cArray = {{'1','2','3','4','5','6','7','8','9','0','-','='},
														{'Q','W','E','R','T','Y','U','I','O','P','[',']','\\'},
														{'A','S','D','F','G','H','J','K','L',';','\''},
														{'Z','X','C','V','B','N','M',',','.','/'}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		while(s!=null){
			for(int i=0; i<s.length(); i++){
				char c = s.charAt(i);
				if(c==' ') sb.append(' ');
				
				else{
					for(int j=0; j<4; j++){
						boolean tf = false;
						for(int k=0; k<cArray[j].length; k++){
							if(c==cArray[j][k]){
								sb.append(cArray[j][k-1]);
								tf = true;
								break;
							}
						}
						if(tf) break;
					}
				}
				
			}
			
			sb.append('\n');
			s = br.readLine();
		}
		System.out.println(sb);
		
		
	}
}