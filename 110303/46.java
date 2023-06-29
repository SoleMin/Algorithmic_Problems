import java.util.Arrays;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			String a= sc.next();
			String b= sc.next();
			int bLength=b.length();
			int count=0;
			
			int maxLength= a.length()>b.length() ? a.length() : b.length();
			char []ans= new char[maxLength];
			
			for(int i=0; i<a.length(); i++) {
				for(int j=0; j<bLength; j++) {
					if(a.charAt(i)==b.charAt(j)) {
						char e= b.charAt(j);
						String equal= String.valueOf(e);
						
						ans[count]=b.charAt(j);
						count++;
						
						b= b.replaceFirst(equal, "");
						bLength--;
						
						break;
					}
				}
			}
		  Arrays.sort(ans);
			String ANS= String.valueOf(ans);
			System.out.println(ANS.trim());
		}
	}
}