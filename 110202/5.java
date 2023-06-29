import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		int[] black = new int[5];
		int[] white = new int[5];
		int blackV, whiteV;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line= br.readLine())!=null){
		StringTokenizer st= new StringTokenizer(line);
		for(int i=0; i<10; i++){
			if(i<5)
				black[i]=trans(st.nextToken());
			else
				white[i-5]=trans(st.nextToken());
		}
			
		
		blackV = getValue(black);
		whiteV= getValue(white);
		int result =0;
		
		
		if(blackV>whiteV)
			System.out.println("Black wins.");
		else if(blackV<whiteV)
			System.out.println("White wins.");
		else{
			switch(blackV){
				case 5 : 
				case 0 :
					int i=0;
					while(true){
						if(i==5||result!=0)
							break;
						result =compare(black[i]/10,white[i]/10);
						i++;
					}
					break;
				case 2:
					result = compare(black[1]/10,white[1]/10);
					if(result ==0){
						result = compare(black[3]/10,white[3]/10);
						if(result ==0)
							result = compare(black[0]/10,white[0]/10);
					}
					break;
				case 1:
					int bp=0, wp=0;
					for(int j=0;j<5; j++){
						if(black[j]%10 ==5)
							bp =j;
						if(white[j]%10 ==5)
							wp =j;
					}
					result = compare(black[bp]/10,white[wp]/10);
					if(result ==0){
						int bi=0,wi=0;
						while(true){
							if(bi == bp-1)
								bi+=2;
							if(wi == wp-1)
								wi+=2;
							result = compare(black[bi]/10,white[wi]/10);
							if(result != 0)
								break;
							else{
								bi++;
								wi++;
							}
							if(bi==5||wi==5)
								break;
						}
					}
					break;
				default :
					result = compare(black[0]/10,white[0]/10);
					break;
			}
			if(result ==-1)
				System.out.println("Black wins.");
			else if(result ==1)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
					
		}
	

}
public static int compare(int n1, int n2){

	if(n1>n2)
		return -1;
	else if(n1<n2)
		return 1;
	else
		return 0;
}
public static int trans(String poker){
	char number = poker.charAt(0);
	char shape = poker.charAt(1);
	int result;
	
	switch(number){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (number-'0')*10;
	}
	switch(shape){
		case 'H' : result += 1; break;
		case 'D' : result += 2; break;
		case 'S' : result += 3; break;
		case 'C' : result += 4; break;
	}
	return result;
	
}

public static int getValue(int[] hand){

	int[] number = new int[13];
	int[] shape = new int[4];
	int temp=0;
	int max =0;
	for(int i=0; i<4; i++){
		max =i;
		for(int j=i+1; j<5;j++)
			if(hand[j]>hand[max])
				max = j;
		temp = hand[i];
		hand[i]= hand[max];
		hand[max]=temp;
	}
	
	for(int i =0; i<number.length;i++)
		number[i]=0;
	for(int i =0; i<shape.length;i++)
		shape[i]=0;
	
	
	for(int i =0; i<5;i++){
		number[hand[i]/10-2]++;
		shape[hand[i]%10-1]++;
	}
	
	//straight flush
	for(int i =0; i<shape.length;i++)
		if(shape[i]==5){
			for(int j =0; j<number.length;j++){
				if(number[j%13]==1&&number[(j+1)%13]==1&&number[(j+2)%13]==1&&number[(j+3)%13]==1&&number[(j+4)%13]==1)
					return 8;
			}
		}
	
	//four card
	for(int i=0; i<number.length;i++)
		if(number[i]==4){
			hand[0]=(i+2)*10;//비교를 쉽게하기 위해 동일한 족보일경우 비교할 대상을 인덱스0에 넣어주었습니다. 숫자만 비교함으로 모양부분은 생략합니다
			return 7;
		}
	
	//full house
	for(int i=0; i<number.length;i++)
		if(number[i]==3){
			for(int j=0; j<number.length;j++)
				if(number[j]==2){
					hand[0]=(i+2)*10;
					return 6;
				}
		}
	
	//flush
	for(int i=0; i<shape.length;i++)
		if(shape[i]==5)
			return 5;
	
	//straight
	for(int i =0 ;i<number.length;i++)
		if(number[i%13]==1&&number[(i+1)%13]==1&&number[(i+2)%13]==1&&number[(i+3)%13]==1&&number[(i+4)%13]==1)
			return 4;

	//three card
	for(int i =0; i<number.length;i++){
		if(number[i]==3){
			hand[0]=(i+2)*10;
			return 3;
		}
	}
	
	//two pare& one pare
	int pareCheck =0;

	for(int i =0; i<number.length;i++){
		if(number[i]==2){
			pareCheck++;
			for(int j=0;j<5;j++){
				if(hand[j]/10==i+2)
					hand[j]=(hand[j]/10)*10 +5; //모양부분을 삭제하고 pare임을 표시.one pare 비교시 사용합니다.
			}
		}
		else if(number[i]==1)
			temp = i;
	}
	if(pareCheck==2){
		hand[0] = (temp+2)*10; //two pare일경우 첫쌍의 숫자는 반드시 1인덱스에, 두번째 쌍의 숫자는 반드시 3인덱스에 남게 됩니다. 따라서 페어가 아닌 숫자를 0인덱스에 넣어 비교하기 쉽게 합니다.
			return 2;
	}
	if(pareCheck==1){
		return 1;
	}
		
	//high card
	return 0;
}
	
}