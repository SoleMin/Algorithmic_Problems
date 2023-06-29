import java.util.Scanner;
class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long lbound, ubound,lbOrg,ubOrg,temp;
		long i, j, length, max_length;
		
		while(input.hasNextLong()){
		lbound = input.nextLong();
		ubound = input.nextLong();
		lbOrg= lbound;
		ubOrg= ubound;
		if(lbound>ubound){
			temp=lbound;
			lbound=ubound;
			ubound=temp;
		}
			max_length=0;
			for(i=lbound;i<=ubound;i++){
				j=i;
				length=1;
				while(j!=1){
					if(j%2==1){
						j=j*3+1;
						length++;
					}
					while(!(j%2==1)){
						j=j/2;
						length++;
					}
				}
				if(length>max_length)
					max_length=length;
				
			}
			System.out.printf("%d %d %d\n",lbOrg,ubOrg,max_length);
		}
}
}