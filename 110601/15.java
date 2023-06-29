import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	static final int MAX = 1000;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BigInteger[] fi =  new BigInteger[MAX];
		String[] s = new String[2];
		int count;
		fi[0]= new BigInteger("0");
		fi[1]= new BigInteger("1");
		fi[2]= new BigInteger("2");
		for(int i = 3; i < MAX; i++){
			fi[i] = fi[i-1].add(fi[i-2]);
		}
		while(true){
			s = input.nextLine().split(" ");
			if(s[0].equals("0") && s[1].equals("0"))
				break;
			BigInteger a = new BigInteger(s[0]);
			BigInteger b = new BigInteger(s[1]);
			count = 0;
			for(int i = 0; i < MAX; i++){
				if(a.compareTo(fi[i])<=0 && b.compareTo(fi[i])>=0)
					count++;
			}
			System.out.println(count);
		}
	}
}