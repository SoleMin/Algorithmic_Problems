import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int n = 0;
		
		while((input = br.readLine()) != null){
			String arr[] = input.split(" ");
			n = Integer.parseInt(arr[0]);
			
			ArrayList<Integer> minus = new ArrayList<Integer>();
			
			for(int i = 1; i<n; i++){
				int index = Integer.parseInt(arr[i+1]) - Integer.parseInt(arr[i]);
				if(minus.contains(index) == true || Math.abs(index) > (n-1) || index == 0){
					System.out.println("Not jolly");
					break;
				}
				minus.add(index);
			}
			if(minus.size() == n-1)
				System.out.println("Jolly");
		}
	}
}