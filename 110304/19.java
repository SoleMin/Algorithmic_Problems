import java.io.*;
import java.util.*;
class Main {
	static char[] base = "the quick brown fox jumps over the lazy dog".toCharArray();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> space = new ArrayList<>();
		List<Integer> index = new ArrayList<>();
		boolean[] tfArray = new boolean[150];
		for(int i=0; i<base.length; i++){
			if(!tfArray[base[i]]) tfArray[base[i]] = true;
			else index.add(i);
		}
		
		for(int i=0; i<base.length; i++){
			if(base[i]==' ')space.add(i);
		}
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		br.readLine();
		while(testCase-->0){
			char[][] cArray = new char[100][];
			int size=0;
			for(int i=0; i<100; i++){
				String s = br.readLine();
				if(s==null || s.length()==0){
					size = i;
					break;
				}
				cArray[i] = s.toCharArray();
			}
			
			int baseIndex = -1;
			// boolean tf = true;
			// baseIndex 찾는 과정 1. 문자열 길이, 2. space 위치, 3. 중복되는 문자 위치.
			for(int i=0; i<size; i++){
				boolean tf = true;
				if(base.length==cArray[i].length){
					for(int j=0; j<space.size(); j++){
						if(cArray[i][space.get(j)] != ' '){
							tf = false;
							break;
						}
					}
					
					if(tf){
						tfArray = new boolean[150];
						int count=0;
						for(int j=0; j<cArray[i].length; j++){
							try{
								if(!tfArray[cArray[i][j]]) tfArray[cArray[i][j]] = true;
								else if(index.get(count++)!=j){
									tf = false;
									break;
								}
							}
							catch(IndexOutOfBoundsException e){
								tf = false;
								break;
							}
						}
					}
					
					if(tf) baseIndex = i;
				}
			}
			
			
			if(baseIndex!=-1){
				//index : 암호화, value : 원본
				int[] alphabet = new int[123];
				for(int i=0; i<cArray[baseIndex].length; i++){
					alphabet[cArray[baseIndex][i]] = base[i];
				}
			
				for(int i=0; i<size; i++){
					for(int j=0; j<cArray[i].length; j++){
						sb.append((char) alphabet[cArray[i][j]]);
					}
					sb.append('\n');
				}
			}
			else sb.append("No solution.").append('\n');
			sb.append('\n');
			
		}
		System.out.println(sb);
		
		
		
		
	}
}