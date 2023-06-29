import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class LittleElephant {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); 
		int temp;
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		int count = 0;
		int temp1,temp2;
		
		for(int i= 0; i < n ; i++){
			temp = input.nextInt();
			a2.add(temp);
			a1.add(temp);
		}
		Collections.sort(a2);
		input.close();
		for(int i = 0; i < n; i++){
			temp1 = a2.get(i);
			temp2 = a1.get(i);
			if(temp1 != temp2){
				count++;
			}
		}
		if(count==2 || count==0){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
