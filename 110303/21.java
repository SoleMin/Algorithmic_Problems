import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String firstS = input.nextLine();
			String secondS = input.nextLine();
			
			String[] first = firstS.split("");
			String[] second = secondS.split("");
			
			List<String> dulpliS = new ArrayList<String>();
			
			for(int i=0; i<first.length; i++){
				String find = first[i];
				if(Arrays.asList(second).contains(find)){
					int indexI = Arrays.asList(second).indexOf(find);
					
					second[indexI] = null;
					dulpliS.add(find);
				}
			}
			
			Collections.sort(dulpliS);
			
			for(int i=0; i<dulpliS.size(); i++){
				System.out.print(dulpliS.get(i));
			}
			System.out.println();
		}
		input.close();
	}
}