import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		while(s!=null){
			if(s.charAt(0)=='0'){
				sb.append(Integer.parseInt(s.substring(2),16));
			}
			else{
				s = Integer.toHexString(Integer.parseInt(s));
				sb.append("0x").append(s.toUpperCase());
			}
			sb.append('\n');
			
			s = br.readLine();
			
		}
		System.out.println(sb);
		
		
		
	}
}