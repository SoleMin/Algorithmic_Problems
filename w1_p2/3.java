import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		int num;
		String sNum;
		while(input.hasNextLine()){
			String s= input.nextLine();
			if(s.charAt(0)=='0'){//16진수일 때
				s= s.substring(2);
				num = Integer.parseInt(s,16);
				System.out.println(num);
			}else{//10진수일 때
				sNum=Integer.toHexString(Integer.parseInt(s));
				System.out.println("0x"+sNum.toUpperCase());
			}
		}
	}
}