import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		int c = 0;
		
		ArrayList<Integer> family = new ArrayList<>(); 
		ArrayList<Integer> result = new ArrayList<>();
		
		//while(c<1){
		while(c<cases){
			//System.out.println("새 케이스 시작 : c = " + c);
			String fam = sc.nextLine();
			String[] fami = fam.split(" ");
			int vito = 0;
			int fst = 0;
			int sec = 0;
			//for(int i=0; i<fami.length; i++){
				//System.out.println("fami[i] = " + fami[i]);
			//}
			int num = Integer.parseInt(fami[0]);
			
			for(int i=1; i<fami.length; i++){
				family.add( Integer.parseInt(fami[i]) );
			}
			
			//for(int i=0; i<family.size(); i++){
				//System.out.println("family.get(" + i + ") = " + family.get(i));
			//}
			Collections.sort(family);
			int test;
			// family 안에 중복되는것이 있다면 제거해야함.
			for(int i = (family.size() - 1); i>=0; i--){
				test = family.get(i);
			}
			// 친척집이 홀수개면
			if(num % 2 != 0){
				vito = dis(family, num/2);
				System.out.println(vito);
			}
			else{
				fst = dis( family, (num/2)-1 );
				sec = dis(family, num/2);
				vito = Math.min(fst,sec);
				System.out.println(vito);
			}
			
			family.clear();
			c++;
		}
		
		
	}
	
	// 친척들의 주소지 리스트와 정렬된 리스트의 가운데의 인덱스를 입력으로
	// 입력값에 따른 거리 리턴
	public static int dis(ArrayList<Integer> family, int vito){
		int total = 0;
		int dis = 0;
		for(int i=0; i<family.size(); i++){
			//비토가 정한 친척집과의 거리는 0이므로 나머지 경우에 대해서만 거리 더하기
			if(family.get(i) != family.get(vito)){
				dis = family.get(i) - family.get(vito);
				if(dis < 0){
					dis = dis * -1;
				}
				total = total + dis;
				dis = 0;		
			}
		}
		return total;
	}
	
}