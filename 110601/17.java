import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);	
		List<String> info = new ArrayList<>();
		
	
		while(true) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			BigInteger n1 = new BigInteger(s1);
			BigInteger n2 = new BigInteger(s2);

			
			if(n1.compareTo(n2) > 0) {
				info.add(n2.toString() + " " + n1.toString());
			}
			else {
				if(n1.equals(n2) && n1.toString().equals("0"))
					break;
				else
					info.add(n1.toString() + " " + n2.toString());
			}
		}
		
			
		for(String s : info) {	
			List<BigInteger> fl = new ArrayList<>();
					
			String[] num = s.split(" ");
			
			BigInteger n1 = new BigInteger(num[0]);
			BigInteger n2 = new BigInteger(num[1]);
			
			BigInteger f1 = new BigInteger("1");
			BigInteger f2 = new BigInteger("2");
	
			boolean ch = false;
			
			if(n1.compareTo(f1) <= 0) {
				if(n2.compareTo(f1) >= 0) {
					ch = true;
					fl.add(f1);
					if(n2.compareTo(f2) >= 0)
						fl.add(f2);
				}			
			}
			else {
				if(n1.compareTo(f2) <= 0) {
					if(n2.compareTo(f2) >= 0) {
						ch = true;
						fl.add(f2);
					}
				} 
			}
		

			while(true) {
				BigInteger n = new BigInteger(f1.add(f2).toString());
				f1 = new BigInteger(f2.toString());
				f2 = new BigInteger(n.toString());
				if(ch) {
					if(n.compareTo(n2) <= 0)
						fl.add(n);
					else
						break;				
				}
				else {
					if(n.compareTo(n1) >= 0) {
						if(n.compareTo(n2) <= 0) {
							ch = true;
							fl.add(n);
						}
						else
							break;
					}
				}
			}
			
			System.out.println(fl.size());
		}	
	}
}
