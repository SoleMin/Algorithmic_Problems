import java.util.Scanner;
class Main {
	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s= sc.nextLine();
			
			if(s.charAt(0)=='0') {
				String s2= s.substring(2);
				System.out.println(Integer.parseInt(s2,16));
			}
			
			else {
				int n=Integer.parseInt(s);
				String hexString= Integer.toHexString(n);
				System.out.println("0x"+hexString.toUpperCase());
			}
		}
	}
}