
import java.util.Scanner;
class Main {
	
	public static String change(String str){
		String keybord = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		StringBuilder result = new StringBuilder();
		String temp = new String(str.toString()); //Stringbuilder에 있는 내용을 String으로 복사
		char []tm = temp.toCharArray();
		
		
		for(int i = 0; i < tm.length; i++){
		 // A Q Z \n 스페이스바 총 5개가 있다면 넘기고 그게 아니라면 전으로 바꾸기
		
			if(tm[i] =='A'||tm[i] =='Q'|| tm[i] =='Z'|| tm[i] =='`'||tm[i] == '\n'||tm[i] == ' '){
				result.append(tm[i]);
				continue;
			}
			else{
				String c = Character.toString(tm[i]);
				int p = keybord.indexOf(c)-1;
				result.append(keybord.charAt(p));
			}
		}
		temp = new String(result.toString());
		return temp;
	}
	
	public static void main(String[] args)  {
		Scanner input1 = new Scanner(System.in);
	
		//입력값을 전부 저장 시키기
		while(input1.hasNextLine()){
			String s = input1.nextLine();
			StringBuilder output = new StringBuilder(change(s));
			System.out.println(output);
		}
		
		input1.close();
	}
}