import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		String str, str1, str2;
		int[] s1 = new int[101];
		int[] s2 = new int[101];
		int[] s3 = new int[101];
		int[] a = new int[101];
		int[] b = new int[101];
		//n=피보나치수 f(n)의 길이, n1=a의 길이, n2=b의 길이
		//over은 피보나치수를 더할때 각 자리수에서 10단위 오버플로가 발생하는지 알려줌
		//min이 1이면 최소값인 a를 피보나치수 f(n)이 넘어섰다는 것임
		//result는 피보나치수의 개수
		//stop이 1이면 최대값인 b를 넘어섰다는 것임
		int index,i,n1,n2,over,n,min;
		int result;
		int stop;
		
		while(scan.hasNextLine()){
			result=0; stop=0; over=0; min=0;
			for(i=0;i<101;i++){
				s1[i]=0; s2[i]=0; s3[i]=0;
				if(i==0){s1[i]=1; s2[i]=2;}
			}
			
			str=scan.nextLine();
			//입력받은 문자열을 두개의 문자열로 분리
			index=str.indexOf(" ");
		  str1=str.substring(0,index);
			str2=str.substring(index+1);
			//둘다 0이면 종료
			if(str1.equals("0")&&str2.equals("0")) break;
			//문자열 두개를 숫자로 변환하여 배열에 한자리씩 저장
			for(i=0;i<str1.length();i++){
				a[i]=str1.charAt(str1.length()-i-1)-'0';
			}
			for(i=0;i<str2.length();i++){
				b[i]=str2.charAt(str2.length()-i-1)-'0';
			}
			n1=str1.length();
			n2=str2.length();
			//1과 2인 경우
			if(n1==1){
				if(a[0]==1){
					result=result+2; min=1;
				}
				if(a[0]==2){
					result++; min=1;
				}
			}
			
			n=1;
			while(stop==0){
				over=0;
				//f(1)+f(2) = f(3)
				for(i=0;i<n;i++){
					if(over==1){
						s3[i] = s1[i]+s2[i]+1;
					}else{
						s3[i] = s1[i]+s2[i];
					}
					if(s3[i]/10>0){
						over=1;
						s3[i]=s3[i]%10;
					}else{
						over=0;
					}
					if(over==1 && i==n-1){
						n++;
					}
				}
				//f(1)=f(2) f(2)=f(3)
				for(i=0;i<n;i++){
					s1[i]=s2[i];
					s2[i]=s3[i];
				}
			
				//s3[]과 b[]비교
				if(n>n2){
					stop=1;
					break;
				}else if(n==n2){
					for(i=n2-1;i>=0;i--){
						if(s3[i]<b[i]) break;
						else if(s3[i]>b[i]) {stop=1; break;}
					}
				}
				if(stop==1) break; //b[]를 넘어섰다면 끝내기
				
				//만약 최소값 a를 넘어섰다면 바로 result++
				if(min==1){result++;}
				else{
				if(n>n1){
					result++;
				}else if(n==n1){
					for(i=n1-1;i>=0;i--){
						if(s3[i]>a[i]){
							result++; min=1; break;
						}else if(s3[i]<a[i]){
							break;
						}else if(i==0 && a[i]==s3[i]){
							result++; min=1;
						}
					}
				}
				}
			}
			System.out.println(result);
		}
	}
}