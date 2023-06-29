import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		
		int[] next = new int[pattern.length()];
		int n = 0; // 비교하기위한 인트 값 설정
		
		//패턴 내에서 접두사 접미사 최대 길이
		for(int i = 1; i<pattern.length(); i++){
			while(n>0 && pattern.charAt(i) != pattern.charAt(n)) // 일치 x
				n = next[n-1];  //n에서 1뺀 값으로 이동
			
			if(pattern.charAt(i) == pattern.charAt(n)) // 일치한다면
				next[i] = ++n; //n에서 1 더한 값을 넣어줌.
		}
		
		int count = 0; int m = 0;
		String index = "";
		
		//일치하는 값 찾기
		for(int i = 0; i < text.length(); i++){
			while(m>0 && text.charAt(i) != pattern.charAt(m)) //일치하지 않는다면
				m = next[m-1];
			if(text.charAt(i) == pattern.charAt(m)){
				if(m == pattern.length()-1){ //전체
					count++; //몇개 나타나는지.
					index += (i-pattern.length()+2) + " "; //몇번째에서 찾았는지. 여러개
					m = next[m]; //찾은 뒤에도 점프, 그 뒷문장에도 있을 수 있으니.
				}
				else
					m++;
			}
		}
		
		System.out.println(count);
		System.out.println(index);
	}
}