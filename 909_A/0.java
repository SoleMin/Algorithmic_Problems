import java.util.*;
 
public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		StringBuilder sb = new StringBuilder();
		sb.append(s1.charAt(0));
		for(int i=1;i<s1.length();i++){
		    if(s1.charAt(i)<s2.charAt(0)){
		        sb.append(s1.charAt(i));
		    }
		    else break;
		}
		sb.append(s2.charAt(0));
		System.out.println(sb.toString());
//		solution end \(^-^)/
//		                |
//		               / \
		}
	}