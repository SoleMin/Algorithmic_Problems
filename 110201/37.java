import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int[] numarr;
		int[]aaa;
		int fnum;
		String[] strarr;
		int jolly = 0;
		
		while((input = br.readLine()) != null){
			strarr = input.split(" ");
			fnum = Integer.parseInt(strarr[0]);
			numarr = new int[fnum];
			int abc = fnum-1;
			aaa = new int[abc];
			
			for(int i =1;i<=fnum;i++){
				numarr[i-1] = Integer.parseInt(strarr[i]);
			}
			if(fnum == 1){
				jolly = 1;
				System.out.println("Jolly");
			}
			else {
				for(int i=1; i<fnum;i++){
					aaa[i-1] = Math.abs(numarr[i] - numarr[i-1]);
					if(aaa[i-1] >= fnum || aaa[i-1]<1){
						jolly =2;
					}
				}
				for(int i=0;i<abc;i++){
					if(jolly == 2){
						break;
					}else{
						for(int j=0;j<abc;j++){
							if(aaa[i] == aaa[j]){
								if(i==j){
								}else{
									jolly =2;
									break;
								}
							}
						}
					}
				}
			}
			if(jolly==2){
				System.out.println("Not jolly");
			}else if(jolly!=1){
				System.out.println("Jolly");
			}
			jolly = 0;
			
			
		}
	}
}