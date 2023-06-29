import java.io.*;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int gatsu = Integer.parseInt(input);
		
		for(int i = 0;i < gatsu;i++){
			ArrayList<Integer> num = new ArrayList<>();
			int middle  = 0;
			int sum  = 0;
			input = br.readLine();
			int houses = Integer.parseInt(input.split(" ")[0]);
			for (int j=1;j<=houses;j++) num.add(Integer.parseInt(input.split(" ")[j]));
			if((houses) % 2 == 0){
				middle = num.get((num.size()) / 2);
			}else {
				middle = num.get((num.size()-1) / 2);
			}
			for(int a=0;a<num.size();a++){
				sum += Math.abs(middle - num.get(a));
			}
			System.out.println(sum);
		}
	}
}