import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int limit = 72;
		String temp = "";
		while(in.hasNextLine()){
			String input = in.nextLine();
			if(!input.equals("")){
				temp += input+" ";
			}
			if(input.equals("") || !in.hasNextLine()){
				String output = "";
				String arr[] = temp.split(" ");
				if(arr.length==1){
					System.out.println(temp);
				}
				else{
					for(int i=0; i<arr.length; i++){
						int len = output.length()+arr[i].length()+1;
						if(len>limit && (i==0 || i==arr.length-1)){
							if(i==0){
								output = arr[i];
							}
							if(i==arr.length-1){
								System.out.println(output+"\n"+arr[i]);
							}
						}
						else if(len<=limit){
							if(i!=0){
								output += " ";
							}
							output += arr[i];
							if(i==arr.length-1){
								System.out.println(output);
							}
						}
						else{
							System.out.println(output);
							output = arr[i];
						}
					}
				}
				temp = "";
				System.out.println();
			}
		}
	}
}