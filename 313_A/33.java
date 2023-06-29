import java.io.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
public class A {
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String ln=in.readLine().trim();
		System.out.println(max(parseInt(ln),max(parseInt(ln.substring(0,ln.length()-1)),parseInt(ln.substring(0, ln.length()-2)+ln.substring(ln.length()-1)))));
	}
}
