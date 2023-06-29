import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args)  {
		Scanner input1 = new Scanner(System.in);
		
		int Case = input1.nextInt();
		
		for (int t =0; t <Case; t++){
			int m = input1.nextInt(); //행
			int n = input1.nextInt(); //열
			String []str = new String[m];
			
			for(int i = 0; i<m; i++)
				str[i] = input1.next().toUpperCase(); // 대문자로 
			
			/*
			for(int i =0; i <m;i++){
				System.out.println(str[i]);
			}
			*/
			int number = input1.nextInt();
			
			for(int i =0; i < number; i++){
				String s = input1.next().toUpperCase(); //대문자로
				int start_x =0, start_y =0;
				int count =0;
				boolean find = false;
				for(int r= 0; r<m; r++){
					for(int c= 0; c<n; c++){

						if(str[r].charAt(c) == s.charAt(0)){
							start_x =c; start_y =r;
								//up
							if( r >= s.length()-1){
									 find = true;
									for(int j = 0; j <s.length(); j++){
										if(s.charAt(j) != str[r-j].charAt(c))
										{ find =false; break;}}
									if(find == true){
										count++;
										break;
									}
								}
							//down
								if((m-r) >=s.length()-1){
									find = true;
									for(int j = 0; j <s.length(); j++){
										if(s.charAt(j) != str[r+j].charAt(c))
										{ find =false; break;}
									}
									if(find ==true){
										count++;
										break;
									}
								}
							//right
							if((n-c) >=s.length()-1){
								find =true;
								for(int j = 0 ; j < s.length(); j++){
									if(s.charAt(j) != str[r].charAt(c+j))
									{find =false; break;}
								}
								if(find == true){
									count++;
									break;
								}
							}
							//left
							if(c >= s.length()-1){
							 find =true;
								for(int j =0; j<s.length(); j++){
									if(s.charAt(j) != str[r].charAt(c-j))
									{find = false; break;}
								}
								if(find == true){
									count++;
									break;
								}
							}
							//left&&up
							if(c>=s.length()-1 && r>=s.length()-1){
								find = true;
								for(int j = 0 ; j <s.length(); j++){
									if(s.charAt(j) != str[r-j].charAt(c-j))
									{find = false; break;}
								}
								if(find ==true){
									count++;
									break;
								}
							}
							//right&&up
							if((n-c) >=s.length()-1 && r>=s.length()-1){
								find =true;
								for(int j = 0; j <s.length(); j++){
									if(s.charAt(j) != str[r-j].charAt(c+j))
									{find =false; break;}
								}
								if(find == true){
									count++;
									break;
								}
							}
							//left&&down
							if(c>=s.length()-1 && (m-r)>=s.length()-1){
								find= true;
								for(int j=0; j<s.length(); j++){
									if(s.charAt(j) != str[r+j].charAt(c-j))
									{find =false; break;}
								}
								if(find ==true){
									count++;
									break;}
							}
							//right&&down
							if((n-c) >= s.length()-1 && (m-r)>=s.length()-1){
								 find =true;
								for(int j =0; j<s.length(); j++){
									if(s.charAt(j) != str[r+j].charAt(c+j))
									{find=false; break;}
								}
								if(find ==true){
									count++;
									break;
								}
							}
						} //if
						
					} // int c
					if(count!=0) break;
				} // int r
				System.out.println((start_y+1) +" "+ (start_x+1));
			} //int i
			System.out.println();
		} // int t
		
		input1.close();
	}
}