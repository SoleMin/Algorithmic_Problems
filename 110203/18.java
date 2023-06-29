import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t, dayN, pN, h, i, j, temp = 0, result = 0;
		int[] day;
		
		t = input.nextInt();
		while(t > 0){
			dayN = input.nextInt();
			day = new int[dayN+1];
			for(i = 0; i < day.length; i++)
				day[i] = 0;
			
			pN = input.nextInt();
			for(i = 0; i < pN; i++){
				h = input.nextInt();
				for(j = 1; j < day.length; j++){
					temp = j * h;
					if(temp % 7 == 6 || temp % 7 == 0);
					else
						if(temp <= dayN)
							day[temp] += 1;
						else
							break;
				}
			}
			
			for(j = 1; j < day.length; j++)
				if(day[j] > 0)
					result += 1;
			System.out.println(result);
			result = 0;
			t--;
		}
	}
}