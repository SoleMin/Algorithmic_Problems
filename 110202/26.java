import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			int arrWhite[]=new int[5];
			int arrBlack[]=new int[5];
			
			for(int i=0;i<5;i++){
				String s =input.next();
				arrBlack[i]=cardCheck(s);
			}
			for(int i=0;i<5;i++){
				String s = input.next();
				arrWhite[i]=cardCheck(s);
			}
	
			
			Arrays.sort(arrWhite);
			Arrays.sort(arrBlack);
			
			
			
			if(cardRank(arrBlack)>cardRank(arrWhite)){
				System.out.println("Black wins.");
			}else if(cardRank(arrBlack)<cardRank(arrWhite)){
				System.out.println("White wins.");
			}else{
				if(arrBlack[4]/10<arrWhite[4]/10){
					System.out.println("White wins.");
				}else if(arrBlack[4]/10>arrWhite[4]/10){
					System.out.println("Black wins.");
				}else{
					if(arrBlack[3]/10>arrWhite[3]/10){
						System.out.println("Black wins.");
					}else if(arrBlack[3]/10<arrWhite[3]/10){
						System.out.println("White wins.");
					}else{
						if(arrBlack[2]/10>arrWhite[2]/10){
							System.out.println("Black wins.");
						}else if(arrBlack[2]/10<arrWhite[2]/10){
							System.out.println("white wins.");
						}else{
							if(arrBlack[1]/10>arrWhite[1]/10){
								System.out.println("Black wins.");
							}else if(arrBlack[1]/10<arrWhite[1]/10){
								System.out.println("White wins.");
							}else{
								if(arrBlack[0]/10>arrWhite[0]/10){
									System.out.println("Black wins.");
								}else if(arrBlack[0]/10<arrWhite[0]/10){
									System.out.println("White wins.");
								}else{
									System.out.println("Tie.");
								}
							}
						}
					}
				}
			}
			
		}
		
	
	}
	public static int cardCheck(String s){
		
		int result = 0;
		
		char num = s.charAt(0);
		
		char pattern = s.charAt(1);
		
		if(num =='A'){
			result =140;
		}else if(num=='T'){
			result =100;
		}else if(num=='J'){
			result =110;
		}else if(num=='Q'){
			result =120;
		}else if(num=='K'){
			result =130;
		}else{
			result= (num-'0')*10;
		}
		
		if(pattern =='C'){
			result +=1;
		}else if(pattern =='D'){
			result +=2;
		}else if(pattern =='H'){
			result +=3;
		}else if(pattern =='S'){
			result +=4;
		}
		
		return result;
					
	}
	
	public static int cardRank(int arr[]){
		int result = 0;
		if(arr[0]/10 == arr[1]/10){
			result=30000+arr[0]/10;		
		}else if(arr[1]/10 ==arr[2]/10){
			result=30000+arr[1]/10;
		}else if(arr[2]/10 == arr[3]/10){
			result=30000+arr[2]/10;
		}else if(arr[3]/10 == arr[4]/10){
			result=30000+arr[3]/10;
		}
		
		
		if(arr[0]/10==arr[1]/10 && arr[2]/10 ==arr[3]/10){
			result =40000+(arr[2]/10)*100+arr[0]/10;
		}else if(arr[0]/10 ==arr[1]/10 && arr[3]/10 ==arr[4]/10){
			result = 40000+(arr[3]/10)*100+arr[0]/10;
		}else if(arr[1]/10 == arr[2]/10 && arr[3]/10 == arr[4]/10){
			result = 40000+(arr[3]/10)*100+arr[1]/10;
		}
		
		
		
		if(arr[0]/10 == arr[2]/10){
			result = 50000+arr[0]/10;
		}else if(arr[1]/10 == arr[3]/10){
			result = 50000+arr[1]/10;
		}else if(arr[2]/10 == arr[4]/10){
			result = 50000+arr[2]/10;
		}
	
		if(cardFlush(arr)==true){
			result=70000;
		}

		if(cardStraight(arr)==true){
			result=60000;
		}
		
		if(cardFlush(arr)==true &&cardStraight(arr)==true){
			result=100000;
		}
	
		if(arr[0]/10 == arr[3]/10){
			result = 90000+arr[0]/10;
		}else if(arr[1]/10==arr[4]/10){
			result = 90000+arr[4]/10;
		}
		
	
		
		if(arr[0]/10 == arr[1]/10 && arr[2]/10 ==arr[3]/10 && arr[3]/10 ==arr[4]/10){
			result=80000+(arr[2]/10)*100+arr[0]/10;
		}else if(arr[0]/10 == arr[1]/10 && arr[1]/10 == arr[2]/10 && arr[3]/10 ==arr[4]/10){
			result=80000+(arr[0]/10)*100+arr[4]/10;
		}
	
		return result;
	}
	
	public static boolean cardFlush(int arr[]){
		if(arr[0]%10 ==arr[1]%10 && arr[1]%10 ==arr[2]%10 && arr[2]%10 == arr[3]%10 && arr[3]%10 == arr[4]%10){
			return true;
		}
		return false;
		
	}
	
	public static boolean cardStraight(int arr[]){
		if(arr[0]/10 +1 == arr[1]/10 &&arr[1]/10+1==arr[2]/10 &&arr[2]/10 +1 == arr[3]/10 && arr[3]/10 +1 == arr[4]/10){
			return true;
		}else if( arr[0]/10 == arr[1]/10
						 && arr[1]/10 == arr[2]/10 
						 && arr[2]/10 == arr[3]/10 
						 && arr[4]/10 == 14){
			return true;
		}
		return false;
	}


}