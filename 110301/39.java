import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {
	
	private static Map<Character, Character> qwerty = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		initMap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = br.readLine();
			if(line == null || line.equals("")) {
				break;
			}
			String decodeLine = "";
			
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) != ' '){
					char a = qwerty.get(line.charAt(i));
					decodeLine = decodeLine + a;
				}
				else{
					decodeLine = decodeLine + " ";
				}
			}
			System.out.println(decodeLine);
		}
	}
	
	public static void initMap() {
		
		qwerty.put('1','`');
		qwerty.put('2','1');
		qwerty.put('3','2');
		qwerty.put('4','3');
		qwerty.put('5','4');
		qwerty.put('6','5');
		qwerty.put('7','6');
		qwerty.put('8','7');
		qwerty.put('9','8');
		qwerty.put('0','9');
		qwerty.put('-','0');
		qwerty.put('=','-');
		qwerty.put('W', 'Q');
		qwerty.put('E', 'W');
		qwerty.put('R', 'E');
		qwerty.put('T', 'R');
		qwerty.put('Y', 'T');
		qwerty.put('U', 'Y');
		qwerty.put('I', 'U');
		qwerty.put('O', 'I');
		qwerty.put('P', 'O');
		qwerty.put('[','P');
		qwerty.put(']', '[');
		qwerty.put('\\', ']');
		qwerty.put('S', 'A');
		qwerty.put('D', 'S');
		qwerty.put('F', 'D');
		qwerty.put('G', 'F');
		qwerty.put('H','G');
		qwerty.put('J', 'H');
		qwerty.put('K', 'J');
		qwerty.put('L', 'K');
		qwerty.put(';','L');
		qwerty.put('\'', ';');
		qwerty.put('X', 'Z');
		qwerty.put('C', 'X');
		qwerty.put('V', 'C');
		qwerty.put('B', 'V');
		qwerty.put('N', 'B');
		qwerty.put('M', 'N');
		qwerty.put(',', 'M');
		qwerty.put('.',',');
		qwerty.put('/','.');
	}
}