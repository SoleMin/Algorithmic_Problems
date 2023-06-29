import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static int convert(String hands) {
		char num = hands.charAt(0);
		char pattern = hands.charAt(1);
		int hands_num;
		switch (num) {
			case 'T': hands_num = 100;
				break;
			case 'J': hands_num = 110;
				break;
			case 'Q': hands_num = 120;
				break;
			case 'K': hands_num = 130;
				break;
			case 'A': hands_num = 140;
				break;
			default: hands_num = Integer.parseInt(String.valueOf(num)) * 10;
				break;
		}
		switch (pattern) {
			case 'S': hands_num += 1;
				break;
			case 'D': hands_num += 2;
				break;
			case 'H': hands_num += 3;
				break;
			case 'C': hands_num += 4;
				break;
		}
		return hands_num;
	}
	
	public static int get_num(int number) {
		return number / 10;
	}
	
	public static int get_pattern(int number) {
		return number % 10;
	}
	
	public static ArrayList<Integer> get_hand_value(ArrayList<Integer> hand) {
		int grade;
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> card_num = new ArrayList<>();
		ArrayList<Integer> card_pattern = new ArrayList<>();
		
		Collections.sort(hand);
		
		for (int i = 0; i < 5; i++) {
			card_num.add(get_num(hand.get(i)));
			card_pattern.add(get_pattern(hand.get(i)));
		}
		
		if ((card_pattern.get(0) == card_pattern.get(1)) && (card_num.get(1) == card_num.get(0) + 1) && (card_pattern.get(0) == card_pattern.get(2)) && (card_num.get(2) == card_num.get(0) + 2) && (card_pattern.get(0) == card_pattern.get(3)) && (card_num.get(3) == card_num.get(0) + 3) && (card_pattern.get(0) == card_pattern.get(4)) && (card_num.get(4) == card_num.get(0) + 4)) {
			grade = 9;
			result.add(grade);
			result.add(card_num.get(4));
		} else if ((card_num.get(0) == card_num.get(3)) || (card_num.get(1) == card_num.get(4))) {
			grade = 8;
			result.add(grade);
			result.add(card_num.get(1));
		} else if (((card_num.get(0) == card_num.get(1)) && ((card_num.get(2) == card_num.get(4)))) || ((card_num.get(0) == card_num.get(2)) && (card_num.get(3) == card_num.get(4)))) {
			grade = 7;
			result.add(grade);
			result.add(card_num.get(2));
		} else if (card_pattern.get(0) == card_pattern.get(4)) {
			grade = 6;
			result.add(grade);
			result.add(card_num.get(4));
			result.add(card_num.get(3));
			result.add(card_num.get(2));
			result.add(card_num.get(1));
			result.add(card_num.get(0));
		} else if ((card_num.get(1) == card_num.get(0) + 1) && (card_num.get(2) == card_num.get(0) + 2) && (card_num.get(3) == card_num.get(0) + 3) && (card_num.get(4) == card_num.get(0) + 4)) {
			grade = 5;
			result.add(grade);
			result.add(card_num.get(4));
		} else if ((card_num.get(0) == card_num.get(2)) || (card_num.get(1) == card_num.get(3)) || (card_num.get(2) == card_num.get(4))) {
			grade = 4;
			result.add(grade);
			result.add(card_num.get(2));
		} else if ((card_num.get(0) == card_num.get(1)) && (card_num.get(2) == card_num.get(3))) {
			grade = 3;
			result.add(grade);
			result.add(card_num.get(2));
			result.add(card_num.get(0));
			result.add(card_num.get(4));
		} else if ((card_num.get(0) == card_num.get(1)) && (card_num.get(3) == card_num.get(4))) {
			grade = 3;
			result.add(grade);
			result.add(card_num.get(3));
			result.add(card_num.get(0));
			result.add(card_num.get(2));
		} else if ((card_num.get(1) == card_num.get(2)) && (card_num.get(3) == card_num.get(4))) {
			grade = 3;
			result.add(grade);
			result.add(card_num.get(3));
			result.add(card_num.get(1));
			result.add(card_num.get(0));
		} else if (card_num.get(0) == card_num.get(1)) {
			grade = 2;
			result.add(grade);
			result.add(card_num.get(0));
			result.add(card_num.get(4));
			result.add(card_num.get(3));
			result.add(card_num.get(2));
		} else if (card_num.get(1) == card_num.get(2)) {
			grade = 2;
			result.add(grade);
			result.add(card_num.get(1));
			result.add(card_num.get(4));
			result.add(card_num.get(3));
			result.add(card_num.get(0));
		} else if (card_num.get(2) == card_num.get(3)) {
			grade = 2;
			result.add(grade);
			result.add(card_num.get(2));
			result.add(card_num.get(4));
			result.add(card_num.get(1));
			result.add(card_num.get(0));
		} else if (card_num.get(3) == card_num.get(4)) {
			grade = 2;
			result.add(grade);
			result.add(card_num.get(3));
			result.add(card_num.get(2));
			result.add(card_num.get(1));
			result.add(card_num.get(0));
		} else {
			grade = 1;
			result.add(grade);
			result.add(card_num.get(4));
			result.add(card_num.get(3));
			result.add(card_num.get(2));
			result.add(card_num.get(1));
			result.add(card_num.get(0));
		}
		return result;
	}
		
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {

			String[] input_line = scan.nextLine().split(" ");
			ArrayList<Integer> black_score = new ArrayList<>();
			ArrayList<Integer> white_score = new ArrayList<>();

			for (int i = 0; i < 5; i++) {
				black_score.add(convert(input_line[i]));
			}

			for (int i = 5; i < 10; i++) {
				white_score.add(convert(input_line[i]));
			}

			if (get_hand_value(black_score).get(0) > get_hand_value(white_score).get(0)) {
				System.out.println("Black wins.");
			}
			else if (get_hand_value(black_score).get(0) < get_hand_value(white_score).get(0)) {
				System.out.println("White wins.");
			}
			else {
				for (int i = 1; i < get_hand_value(black_score).size(); i++) {
					if (get_hand_value(black_score).get(i) > get_hand_value(white_score).get(i)) {
						System.out.println("Black wins.");
						break;
					} else if (get_hand_value(black_score).get(i) < get_hand_value(white_score).get(i)) {
						System.out.println("White wins.");
						break;
					} else if ((get_hand_value(black_score).get(i) == get_hand_value(white_score).get(i)) && (i == get_hand_value(black_score).size() - 1)) {
						System.out.println("Tie.");
					}
				}
			}
		}
	}
}