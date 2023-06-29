import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String known = "the quick brown fox jumps over the lazy dog";
		List<String> known_set = Arrays.stream(known.split("")).filter(t -> !t.equals(" ")).distinct().collect(Collectors.toList());
		
		int testcase = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		for(int i = 0; i < testcase; i++) {
			String[] temp;
			List<String> repo = new ArrayList<>();
			Map<String,String> decode = new HashMap<>();
			boolean check = false;
			while(sc.hasNextLine()) {
				String m = sc.nextLine();
				if(m.equals(""))
					break;
				repo.add(m);
			}
			for(String s : repo) {

				if(s.length() == known.length()) {
						
					if(s.substring(0,3).equals(s.substring(31,34))) {
							
						if(s.charAt(2) == s.charAt(28)) {
								
							temp = s.split(" ");
								
							List<String> alpha = new ArrayList<>();
								
							alpha = Arrays.stream(s.split("")).filter(t -> !t.equals(" ")).distinct().collect(Collectors.toList());
				
								
							if(alpha.size() == 26) {
									
								if(temp[2].charAt(1) == temp[5].charAt(3)) {
										
									if(temp[1].charAt(1) == temp[4].charAt(1)) {
											
										if(temp[2].charAt(2) == temp[3].charAt(1) && temp[2].charAt(2) == temp[5].charAt(0) && temp[2].charAt(2) == temp[8].charAt(1)) {
												
											for(int idx = 0; idx < alpha.size(); idx++) {
												
												decode.put(alpha.get(idx),known_set.get(idx));
						
											}
											check = true;
											break;
											
										}
										
									}
								
								}			
							
							}		
						
						}
					
					}
					
				}
			
			}
			
				
			
		
			if(!check) {
				System.out.println("No solution.");
				System.out.println();
				continue;
			}
			
			for(String s : repo) {
					
				for(int j = 0; j < s.length(); j++) {
						
					String piece = s.substring(j,j+1);
						
					if(piece.equals(" "))
					
						System.out.print(" ");
					
					else {
							
						System.out.printf("%s",decode.get(piece));
					
					}
				
				}
				System.out.println();
			}
			System.out.println();
			
	
		}

	}
}

	