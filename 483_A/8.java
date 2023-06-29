import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author таня
 */
public class KF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
  B jk = new B();
    }
}


class B {

    PrintWriter out = new PrintWriter(System.out);
    Scanner in = new Scanner(System.in);
    long l = in.nextLong();
    long r=in.nextLong();
B(){
if(Math.abs(r-l)>=2){
if(l%2==0){
out.print(l+" "+(l+1)+" "+(l+2));
}
else{
if(Math.abs(r-l)==2){
out.print("-1");
}else{
out.print((l+1)+" "+(l+2)+" "+(l+3));
}
}
}else{
out.print("-1");
}
out.flush();
}
}
