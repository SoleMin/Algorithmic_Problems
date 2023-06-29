import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String input = sc.nextLine();
			if(input.length() == 0)
				break;
			for(int i = 0; i < input.length(); i++){
				switch(input.charAt(i)){
					case 'W': System.out.print('Q'); break;
					case 'E':System.out.print('W'); break;
					case 'R':System.out.print('E'); break;
					case 'T':System.out.print('R'); break;
					case 'Y':System.out.print('T'); break;
					case 'U':System.out.print('Y'); break;
					case 'I':System.out.print('U'); break;
					case 'O':System.out.print('I'); break;
					case 'P':System.out.print('O'); break;
					case '[':System.out.print('P'); break;
					case ']':System.out.print('['); break;
					case '\\':System.out.print(']'); break;
					case 'S':System.out.print('A'); break;
					case 'D':System.out.print('S'); break;
					case 'F':System.out.print('D'); break;
					case 'G':System.out.print('F'); break;
					case 'H':System.out.print('G'); break;
					case 'J':System.out.print('H'); break;
					case 'K':System.out.print('J'); break;
					case 'L':System.out.print('K'); break;
					case ';':System.out.print('L'); break;
					case '\'':System.out.print(';'); break;
					case 'X':System.out.print('Z'); break;
					case 'C':System.out.print('X'); break;
					case 'V':System.out.print('C'); break;
					case 'B':System.out.print('V'); break;
					case 'N':System.out.print('B'); break;
					case 'M':System.out.print('N'); break;
					case ',':System.out.print('M'); break;
					case '.':System.out.print(','); break;
					case '/':System.out.print('.'); break;
					case '-':System.out.print('0'); break;
					case '=':System.out.print('-'); break;
					case '1':System.out.print('`'); break;
					case '0':System.out.print('9'); break;
				}

				if(input.charAt(i) >= 50 && input.charAt(i) <= 57)
					System.out.print((char)(input.charAt(i)-1));
				else if(input.charAt(i) == ' ')
					System.out.print(' ');

			}
			System.out.println();
		}
	}
}