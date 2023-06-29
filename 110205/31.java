import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		input.nextLine();
		String buf;
		String [] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String [] pattern = {"Clubs", "Diamonds", "Hearts", "Spades"};
		int [] answer = new int [53];
		int [][] swaps;
		int [] array = new int[53];
		input.nextLine();
		for(int t=0; t<testcase; t++){ 
			for(int i=1; i<53; i++){
				answer[i] = i;
			}
			int shuffle_num = input.nextInt();
			input.nextLine();
			swaps = new int [shuffle_num][53];
			for(int i=0; i<shuffle_num; i++){
				buf = input.nextLine();
				String[] data = buf.split(" ");
				for(int j=0; j<52; j++){
					swaps[i][j+1] = Integer.parseInt(data[j]);
				}
			}
			
			while(true){
				if (!input.hasNextLine())
					break;
				if ((buf = input.nextLine()).length() != 0){
					int swap_algo = Integer.parseInt(buf) - 1;
					for (int j = 1; j<= 52; j++)
						array[j] = answer[j];
					for(int j = 1; j<= 52; j++){
						answer[j] = array[swaps[swap_algo][j]];
					}
				}
				else{
					break;
				}
			}
			for(int i=1; i<53; i++){
				int value_num = (answer[i]-1) % 13;
				int pattern_num = (answer[i]-1) / 13;
				System.out.println(value[value_num] + " of " + pattern[pattern_num]);
			}
			System.out.println();
		}
	}
}