import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {

		char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
		'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		int[] abc_n1 = new int[26];
		int[] abc_n2 = new int[26];
		int[] answer = new int[26];
		
		for(int i=0; i<abc_n1.length; i++){
			abc_n1[i] = 0;
			abc_n2[i] = 0;
			answer[i] = 0;
		}
		
		// 2개가 한세트인 여러 개의 테스트 케이스 입력받기
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[200];
		// arr[]초기화
		for(int i=0; i<200; i++){
			arr[i] = "";
		}
		
		// 배열에 테스트 케이스들을 넣기
		int w = 0;
		int z = 0;
		while(sc.hasNextLine()){
		//while(z<4){
			arr[w] = sc.nextLine();
			w++;
			z++;
		}
		
		// 각 글자의 빈도수를 x/y별로 세기
		for(int i=0; i<w; i=i+2){
			
			for(int j=0; j<arr[i].length(); j++){ //첫번째 문자열
				for(int a=0; a<26; a++){
					if(arr[i].charAt(j) == abc[a]){
						abc_n1[a]++;
					}
				}
			}
			for(int j=0; j<arr[i+1].length(); j++){ //두번째 문자열
				for(int a=0; a<26; a++){
					if(arr[i+1].charAt(j) == abc[a]){
						abc_n2[a]++;
					}
				}
			}
			
			// 각 배열에 들어있는 abc를 비교해 더 큰것을 답 배열에 넣기
			for(int n=0; n<26; n++){
				if(abc_n1[n]==0 || abc_n2[n]==0)
					answer[n] = 0;
				else if(abc_n1[n] < abc_n2[n])
					answer[n] = abc_n1 [n];
				else
					answer[n] = abc_n2[n];
			}
			
			for(int n=0; n<26; n++){
				if(answer[n] != 0)
					for(int m=0; m<answer[n]; m++){
						System.out.print(abc[n]);
					}
			}
			
			System.out.println();
			
			// 초기화해야하는 배열들 초기화
			for(int n=0; n<26; n++){
				abc_n1[n] = 0;
				abc_n2[n] = 0;
				answer[n] = 0;
			}
			
		}
		
		
		
	}
}