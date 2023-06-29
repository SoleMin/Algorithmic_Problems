import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
	
		while((input = br.readLine()) != null)
		{
			int wordcnt = 0, lettercnt = 0;
			
			for(int i = 0; i < input.length(); i++)
			{
				if(input.charAt(i) != ' ' && input.charAt(i) != '\t' && input.charAt(i) != '\n')
					lettercnt++;
			}
			
			String [] word = input.split(" |\t|\rn");
			for(int i = 0; i<word.length; i++)
				if(!word[i].isEmpty())
					wordcnt++;
			
			System.out.print(lettercnt + " ");
			System.out.println(wordcnt);
		}
	}
}