import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		input.nextLine();
		for(int i =0;i<testCase;i++){
			int days = input.nextInt();
			input.nextLine();
			int party = input.nextInt();
			input.nextLine();
			int[] h = new int[party];
			for(int j=0;j<party;j++){
				h[j] = input.nextInt();
				input.nextLine();
			}
			System.out.println(hartals(days,party,h));
		}
	}
	public static int hartals(int days, int party, int[] h){
		int hollyday=0;
		for(int i=1;i<=days;i++){
			if(i%7==6 || i%7==0) continue;
			for(int j=0;j<party;j++){
				if(i%h[j]==0){
					hollyday++;
					break;
				}
			}
		}
		return hollyday;
	}
}