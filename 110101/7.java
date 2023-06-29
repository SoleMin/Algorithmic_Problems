import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		long lbound, ubound, lbOrg, ubOrg, temp;
		long i, j, length, max_length;
		
		while((input = br.readLine()) != null)
		{
			String[] arr = input.split(" ");
			lbound = Long.parseLong(arr[0]);
			ubound = Long.parseLong(arr[1]);
			
			lbOrg = lbound;
			ubOrg = ubound;
			
			if(lbound > ubound)
			{
				temp = lbound;
				lbound = ubound;
				ubound = temp;
			}
			
			max_length = 0;
			for(i = lbound; i <= ubound; i++)
			{
				j = i;
				length = 1;
				while(j != 1)
				{
					if(j % 2 == 1)
					{
						j = j * 3 + 1;
						length++;
					}
					while(j % 2 == 0)
					{
						j >>= 1;
						length++;
					}
				}
				if(length > max_length)
					max_length = length;
			}
			System.out.println(lbOrg + " " + ubOrg + " " + max_length);
		}
	}
}