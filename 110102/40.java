
import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = 1;
		while(in.hasNextInt()){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			
			if(num1 == 0 && num2 == 0) break;
			char array[][] = new char[num1][num2];
			for(int i = 0; i < num1; i++){
				String s = in.next();
				for(int j = 0; j < num2; j++){
					array[i][j] = s.charAt(j);
				}
			}
			
			System.out.println("Field #" + num + ":");
			int array_num[][] = new int[num1][num2];
			
			for(int i = 0; i < num1; i++){
				for(int j = 0; j < num2; j++){
					if(array[i][j] == '*'){
						array_num[i][j] = -1;
						
						for(int k = i-1; k <= i+1; k++){
							for(int l = j-1; l <= j+1; l++){
								try{
									if(array[k][l] != '*') array_num[k][l] += 1;
									else array_num[k][l] = -1;
								}catch(ArrayIndexOutOfBoundsException e){
									
								}
							}
						}
					}
				}
			}
			String array_str[] = new String[num1];
			for(int i = 0; i < num1; i++){
				for(int j = 0; j < num2; j++){
					if(array_num[i][j] == -1){
						array_str[i] += '*';
					}
					else{
						array_str[i] += Integer.toString(array_num[i][j]);
					}
				}
			}
			
			for(int i = 0; i < num1; i++){
				System.out.println(array_str[i].substring(4));
			}
			System.out.println();
			num++;
		}
	}
}