import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			
			if(s.charAt(0) == '0')
				System.out.println(demical(s));
			else
				System.out.println("0x" + hex(s));
		}
		input.close();
	}
	
	public static String hex(String s) {
		long n = Integer.parseInt(s);
		StringBuilder sb = new StringBuilder();
		
		while(n!=0) {
			int temp = (int)(n % 16);
			switch (temp) {
				case 10: sb.append('A'); break;
				case 11: sb.append('B'); break;
				case 12: sb.append('C'); break;
				case 13: sb.append('D'); break;
				case 14: sb.append('E'); break;
				case 15: sb.append('F'); break;
				default: sb.append(temp); break;
			}
			n = (n - temp) / 16;
		}
		sb.reverse();
		
		return sb.toString();
	}
	
	public static long demical(String s) {
		long sum = 0;
		long temp;
		for(int i=2; i < s.length(); i++) {
			temp = 0;
			char c = s.charAt(i);
			switch (c) {
				case 'A': temp = 10; break;
				case 'B': temp = 11; break;
				case 'C': temp = 12; break;
				case 'D': temp = 13; break;
				case 'E': temp = 14; break;
				case 'F': temp = 15; break;
				default: temp = c - '0'; break;
			}
			
			for(int j=i+1; j < s.length(); j++)
				temp *= 16;
			sum += temp;
		}
		return sum;
	}
}