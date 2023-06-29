import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String key = "the quick brown fox jumps over the lazy dog";
		HashMap<Character, Character> map;
		String temp, check;
		ArrayList<String> str;
		int t, i;
		boolean possibility;
		
		t = in.nextInt();
		in.nextLine();
		in.nextLine();
		for(int test=0; test<t; test++){
			str = new ArrayList<>();
			map = new HashMap<>();
			while(in.hasNextLine()){
				temp = in.nextLine();
				if(temp.equals("")){
					break;
				}
				str.add(temp);
			}
			possibility = false;
			for(String s : str){
				if(key.length()==s.length()){
					for(i=0; i<s.length(); i++){
						map.put(s.charAt(i), key.charAt(i));
					}
					check = "";
					for(i=0; i<s.length(); i++){
						check += map.get(s.charAt(i));
					}
					if(check.equals(key)){
						possibility = true;
						break;
					}
					else{
						possibility = false;
						continue;
					}
				}
			}
			if(possibility){
				for(String s : str){
					for(i=0; i<s.length(); i++){
						System.out.print(map.get(s.charAt(i)));
					}
					System.out.println();
				}
			}
			else{
				System.out.println("No solution.");
			}
			if(t>0){
				System.out.println();
			}
		}
		in.close();
	}
}