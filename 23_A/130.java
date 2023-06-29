import java.util.Scanner;
public class x23A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//input+="3";
		int longest=0;
		if(input.length()==1){
			System.out.println(0);
			System.exit(0);
		}
		if(input.length()==2){
			if(input.charAt(0)==input.charAt(1)){
				System.out.println(1);
				System.exit(0);
			}
			else{
			System.out.println(0);
			System.exit(0);}
		}
		for(int a=0;a<input.length()-1;a++){
			for(int b=a+1;b<input.length();b++){
				for(int c=1;(c+b)<input.length()+1;c++){
				//	System.out.printf("%s %s %d\n", input.substring(a,a+c), input.substring(b,b+c), input.substring(a,a+c).compareTo(input.substring(b,b+c)));
					if(input.substring(a,a+c).compareTo(input.substring(b,b+c))==0)
					if(longest<c)longest=c;
				}
			}
		}
		System.out.println(longest);
		}
	}