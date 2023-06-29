import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		
		Map<Integer,Integer> index = new HashMap<>();
		List<Map<Integer,Integer>> method = new ArrayList<>();
		for(int i = 0; i < testcase; i++) {
			int method_n = Integer.parseInt(sc.nextLine());
			for(int j = 0; j < method_n; j ++) {
				String card_s = sc.nextLine();
				String[] card_array = card_s.split(" ");
				
				for(int idx = 0; idx < 52; idx++) {
					if( Integer.parseInt(card_array[idx]) != (idx+1) )
						if(!index.containsKey(Integer.parseInt(card_array[idx]) - 1))
							index.put(idx,Integer.parseInt(card_array[idx]) -1 );
				}
				method.add(new HashMap<>(index));
				index.clear();
				
			}
			List<Integer> card = new LinkedList<>();
			for(int j = 1; j < 53; j++)
				card.add(Integer.valueOf(j));
			while(sc.hasNextLine()) {
				String temp = sc.nextLine();
				if(temp.isEmpty())
					break;
				for(Map.Entry<Integer,Integer> entry : 
						method.get(Integer.parseInt(temp) - 1).entrySet()) {
					int key_idx = entry.getKey();
					int value_idx = entry.getValue();
					int tem = card.get(value_idx);
					card.set(value_idx,card.get(key_idx));
					card.set(key_idx,Integer.valueOf(tem));
				}	
			}
			method.clear();
			card.stream().forEach( b -> {
				int b_as_int = b.intValue(); 
				float divide = b_as_int/13.0f;
				int remain = b_as_int % 13;
				switch(remain) {
					case 1 : System.out.print("2 of "); break;
					case 2 : System.out.print("3 of "); break;
					case 3 : System.out.print("4 of "); break;
					case 4 : System.out.print("5 of "); break;
					case 5 : System.out.print("6 of "); break;
					case 6 : System.out.print("7 of "); break;
					case 7 : System.out.print("8 of "); break;
					case 8 : System.out.print("9 of "); break;
					case 9 : System.out.print("10 of "); break;
					case 10 : System.out.print("Jack of "); break;
					case 11 : System.out.print("Queen of "); break;
					case 12 : System.out.print("King of "); break;
					case 0 : System.out.print("Ace of "); break;
					default : System.out.print("Error"); 
				}
				if( divide > 0 && divide <= 1 ) 
					System.out.println("Clubs");
				else if( divide > 1 && divide <= 2 )
					System.out.println("Diamonds");
				else if( divide > 2 && divide <= 3 )
					System.out.println("Hearts");
				else if( divide > 3 && divide <= 4 ) 
					System.out.println("Spades");
				else 
					System.out.println("Error");
			});
			System.out.println();
			card.clear();
		}
			
			
			
		
		
	}

}
