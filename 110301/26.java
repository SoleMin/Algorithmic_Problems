import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		int ASCII = 39;
		int[] char_arr = {59,0,0,0,0,77,48,44,46,57,96,49,50,51,52,53,54,55,56,0,76,0,45,0,0,0,0,86,88,83,87,68,70,71,85,72,74,75,78,66,73,79,0,69,65,82,89,67,81,90,84,0,80,93,91};
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		while(str.length() != 0){
			String convert_s = "";
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) != ' '){
					convert_s += (char)char_arr[(int)str.charAt(i) - ASCII];
				}
				else convert_s += ' ';
			}
			System.out.println(convert_s);
			if(in.hasNextLine()) str = in.nextLine();
			else break;	 
		}
	}
}