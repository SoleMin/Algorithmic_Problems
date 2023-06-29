import java.io.*;
import java.util.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger start = new BigInteger(st.nextToken());
			BigInteger end = new BigInteger(st.nextToken());
			
			if(start.equals(new BigInteger("0")) && end.equals(new BigInteger("0"))) break;
			
			BigInteger lastLast = new BigInteger("1");
			BigInteger last = new BigInteger("1");
			int count=0;
			boolean in_boundary = false;
			
			while(true){
				BigInteger current = lastLast.add(last);
				if(!in_boundary && current.compareTo(start) >= 0){
					in_boundary = true;
					if(end.compareTo(current) >= 0) count++;
					else break;
				
				}
				else if(in_boundary){
					if(end.compareTo(current) >=0) count++;
					else break;
				}
				lastLast = last;
				last = current;
				
				
				
			}
			
			if(start.equals(new BigInteger("1"))){
				count++;
				if(end.equals(new BigInteger("1"))) count++;
			}
			sb.append(count).append('\n');
			
			
			
		}
		System.out.println(sb);
		
		
		
		
	}
}