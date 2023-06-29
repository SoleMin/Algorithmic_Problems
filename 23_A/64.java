import java.util.*;
public class A23 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String W = sc.next();
		ArrayList<String>Q = new ArrayList<String>();
		for (int i = 0; i < W.length(); i++){			
			String O = "";
			for (int k = i; k < W.length(); k++){
				O = O + W.charAt(k);
				Q.add(O);
			}			
		}
		Collections.sort(Q);
		String tmp = Q.get(0);
		int y = 0;
		for (int i = 1; i < Q.size(); i++){
			if (Q.get(i).equals(tmp)){
				if (Q.get(i).length() > y){
					y = Q.get(i).length();
				}	
			}
			else {
				tmp = Q.get(i);				
			}
		}
		System.out.println(y);
	}
}
