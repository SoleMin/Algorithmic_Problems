import java.util.ArrayList;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String string="the quick brown fox jumps over the lazy dog";
		int total1=string.length();
		string=string.replace(" ","");
		int total2=string.length();
		
		int t=input.nextInt();
		input.nextLine();
		input.nextLine();
		for(int i=0; i<t; i++){
			char[] al=new char[26];
			ArrayList<String> array=new ArrayList<String>();
			boolean no=false;
			while(input.hasNext()){
				String s=input.nextLine();
				if(s.equals(""))
				   break;
				
				array.add(s);
				
				int to1=s.length();
				s=s.replace(" ","");
				int to2=s.length();
				
				if(to1==total1 && to2==total2) {
					for(int j=0; j<s.length(); j++){
						al[s.charAt(j)-97]=string.charAt(j);
					}
				}
			}
			for(int k=0; k<26; k++){
				if(al[k]==Character.MIN_VALUE){
					no=true;
					break;
				}
			}
			
			if(no){
				System.out.println("No solution.");
			}
			else {
				for(int x=0; x<array.size(); x++){
					for(int y=0; y<array.get(x).length(); y++){
						char c=array.get(x).charAt(y);
						if(c==' ')
							System.out.print(" ");
						else
							System.out.print(al[c-97]);
					}
					System.out.println();
				}
			}
			System.out.println();
		}
		
		input.close();
	}
}