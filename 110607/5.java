import java.io.*;
import java.util.Scanner;

class Main {
	    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        
        while(true) {
        	long answer = 0;
        	long answerTwo = 0;
        	long realA = 0;
        	
        	long n = input.nextLong();
        	  
        	 if(n == 0) {
        	  break;
        	 }
        	 
        	 // f(n)의 위치를 담은 함수
        	 long[] ds = new long[1000000];
             ds[0] = 0;
             ds[1] = 1;
             ds[2] = 3;
             
             // f(n)위치 담기
             int check = 2;
             int index = 3;
             for (int i = 2; ds[i] < 1000001; i++) {
                 if (ds[check] < i + 1) {
                	 check++;
                   ds[index] = check + ds[i];
                   index++;
                 }
                 else {
                	 ds[index] = check + ds[i];
                   index++;
                 }
             }
             
             // 위치랑 그 위치일 때 값 매칭
             class gol{
            	 long point;
            	 long answer;
            	 
            	 public gol(long p, long a) {
            		 this.point = p;
            		 this.answer = a;
            	 }
             }
             
             // 위치랑 정답 매칭
             gol[] g = new gol[1000000];
             for(int i = 0; i < 1000000; i++) {
            	 g[i] = new gol(ds[i], i+1);
             }
             
             // f(n)값 탐색
             int ok = 1;
             for (long i = 1; i < 5000; i++) {
            	 if(n == 1) {
	            	 realA = 1;
	            	 break;
	             }
                 if (i > g[ok].point) {
                	 ok++;
                	 answerTwo += i * ok;
                   answer += ok;
                 }
                 else {
                	 answerTwo += i * ok;
                   answer += ok;
                 }
               
                  if (answerTwo == n && answerTwo >= n) {
                     realA = answer;
                     break;
                   }
                   else if (answerTwo >= n){
                    realA = answer - (answerTwo - n) / i;
                    break;
                  }
							 
             }
             
             System.out.println(realA);
        }
        
    }
}