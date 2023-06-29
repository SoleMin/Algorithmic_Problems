import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		String ori =   "`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,.";
		String input = "1234567890-+WERTYUIOP[]\\SDFGHJKL;\'XCVBNM,./"; // \들어가는거 계산해서 하기
		int tf = 0;
		int b = 0;
		String[] results = new String[100];
	
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String line = sc.nextLine(); // 망한 한줄 입력받기
			String[] new_line = line.split("\\s"); // 공백 기준으로 나눠서 
			
			String[] tmp = new String[new_line.length];
			String tmpline = "";
			
			int[][] temp_ = new int[new_line.length][];
			int[] temp;
			
			// 반복문을 통해 입력받은 문자열
			for(int i=0; i<new_line.length; i++){
				tmpline = "";
				int h = 0;
				temp = new int[new_line[i].length()];
				for(int j=0; j<new_line[i].length(); j++){ // new_line 배열의 각 string 마다
					for(int k=0; k<ori.length(); k++){ // ori와 하나씩 대응해주기
						if(new_line[i].charAt(j) == input.charAt(k)){
							temp[j] = k;  //ori 에서 대치되는것만 뽑아서 temp에 저장
						}
					}
				}
				temp_[i] = temp;

			}
			
			String result = "";
			
			for(int i=0; i<temp_.length; i++){
				for(int j=0; j<temp_[i].length; j++){
					result = result + ori.charAt(temp_[i][j]);
				}
				result = result + " ";
			}
			
			results[b] = result;
			b++;
			result = "";
				
			
			tf= tf+1;
							 
		}
		for(int i=0; i<b; i++)
			System.out.println(results[i]);
							 
	}
}