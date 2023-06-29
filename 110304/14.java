import java.util.Scanner;
class Main {
	public static void check(String s, char[] key){
		String lazydog = "the quick brown fox jumps over the lazy dog";
		for(int i = 0; i < lazydog.length(); i++){
			if(s.charAt(i) == ' ')
				continue;
			key[s.charAt(i)-97] = lazydog.charAt(i);
		}
	}
	public static boolean islazydog(String s, char[] key){
		String lazydog = "the quick brown fox jumps over the lazy dog";
		if(s.length() != lazydog.length())
			return false;
		for(int i = 0; i < lazydog.length(); i++){
			if(lazydog.charAt(i) == ' ')
				if(s.charAt(i) != ' ')
					return false;
		}
		check(s, key);
		String result="";
		for(int i = 0; i < lazydog.length(); i++){
			if(s.charAt(i) == ' ')
				result += " ";
			else
				result += key[s.charAt(i)-97];
		}
		if(result.equals(lazydog))
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String lazydog = "the quick brown fox jumps over the lazy dog";
		int testcase = sc.nextInt();
		char[] key = new char[26];
		boolean isok = false;
		sc.nextLine();
		sc.nextLine();
		
		for(;testcase > 0; testcase--){
			key = new char[26];
			isok = false;
			String[] input = new String[100];
			int count=0;
			while(sc.hasNextLine()){
				input[count] = sc.nextLine();
				if(input[count].length() == 0)
					break;
				if(isok==false && islazydog(input[count], key)){
					isok = true;
				}
				count++;
			}
			
			if(isok)
				for(int i = 0; i < count; i++){
					for(int k = 0; k < input[i].length(); k++){
						if(input[i].charAt(k) == ' ')
							System.out.print(' ');
						else
							System.out.print(key[input[i].charAt(k)-97]);
					}
					System.out.println();
				}
			else
				System.out.println("No solution.");
			System.out.println();
		}
	}
}
	