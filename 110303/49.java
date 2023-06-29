import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input=br.readLine()) != null){
			String input2 = br.readLine();
			
			String[] arr = input.split("");
			String[] arr2 = input.split("");
			
			List<String> result = new ArrayList<String>();
			
			for(int i =0; i<input.length(); i++){
				char c = input.charAt(i);
				for(int j=0; j<input2.length(); j++){
					char c2 = input2.charAt(j);
					if(c == c2){
						result.add(arr[i]);
						input2 = input2.replaceFirst(arr[i], "X");
						break;
					}
					else
						continue;
				}
			}
			//Set <String> set = new HashSet<String>(result);
			//List<String> newR = new ArrayList<String>(set);
			Collections.sort(result);
			for(String str : result){
				System.out.print(str);
			}
			System.out.println();
		}
	}
}