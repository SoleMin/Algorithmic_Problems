import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder circuit = new StringBuilder();
		
		while(sc.hasNextLine()){
			String input= sc.nextLine();
			if(!input.equals(""))
				circuit.append(input).append(" ");
			if(input.equals("") || !sc.hasNextLine()){
				StringBuilder start= new StringBuilder();
				int i=0;
				if (circuit.charAt(i) == ' ') {
					do {
						start.append(circuit.charAt(i));
						i++;
					} while (circuit.charAt(i) == ' ');
				}
				
				String output="";
				output+=start;
				circuit = new StringBuilder(circuit.toString().trim());
				check_circuit(circuit, output);
				circuit = new StringBuilder();
				System.out.println("");
			}
		}
	}
	
	public static void check_circuit(StringBuilder circuit, String output) {
		String[] line_split = circuit.toString().split(" ");
		if (line_split.length != 1) {
			for(int i=0; i<line_split.length;i++){
				if((output.length() + (line_split[i].length()+1)) >72 && i==line_split.length-1){
					System.out.println(output);
					System.out.println(line_split[i]);
				}
				else if((output.length() + (line_split[i].length()+1)) >72 && i==0){
					output=line_split[i];
				}
				
				else if(i==line_split.length-1){
					output+=" "+line_split[i];
					System.out.println(output);
				}
				
				else if((output.length() + (line_split[i].length()+1)) <=72 && i==0){
					output+=line_split[i];
				}
				
				else if((output.length() + (line_split[i].length()+1)) <=72){
					output+=" "+line_split[i];
				}
				
				else{
					System.out.println(output);
					output=line_split[i];
				}
			}
		}
		else {
			System.out.println(circuit);
		}
	}
}