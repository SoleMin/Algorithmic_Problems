import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> card_num = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"));
		ArrayList<String> card_shape = new ArrayList<>(Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"));
		
		int T = scan.nextInt();
		int count_T = 0;
		
		scan.nextLine();
		scan.nextLine();
		
		while (count_T != T){
			count_T += 1;
			
			ArrayList<String> card_bundle = new ArrayList<>();
			for (int i = 0; i < card_shape.size(); i++){
				for (int j = 0; j < card_num.size(); j++){
					card_bundle.add(card_num.get(j) + " of " + card_shape.get(i));
				}
			}
						
			int shuffle_num = scan.nextInt();
			int count_sh = 0;
			ArrayList<ArrayList<Integer>> card_shuffle = new ArrayList<>();
			while (count_sh != shuffle_num) {
				ArrayList<Integer> shuffle_patterns = new ArrayList<>();
				count_sh += 1;
				
				for (int i = 0; i < 52; i++){
					shuffle_patterns.add(scan.nextInt());
				}
				card_shuffle.add(shuffle_patterns);
			}
			scan.nextLine();
			
			ArrayList<String> result = new ArrayList<>();
			
			while (scan.hasNextLine()){
				ArrayList<String> card_result = new ArrayList<>();
				String check = scan.nextLine();
				if (check.equals(""))
					break;
				else{
					int k = Integer.parseInt(check);
					for (int i = 0; i < 52; i++){
						card_result.add(card_bundle.get(card_shuffle.get(k-1).get(i)-1));
					}
					card_bundle = card_result;
				}
				result = card_result;
			}
			
			if (result.size() != 0){
				for (int i = 0; i < 52; i++){
					System.out.println(result.get(i));
				}
				System.out.println();
			}
			else {
				for (int i = 0; i < 52; i++){
					System.out.println(card_bundle.get(i));
				}
				System.out.println();
			}
	}
 }
}