import java.util.Scanner;


public final class b1 {

	public static void main(String[] args) {
		Scanner datain = new Scanner(System.in);
		long l=datain.nextLong();
		long r=datain.nextLong();
		if(r-l<2){System.out.print(-1);}else{
			if(((r-l)==2)&&(l%2==1)){System.out.print(-1);}else{
				if((l%2)==0){System.out.print(""+l+" "+(l+1)+" "+(l+2));}else{
					System.out.print(""+(l+1)+" "+(l+2)+" "+(l+3));
				}
			}
		}
	}

}
