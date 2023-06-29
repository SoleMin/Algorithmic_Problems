import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Comparator;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		sc.skip("\n");
		sc.nextLine(); 
		
		for(int i = 0; i < testcase; i++) {
			int[][] incorrect = new int[101][10];
			int[][] correct = new int[101][10];
			List<String> info_list = new ArrayList<>();
			List<Integer> team_num = new ArrayList<>();
			List<Integer> result = new ArrayList<>();
			List<List<Integer>> result_list = new LinkedList<>();
			
			while(sc.hasNextLine()) {
				String info = sc.nextLine();
				if(info.isEmpty())
					break;
				info_list.add(info);
			}
			
			
			info_list.stream().mapToInt(s -> {
				String[] temp = s.split(" ");
				return (Integer.parseInt(temp[0]));
			}).distinct().forEach(n -> {
				team_num.add(n);
				for(int column = 0; column < incorrect[n].length; column++) {
					incorrect[n][column] = 0;
				}
				for(int column = 0; column < correct[n].length; column++) {
					correct[n][column] = -1;
				}
			});
			
			
			for(String info : info_list) {
				String[] info_a  = info.split(" ");
				
				int row = Integer.parseInt(info_a[0]);
				int column = Integer.parseInt(info_a[1]);
				
				if(info.endsWith(" I")) {	
					if(correct[row][column] == -1) {
						incorrect[row][column] += 20;
					}
				}
				else if (info.endsWith(" C")){
					if(correct[row][column] == -1) {
						int time = Integer.parseInt(info_a[2]);
						correct[row][column] = time;
					}
				}
			}
			
			for(int team : team_num) {
				for(int q = 1; q < correct[team].length; q++) {
					if(incorrect[team][q] != 0 && correct[team][q] == -1) {
						incorrect[team][q] = 0;
					}
				}
			}
				
			for(int team : team_num) {
				int c_count = (int)Arrays.stream(correct[team]).filter(n-> n >= 0).count();
				int p_time = 0;
				if(c_count > 0 ) {
					p_time = Arrays.stream(incorrect[team]).parallel().sum() +
						Arrays.stream(correct[team]).filter(n -> n >= 0).parallel().sum();
				}
				result.add(Integer.valueOf(team));
				result.add(Integer.valueOf(c_count));
				result.add(Integer.valueOf(p_time));
				result_list.add(new ArrayList<>(result));
				result.clear();
			}
			
			result_list.stream().sorted(new Comparator<>() {
				public int compare(List<Integer> l1, List<Integer> l2) {
					if(l1.get(1) != l2.get(1))
						return l2.get(1) - l1.get(1);
					else {
						if(l1.get(2) != l2.get(2)) 
							return l1.get(2) - l2.get(2);
						else {
							return l1.get(0) - l2.get(0);
						}
					}
				}
			}).forEach(list -> {
				for(Integer res : list) {
					System.out.printf("%d ",res.intValue());
				}
				System.out.println();
			});
			System.out.println();
		
	
			
			
		}
		 
	}
}