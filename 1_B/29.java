import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static HashMap<Character, Integer> val = new HashMap<Character, Integer>();
	static HashMap<Integer, Character> ch = new HashMap<Integer, Character>();
	static StringBuffer strcol = new StringBuffer();
	static String s;
	
	static boolean isDigit(char a)
	{
		boolean found = false;
		for (int i = 0; i < digits.length; i++)
		{
			if (found = a == digits[i]) break;
		}
		
		return found;
	}
    static String ABtoRC(int pos)
	{
		do 
		{
			++pos; 
		} 
		while(!isDigit(s.charAt(pos)));
	
		int res = 0;
		for (int i = pos - 1, pow = 1; i >= 0; i--, pow *= 26) 
		{
			res += val.get(s.charAt(i)) * pow;
		}
		
		return new String("R" + s.substring(pos, s.length()) + "C" + String.valueOf(res));
	}
	
	static String RCtoAB(int cpos)
	{
		int col = Integer.valueOf(s.substring(cpos + 1, s.length()));
		int mod = 0;
		strcol.delete(0, strcol.length());
		
		while (col >= 26) 
		{
			int tmp = col / 26;
			mod = col - 26 * tmp;
			if (mod == 0) 
			{
				mod += 26;
				tmp -= 1;
				
			}
			col = tmp;
			strcol.append(ch.get(mod));
		}
		if(col != 0)strcol.append(ch.get(col));
		strcol.reverse();
		
		return strcol.toString() + s.substring(1, cpos); 
	}
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new FileReader("input.txt"));
//		PrintWriter output = new PrintWriter(new FileWriter("output.txt"));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(System.out));
		StreamTokenizer in = new StreamTokenizer(input);
		in.nextToken();
		int n = (int)in.nval;
		
		for (int i = 0; i < 26; i++) 
		{
			val.put((char)('A' + i), i + 1);
		}
		
		for (int i = 0; i < 26; i++) 
		{
			ch.put(i + 1, (char)('A' + i));
		}
		
		input.readLine();
		for (int i = 0; i < n; i++) {
			s = input.readLine();
			int cpos;
			if( ((cpos = s.indexOf('C')) > 1) && (isDigit(s.charAt(cpos - 1))) ) 
			{
				output.println(RCtoAB(cpos)); 
			}
			else
			{
				output.println(ABtoRC(cpos));
			}
		}
		
		output.close();
		input.close();
	}
}
