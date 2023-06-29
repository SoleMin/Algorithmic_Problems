import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Test {
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	//StringTokenizer st=new StringTokenizer(bf.readLine());
	int n=Integer.parseInt(bf.readLine());
	
	if(n%2==0) System.out.println(4+" "+(n-4));
	else System.out.println(9+" "+(n-9));
	
}
}
