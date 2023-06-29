import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		while(t-- >0){
			String str = scn.next();
			Pattern p = Pattern.compile("R[0-9]+C[0-9]+");
			Matcher m = p.matcher(str);
			if (m.matches()){
				String nums[] = str.split("[RC]");
				String first = nums[1];
				String second = nums[2];
				
				String ans = "";
				long num = Integer.parseInt(second);
				while(num >0){
					if (num % 26 > 0){
						ans += (char)(num%26+'A'-1);
						num/=26;
					} else {
						ans += 'Z';
						num/=26;
						num--;
					}
				}
				for (int i = ans.length()-1; i>=0;--i){
					System.out.print(ans.charAt(i));
				}
				
				System.out.println(first);
			} else {
				String first = str.split("[0-9]+")[0];
				String second = str.split("[A-Z]+")[1];
				System.out.print("R"+second);
				
				long num = 0, pow = 1;
				for (int i = first.length()-1; i>=0; --i){
					num += (long)(first.charAt(i)-'A'+1) * pow;
					pow*=26;
				}
				System.out.println("C"+num);
			}
			
		}
	}
}
