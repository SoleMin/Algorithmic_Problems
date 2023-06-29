import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null ){
			List<String> firstStrings = new ArrayList<>(Arrays.asList(input.split("")));
			List<String> secondStrings = new ArrayList<>(Arrays.asList(br.readLine().split("")));
			ArrayList<String> resultStrings = new ArrayList<>();
			
			Collections.sort(firstStrings);
			Collections.sort(secondStrings);
			
		while(true){
			if((firstStrings.isEmpty()) || secondStrings.isEmpty()){
				Collections.sort(resultStrings);
				break;
			}
			String s = firstStrings.remove(0);
			
			for(int i =0 ; i<secondStrings.size(); i++){
				if(secondStrings.get(i).equals(s)){
					resultStrings.add(s);
					secondStrings.remove(i);
				}
			}
		}
			for(String s : resultStrings){
				System.out.printf(s);
			}
			System.out.println();
		}
	}
}