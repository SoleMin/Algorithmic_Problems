import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String input, output;
		char temp[];
		while(in.hasNextLine()){
			input = in.nextLine();
			output = "";
			temp = input.toCharArray();
			for(char ch : temp){
				switch(ch){
					case '1': output += '`'; break;
					case '2': output += '1'; break;
					case '3': output += '2'; break;
					case '4': output += '3'; break;
					case '5': output += '4'; break;
					case '6': output += '5'; break;
					case '7': output += '6'; break;
					case '8': output += '7'; break;
					case '9': output += '8'; break;
					case '0': output += '9'; break;
					case '-': output += '0'; break;
					case '=': output += '-'; break;
					case 'W': output += 'Q'; break;
					case 'E': output += 'W'; break;
					case 'R': output += 'E'; break;
					case 'T': output += 'R'; break;
					case 'Y': output += 'T'; break;
					case 'U': output += 'Y'; break;
					case 'I': output += 'U'; break;
					case 'O': output += 'I'; break;
					case 'P': output += 'O'; break;
					case '[': output += 'P'; break;
					case ']': output += '['; break;
					case '\\': output += ']'; break;
					case 'S': output += 'A'; break;
					case 'D': output += 'S'; break;
					case 'F': output += 'D'; break;
					case 'G': output += 'F'; break;
					case 'H': output += 'G'; break;
					case 'J': output += 'H'; break;
					case 'K': output += 'J'; break;
					case 'L': output += 'K'; break;
					case ';': output += 'L'; break;
					case 'X': output += 'Z'; break;
					case 'C': output += 'X'; break;
					case 'V': output += 'C'; break;
					case 'B': output += 'V'; break;
					case 'N': output += 'B'; break;
					case 'M': output += 'N'; break;
					case ',': output += 'M'; break;
					case '.': output += ','; break;
					case '/': output += '.'; break;
					default: output += ch; break;
				}
			}
			System.out.println(output);
		}
	}
}