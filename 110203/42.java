import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) {
		
	 Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		
		for(int q=0;q<T;q++){
			int day=0;
			day=input.nextInt();
			int P=0;
			P=input.nextInt();
			int[]h=new int[P];
			int count=0;
			for(int i=0;i<h.length;i++) //입력받기
				h[i]=input.nextInt();
			
			for(int i=1;i<=day;i++){//1일(일요일)부터 day까지 검사
				if(i%7==0 || i%7==6) //금요일과 토요일 제외시키기
					continue;
				for(int j=0;j<h.length;j++){
					if(i%h[j]==0){ //동맹휴업지수로 나누기. 떨어지면 count증가
						count++;
						break;
					}
				}
			}
			System.out.println(count);
		}
	}
}