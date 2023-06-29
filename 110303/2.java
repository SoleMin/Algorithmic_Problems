import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			Map<Character, Integer> mapA = new HashMap<>();
			Map<Character, Integer> mapB = new HashMap<>();
			String a = input.nextLine();
			String b = input.nextLine();
			
			for(int i=0; i<a.length(); i++) {
				char ch = a.charAt(i);
				if(mapA.containsKey(ch)) {
					int temp = mapA.get(ch) + 1;
					mapA.put(ch, temp);
				}
				else
					mapA.put(ch, 1);
			}
			
			for(int i=0; i<b.length(); i++) {
				char ch = b.charAt(i);
				if(mapB.containsKey(ch)) {
					int temp = mapB.get(ch) + 1;
					mapB.put(ch, temp);
				}
				else
					mapB.put(ch, 1);
			}
			
			int count = 0;
			ArrayList<Character> list = new ArrayList<>();
			for(char c : mapA.keySet()) {
				if(mapB.containsKey(c)) {
					if(mapA.get(c) < mapB.get(c))
						count = mapA.get(c);
					else
						count = mapB.get(c);
					
					for(int i=0; i<count; i++) {
						list.add(c);
					}
				}
			}
			
			Collections.sort(list);
			
			for(char s : list)
				System.out.print(s);
			System.out.println();
		}
	}
}