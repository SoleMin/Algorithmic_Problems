import java.util.Scanner;


public class d_169 {
public static void main(String[] args) {
	Scanner  sc = new Scanner(System.in);
	long x=sc.nextLong();
	long y=sc.nextLong();
	String s=Long.toBinaryString(x);
	String p=Long.toBinaryString(y);
	int id=p.length()-s.length();
	for (int i =1; i <=id; i++) {
		s="0"+s;
	}
	if(x==y){
		System.out.println(0);
		return;
	}
	for (int i = 0; i <p.length(); i++) {
		if(s.charAt(i)!=p.charAt(i)){
			System.out.println((long)Math.pow(2, s.length()-i)-1);
			return;
	}
}
}
}
