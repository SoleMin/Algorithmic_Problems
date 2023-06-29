import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][]=new int[4][2];
		int n=sc.nextInt();
		for(int i=0;i<4;i++) {			
			for(int k=0;k<n;k++) {
				String str=sc.next();
				char b[]=str.toCharArray();
				for(int j=0;j<n;j++) {
					int c = (int)b[j]-48;
					int e = j+k%2;
				    if(c==e%2) {
					  a[i][0]++;
				    }else {
				    	a[i][1]++;				
				    }
				}
			}
		}
		int d[] = new int[6];
		d[0]=a[0][0]+a[1][0]+a[2][1]+a[3][1];
		d[1]=a[0][0]+a[1][1]+a[2][0]+a[3][1];
		d[2]=a[0][0]+a[1][1]+a[2][1]+a[3][0];
		d[3]=a[0][1]+a[1][0]+a[2][0]+a[3][1];
		d[4]=a[0][1]+a[1][0]+a[2][1]+a[3][0];
		d[5]=a[0][1]+a[1][1]+a[2][0]+a[3][0];
		int min=d[0];
		for(int i=0;i<6;i++) {
			if(d[i]<min) {
				min=d[i];
			}
		}
		System.out.println(min);
	}
}