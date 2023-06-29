import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ToyArmy {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n / 2 * 3);
	}

}
