import java.util.Scanner;

public class Main2 {
	
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        long s = input.nextLong();
        long e = input.nextLong();
        System.out.println(count(s,e));
    }
    
    public static long count(long s,long e){
    	int ncount = 0;
    	long es = e;
    	while(es != 0){
    		es /= 2;
    		ncount++;
    	}
    	while(ncount >= 0){
    		if(((s>>ncount-1)&1) == 1 && ((e>>ncount-1)&1) == 0 || ((s>>ncount-1)&1) == 0 && ((e>>ncount-1)&1) == 1){
    			break;
    		}
    		ncount--;
    	}
    	if(ncount >= 0){
    		return (long)Math.pow(2, ncount)-1;
    	}else{
    		return 0;
    	}
    }

}