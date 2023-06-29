import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input= new Scanner(System.in);
		int testcase=input.nextInt();
		
		input.nextLine();
		
	 for(int i=0;i<testcase;i++){
		 int n=input.nextInt();  //섞기 방법 개수, 다음 n개의 세트가 나옴.
		 
		 
			int[][] set=new int[n][52];
			 
			 for(int j=0;j<n;j++){
				 for(int p=0;p<52;p++){
				     set[j][p]=input.nextInt()-1;
				 }//배열은 0부터시작하기 때문
			 }
			 input.nextLine();
		 //오리지널 카드 만들기
		 String[] card=new String[52];
		 
		 String[] nums={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		 String[] mark={"Clubs","Diamonds","Hearts","Spades"};
		 int index=0;
		 for(int j=0;j<4;j++){
			 for(int p=0;p<13;p++){
				 card[index++]=nums[p]+" of "+mark[j];
				 }
		 }
		 
		 int[] mixed_order=new int[52]; //섞어진 카드의 순서
		 //기본값 할당
		 for(int j=0;j<52;j++)
			 mixed_order[j]=j;
		 
		 while(input.hasNextLine()){
			 String k=input.nextLine();
			 //set[(k-1)][]사용
			 if(k.equals("")){			 				 
				 break;
			 }else{//주어진 패턴으로 카드 섞기
				 int knum=Integer.parseInt(k)-1;
				 int[] new_order=new int[52]; //중간값 저장
				 for(int j=0;j<52;j++){
				    new_order[j]=mixed_order[set[knum][j]];}
				mixed_order=new_order;
			 }			 
		 }
		 
		 
		 //출력하기
		 for(int j=0;j<52;j++){
			 System.out.println(card[mixed_order[j]]);
		 }
			 
		System.out.println();	 
	 }
		
	}
}