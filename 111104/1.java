import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// 거북이 몸무게 체력 클래스
		class turtle
		{
			int w;
			int s;
			
			turtle (int w, int s){
				this.w = w;
				this.s = s;
			}
		}
		
		// 거북이 배열
		turtle[] t = new turtle[5608];
		for(int i = 0; i < 5608; i++) {
			t[i] = new turtle(0,0);
		}
		
		// 입력받기
		int index = 0;
		while(input.hasNextInt()) {
			t[index].w = input.nextInt();
			t[index].s = input.nextInt();
			
			index++;
		}
		
		// 정렬하기
		int min = 0;
		int temp_1 = 0;
		int temp_2 = 0;
		for(int i = 0; i < index-1; i++) {
			min = i;
			for(int j = i+1; j < index; j++) {
				if(t[min].s > t[j].s) {
					min = j;
				}
			}
			temp_1 = t[min].s;
			t[min].s = t[i].s;
			t[i].s = temp_1;
			
			temp_2 = t[min].w;
			t[min].w = t[i].w;
			t[i].w = temp_2;
		}
		
		// 거북이 쌓기
		int top[] = new int[index+1];
		for(int i = 0; i < index+1; i++) {
			top[i] = 1000000;
		}
		
		top[0]= 0;
		int answer = -1;
		 for(int i = 1; i < index+1; i++){
	            for(int j = index-1; j >= 1; j--){
	                if((t[i-1].s-t[i-1].w) >= top[j-1]){
	                    top[j] = Math.min(top[j], top[j-1] + t[i-1].w);
	                }
	            }
	        }
	        for(int i = 0; i < index; i++){
	            if(top[i] != 1000000){
	                answer = i;
	            }
	        }

		System.out.println(answer);

	}

}
