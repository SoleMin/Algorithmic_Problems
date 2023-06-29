import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String ss = input.nextLine();
			
			if(ss.equals("0"))
				break;
			
			int num = Integer.parseInt(ss);
			int[] a = new int[num+1];
			
			a[1] = 1;
			
			for(int i=2; i<=num; i++){
				a[i] = 1 + a[i-a[a[i-1]]];
			}
			
			System.out.println(a[num]);
		}
		input.close();
	}
}