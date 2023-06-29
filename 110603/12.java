import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int[] n = new int[1000];
		//long [][] f = new long [1000][1000];
		BigInteger[][] f = new BigInteger[1000][1000];
		BigInteger b = new BigInteger("0");
		int i,j=0,k,num;
		
		while(scan.hasNext()){
			n[j] = scan.nextInt();
			j++;
		}
		
		for(i=0;i<j;i++){
			//f[i][0]=2L; f[i][1]=5L; f[i][2]=13L; f[i][3]=33L;
			f[i][0]=b.add(BigInteger.valueOf(2)); f[i][1]=b.add(BigInteger.valueOf(5)); 
			f[i][2]=b.add(BigInteger.valueOf(13)); f[i][3]=b.add(BigInteger.valueOf(33));
			if(n[i]==1){
				System.out.println(2); continue;
			}else if(n[i]==2){
				System.out.println(5); continue;
			}else if(n[i]==3){
				System.out.println(13); continue;
			}else if(n[i]==4){
				System.out.println(33); continue;
			}else{
				for(k=4;k<n[i];k++){
					f[i][k]=f[i][k-1].multiply(BigInteger.valueOf(2));
					f[i][k]=f[i][k].add(f[i][k-2]);
					f[i][k]=f[i][k].add(f[i][k-3]);
					//f[i][k]=2*f[i][k-1]+f[i][k-2]+f[i][k-3];
				}
				System.out.println(f[i][k-1]);
			}
		}
		
	}
}