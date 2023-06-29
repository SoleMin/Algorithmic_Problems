import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Paint_The_Numbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> paint = new ArrayList<Integer>();
		int num = scan.nextInt();
		for(int i = 0; i < num;i++)
			paint.add(scan.nextInt());
		Collections.sort(paint);
		int counter = 0;
		//System.out.println(paint);
		while(paint.size()!=0) {
			num = paint.remove(0);
			for(int i = 0; i<paint.size();i++) {
				if(paint.get(i)%num==0) {
					paint.remove(i--);
				}
			}
			counter++;
		}
		System.out.println(counter);
	}

}
