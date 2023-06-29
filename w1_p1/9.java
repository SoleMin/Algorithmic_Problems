import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String input = br.readLine();
		//System.out.println("Hello Goorm! Your input is " + input);
		String input = null;
		while((input = br.readLine())!=null)
		{
		int words = 0, letters = 0;
		for(int i = 0; i < input.length(); i++)
		{
			if((i == 0 && (input.charAt(i) != ' ' && input.charAt(i) != '\t')) || i > 0 && (input.charAt(i-1) == ' ' || input.charAt(i-1) == '\t') && (input.charAt(i) != ' ' && input.charAt(i) != '\t'))
				words++;
			if(input.charAt(i) != '\t' && input.charAt(i) != ' ')
				letters++;
		}
		System.out.println(letters + " " + words);
		}
	}
}