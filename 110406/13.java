import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		
		while(testCase-- > 0) {
			int arr[] = new int[24];
			
			for(int i = 0; i < 24; i++)
				arr[i] = input.nextInt();
			
			input.nextLine();
			
			ArrayList<String> list = new ArrayList<>();
			
			while(input.hasNextLine()) {
				String s = input.nextLine();
				
				if(s.isEmpty())
					break;
				
				list.add(s);
			}
			
			Collections.sort(list);
			
			String info[][] = new String[list.size()][];
			
			for(int i = 0; i < list.size(); i++)
				info[i] = list.get(i).split(" ");
			
			int time = 0;
			int km = 0;
			float fee = 0;
			for(int i = 0; i < info.length - 1; i++) {
				time = 0;
				km = 0;
				fee = 0;
				if(info[i][0].equals(info[i + 1][0]) && info[i][2].equals("enter") && info[i + 1][2].equals("exit")) {
					if(info[i][1].charAt(7) <= info[i + 1][1].charAt(7)) {
					km = Math.abs(Integer.parseInt(info[i + 1][3]) - Integer.parseInt(info[i][3]));
					time = info[i][1].charAt(7) - '0';
					fee = (float) km * arr[time] / 100 + 3;
					System.out.printf(info[i + 1][0] + " $%.2f\n", fee);
					i++;
					}
				}
			}
			System.out.println();
		}
		input.close();
	}
}