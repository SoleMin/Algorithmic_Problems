import java.util.Scanner;

public class _0555Antipalindrome {
	
	
	static boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	static int largestSubString(String str) {
	//	System.out.println(str);
		if(!isPalindrome(str)) {
			return str.length();
		}
		if(str.length()==1) {
			return 0;
		}
		
		int input1=largestSubString(str.substring(1));
		int input2=largestSubString(str.substring(0,str.length()-1));
		return Math.max(input1, input2);
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String temp=s.replaceAll(s.charAt(0)+"","");
		if(temp.length()==0) {
			System.out.println(0);
		}
		else {
		System.out.println(largestSubString(s));
		}
		
	}

}
