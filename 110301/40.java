import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> keyMap = new HashMap<>();
		
		String[] s1 = "QWERTYUIOP[ASDFGHJKL;ZXCVBNM,.`1234567890-".split("");
		String[] c1 = "WERTYUIOP[]SDFGHJKL;'XCVBNM,./1234567890-=".split("");
		
		keyMap.put(" ", " ");
		keyMap.put("\\", "]");
		for(int i =0 ; i <s1.length; i++){
			keyMap.put(c1[i], s1[i]);
		}
		
		while(true){
			String inputString = br.readLine();
			if(inputString==null){
				break;
			}
			String[] input = inputString.split("");
		
				Arrays.stream(input).forEach(x->System.out.print(keyMap.get(x)));
				System.out.println();
			
		}
 	}
}