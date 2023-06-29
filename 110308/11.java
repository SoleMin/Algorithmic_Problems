import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			LinkedList<String> lines = new LinkedList<String>();
			
			while(input.hasNextLine()){
				String line = input.nextLine();
				
				if(line.equals("")){
					break;
				}
				
				else{
					lines.add(line);
				}
			}
			
			String allLine = "";
			
			Iterator<String> it = lines.iterator();
			while(it.hasNext()){
				allLine += it.next() + " ";
			}
			
			while(true){
				String newLine = " ";
				
				if(allLine.length()<72){
					break;
				}
				
				String until72 = allLine.substring(0,72);
				String space = "";
				for(int i=0; i<72; i++){
					space += " ";
				}
				
				if(until72.equals(space)){
					newLine = space;
					allLine = allLine.substring(72);
				}
				
				else if(!until72.contains(" ")){
					int index = 72;
					for(int j=0; j<allLine.length(); j++){
						if(allLine.charAt(72+j) == ' '){
							index = 72+j;
							break;
						}
					}
					newLine = allLine.substring(0, index);
					allLine = allLine.substring(index);
				}
				
				else if(allLine.charAt(71) == ' '){
					int index = 0;
					for(int j=71; j>=0; j--){
						if(allLine.charAt(j) != ' '){
							index = j;
							break;
						}
					}
					newLine = allLine.substring(0, index+1);
					allLine = allLine.substring(index+1);
				}
				
				else if(allLine.charAt(71) != ' '){
					int index = 0;
					if(allLine.charAt(72) == ' '){
						index = 71;
					}
					
					else{
						for(int j=71; j>=0; j--){
							if(allLine.charAt(j) == ' '){
								index = j;
								break;
							}
						}
						
						for(int j=index; j>=0; j--){
							if(allLine.charAt(j) != ' '){
								index = j;
								break;
							}
						}
					}
					newLine = allLine.substring(0, index+1);
					allLine = allLine.substring(index+1);
				}
				
				System.out.println(newLine);
				
				int index = 0;
				for(int i=0; i<allLine.length(); i++){
					if(allLine.charAt(i) != ' '){
						index = i;
						break;
					}
				}
				allLine = allLine.substring(index);
			}
			
			System.out.println(allLine.substring(0, allLine.length()-1));
			System.out.println();
		}
		
		input.close();
	}
}