import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String str = input.nextLine();
			String[] strArr = str.split(" ");
			int[] intArr = new int[strArr.length-1];
			int[] present = new int[strArr.length-1];
			int n = Integer.parseInt(strArr[0]);
			
			for(int i=0; i<intArr.length; i++)
				intArr[i] = Integer.parseInt(strArr[i+1]);
			
			if(n == 1)
				System.out.println("Jolly");
			else if(n == 2)
				if(Math.abs(intArr[0]-intArr[1]) == 1)
					System.out.println("Jolly");
				else
					System.out.println("Not jolly");
			else {
				for(int i=0; i<present.length-1; i++) {
					int difference = Math.abs(intArr[i]-intArr[i+1]);
					
					if(difference == 0) {
						System.out.println("Not jolly");
						break;
					}
						
					if((difference < present.length)&&(present[difference] == 0)) {
						present[difference]++;
						if(i == present.length-2) {
							System.out.println("Jolly");
						}
					}
					else {
						System.out.println("Not jolly");
						break;
					}
				}
			}
		}
	}
}