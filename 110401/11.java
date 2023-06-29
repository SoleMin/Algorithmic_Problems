import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = Integer.parseInt(input.nextLine());
		for(int i=0; i<testcase; i++) {
			String[] strArr = input.nextLine().split(" ");
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=1; j<strArr.length; j++)
				list.add(Integer.parseInt(strArr[j]));
			Collections.sort(list);
			
			int pivot = Integer.parseInt(strArr[0])/2-1;
			if(pivot == -1)
				System.out.println("0");
			else if(pivot == 0)
				if(strArr[0].equals("2"))
					System.out.println(Math.abs(list.get(0)-list.get(1)));
				else
					System.out.println(Math.abs(list.get(0)-list.get(1)) + Math.abs(list.get(1)-list.get(2)));
			else {
				int[] deviation = new int[list.size()-1];
				for(int j=0; j<deviation.length; j++)
					deviation[j] = Math.abs(list.get(j)-list.get(j+1));
				
				int result = 0;
				for(int j=pivot+1; j<deviation.length; j++)
					for(int k=j; k>pivot; k--)
						result += deviation[k];
				
				for(int j=pivot; j>=0; j--)
					for(int k=j; k<pivot+1; k++)
						result += deviation[k];
				
				System.out.println(result);
			}
		}
	}
}