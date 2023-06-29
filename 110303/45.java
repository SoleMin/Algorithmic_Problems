import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a;
		String b;
		while((a=br.readLine())!=null && !a.isEmpty()&&(b=br.readLine())!=null && !b.isEmpty()){
			// String[] a_arr = a.split("");
			// String[] b_arr = b.split("");
			// List<String> sum = new ArrayList<>();
			ArrayList<Character> a_list = new ArrayList<Character>();
			ArrayList<Character> b_list = new ArrayList<Character>();
			ArrayList<Character> sum = new ArrayList<>();
			// for(int i=0; i<b_arr.length;i++){
			// 	if(Arrays.asList(a_arr).contains(b_arr[i]))
			// 		sum.add(b_arr[i]);
			// }
			for(int i = 0; i<a.length(); i++){
				a_list.add(a.charAt(i));
			}
			for(int i=0; i<b.length(); i++){
				b_list.add(b.charAt(i));
			}
			for(int i=0; i<a_list.size();i++){
				for(int j=0; j<b_list.size();j++){
					if(a_list.get(i)==b_list.get(j)){
						sum.add(a_list.get(i));
						b_list.remove(j);
						break;
					}
				}
			}
			
			Collections.sort(sum);
			// String[] arr = sum.toArray(new String[0]);
			// for(int i=0; i<arr.length; i++){
			// 	System.out.print(arr[i]);
			// }
			for(int i=0; i<sum.size(); i++){
				System.out.print(sum.get(i));
			}
			System.out.println();
		}
	}
}

// 처음에 주석 처리한 방법으로 푸니까 테스트케이스 1개가 fail이 나와서 코드 수정. 이후 all pass 나옴.
