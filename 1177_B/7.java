/**
 * @(#)DigitSequence.java
 *
 *
 * @author
 * @version 1.00 2019/6/1
 */
import java.io.*;
import java.util.*;
public class DigitSequence {

    /**
     * Creates a new instance of <code>DigitSequence</code>.
     */
    public DigitSequence() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long k=in.nextLong();
        long[] end=new long[12];
        end[0]=-1;
        for (int i=1; i<end.length; i++) {
        	end[i]=(i*(long)(Math.pow(10,i)));
        	end[i]-=(((long)(Math.pow(10,i))-1)/9);
        }
        //System.out.println(Arrays.toString(end));
        int st=0;//st=1 {0,9}; st=2 {10, 189}; st=3 {190-2889}; st=4 {2890-38889}
       	for (int i=1; i<end.length; i++) {
       		if (k>=end[i-1]+1 && k<=end[i]) st=i;
       	}
       	//System.out.println("st " + st);
       	long diff=k-end[st-1];
       	long mod=((diff+st-1)%st);
       	//System.out.println(mod);
       	long digit=-1;

       	int addOn=0;
       	if (mod==0) addOn=1;
       	if (mod==st-1) addOn=-1;
       	digit=(diff/(st*(long)(Math.pow(10,st-1-mod))));
       	digit+=addOn;
       	digit%=10;
       	System.out.println(digit);
       	//98888888889
       	//98888888879
       	//1088888888889
       	//1088888888878
    }
}
