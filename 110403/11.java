import java.util.*;
import java.text.DecimalFormat;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = Integer.parseInt(input.nextLine());
		for(int i=0; i<testcase; i++) {
			String newline = input.nextLine();
			int n = Integer.parseInt(input.nextLine());
			
			ArrayList<Double> list = new ArrayList<>();
			for(int j=0; j<n; j++)
				list.add(Double.parseDouble(input.nextLine()));
			
			Collections.sort(list);
			
			double result = 0;
			double i0 = list.get(0);
			double i1 = 0;
			if(list.size() != 1) i1 = list.get(1);
			while(list.size() > 0) {
				if(list.size() == 1) {
					result = i0;
					list.remove(list.get(0));
				}
				else {
					if(list.size() == 2) {
						result += list.get(1);
						list.remove(list.get(1));
						list.remove(list.get(0));
					}
					else if(list.size() == 3) {
						result += i0 + i1 + list.get(2);
						list.remove(list.get(2));
						list.remove(list.get(1));
						list.remove(list.get(0));
					}
					else {
						double ix = list.get(list.size()-2);
						double iy = list.get(list.size()-1);
						double case1 = i1 + i1;
						double case2 = i0 + ix;

						if(case1 < case2) {
							result += i1;
							list.remove(1);

							result += i0;

							result += iy;
							list.remove(list.size()-2);
							list.remove(list.size()-1);

							result += i1;
							list.add(1,i1);
						}
						else {
							result += ix + i0;
							result += iy + i0;
							list.remove(list.size()-2);
							list.remove(list.size()-1);
						}
					}
				}
			}
			
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(df.format(result) + "\n");
		}
	}
}