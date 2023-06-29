import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
			
        int n = Integer.parseInt(br.readLine());
        br.readLine();
				
				String st = "the quick brown fox jumps over the lazy dog";
				
				String line = "";
				String line2 = "";
			
				ArrayList<String> list = new ArrayList<>();
        for(int a = 0; a < n; a++) {
						if(a > 0) sb.append("\n");//
						
            boolean check = false;
						boolean found = false;
            
            while(true) {
                if((line = br.readLine()) == null) break;
                if("".trim().equals(line)) break;
                
                list.add(line);
                if(line.length() == st.length() && check==false && found==false) {
                    check = true;
                    for(int i = 0; i < line.length(); i++) {
                        if(line.charAt(i) == (' ') && st.charAt(i) != (' ')) {
                            check = false;
                            break;
                        } 
											else if(line.charAt(i) != (' ') && st.charAt(i) == (' ')) {
                            check = false;
                            break;
                        }
                    }
                    if(check == true) {
                        check = CHECK(line, st);
                   
										}
                }
                if(check == true && found == false) {
										found = true;
                    line2 = line;
                }
            }
            
						if(check == true) {                
              char[] array = new char[26];
                for(int i = 0; i < line2.length(); i++) {
                    if(line2.charAt(i) >= 'a' && line2.charAt(i) <= 'z') {
											int index2 = line2.charAt(i)-97;
                    	array[index2] = st.charAt(i);
										}
                }
               
                for(int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    for(int z = 0; z < s.length(); z++) {
                        if(s.charAt(z) >= 'a' && s.charAt(z) <= 'z') {
														int index = s.charAt(z)-97;
                            sb.append(array[index]);
												}
												else
                            sb.append(s.charAt(z));        
                    }
                    sb.append("\n");
                }
            }
					else
							sb.append("No solution.\n");	
					
					list.clear();
        }
			
        System.out.println(sb);
    }

    static boolean CHECK(String line, String st) {
				char[] array = new char[26];
        boolean[] array_check = new boolean[array.length];
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
							int index = line.charAt(i)-97;
                if(array_check[index] == false) {
										array[index] = st.charAt(i);
                    array_check[index] = true;
                } 
								else {
                    if(array[index] != st.charAt(i)) {
                        return false;
                    }
                }
					}
        }
        return true;
    }
}