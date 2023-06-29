import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String s=r.readLine();
		
		int n=Integer.parseInt(s);
		System.out.println(n*3/2);
	}
}
