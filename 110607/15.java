import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String buf;
		int number, repeat, sum, change;
		int [] arr = new int [20000000];
		arr[1] = 1;
		arr[2] = 2;
		repeat = 2;
		change = 3;
		for (int i = 3; i < 20000000; i++)
		{
			arr[i] =repeat;
			if (i == change)
				change += arr[++repeat];
		}
		while((buf = input.readLine()) != null)
		{
			number = Integer.parseInt(buf);
			if (number ==0)
				break;
			else if (number == 1 || number == 2){
				System.out.println(number);
				continue;
			}
			else if (number == 3){
				System.out.println(2);
				continue;
			}
			sum = 3;
			for (int i = 3; i <20000000; i++)
			{
				sum += arr[i];
				if (sum >= number){
					System.out.println(i);
					break;
				}
			}
		}
	}
}