import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
    String line = input.nextLine();          
		String p = input.nextLine();      //패턴
		
		ArrayList<Integer> list = find(line, p); 
		System.out.println(list.size());                       
        
		for(int i = 0; i < list.size(); i++) {                      
			System.out.print(list.get(i)+" ");
		}
		input.close();
	}

	public static ArrayList<Integer> find(String a, String p) {  
		ArrayList<Integer> list = new ArrayList<>();  
		
		int[] array = new int[p.length()];        
		int j = 0;      
		int count = 0;  
		
		for(int i = 0; i < p.length() - 1; i++) {     
			char c = p.charAt(i+1);
			char c2 = p.charAt(j);
			while(c != c2) { 
				if(j <= 0) break;
				j = array[j-1];    
			}
			j++;
			array[i+1] = j;                                       
		}
		                                   
		for(int i = 0; i < a.length(); i++) {          
			char c = a.charAt(i);
			char c2 = p.charAt(count);
			while(a.charAt(i) != p.charAt(count)) {    
				if(count <= 0) break;
				count = array[count-1];                                       
			}
			if(a.charAt(i) == p.charAt(count)) {             
				if(count == p.length()-1) {   
					list.add(i-p.length()+2);  
					count = array[count];  
					                 
				}
				else count++;                                  
			}
		}
		return list;                                      
	}
}