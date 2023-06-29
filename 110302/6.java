import java.util.ArrayList;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		input.nextLine();
		input.nextLine();
		ArrayList<int[]> arraylist = new ArrayList<>();
		for(int j =0;j<testCase;j++){
			
			int m = input.nextInt();
			int n = input.nextInt();
			char[][] chars = new char[m][n];
			input.nextLine();
			for(int i =0;i<m;i++){
				String line = input.nextLine();
				for(int k =0;k<n;k++){
					chars[i][k] = line.charAt(k);
				}
			}
			int number = input.nextInt();
			input.nextLine();
			String[] name = new String[number];
			for(int i=0;i<number;i++){
				name[i] = input.nextLine();
			}
			int[] index = new int[2*number];
			int count=0;
			int h=0;
			for(int i=0;i<number;i++){
				loop:
				for(int k=0;k<m;k++){
					for(int t=0;t<n;t++){
						if(Character.toString(chars[k][t]).equalsIgnoreCase(Character.toString(name[i].charAt(0)))){
							if(Waldorf(chars,name[i],m,n,k,t)==true){
								index[h] =k+1;
								index[h+1]=t+1;
								h=h+2;
								break loop;
							}
						}
					}
				}
			}
			arraylist.add(index);
			if(j!=testCase-1) input.nextLine();
		}
		for(int i=0;i<arraylist.size();i++){
			for(int j=0;j<arraylist.get(i).length;j=j+2){
				System.out.println(arraylist.get(i)[j]+" "+arraylist.get(i)[j+1]);
			}
			if(i!=arraylist.size()-1) System.out.println();
		}
	}
	private static boolean Waldorf(char[][] chars,String name,int m,int n,int k,int t){
		String word="";
		
		if(n-t+1>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word +=chars[i][j++];
			
			if(word.equalsIgnoreCase(name))
				return true;
			word="";
		}
		if(m-k+1>name.length()&&n-t+1>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i++][j++];
			
			if(word.equalsIgnoreCase(name))
				return true;
			word ="";
		}
		if(m-k+1>name.length()){
			int i=k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i++][j];
			if(word.equalsIgnoreCase(name))
				return true;
			word="";
		}
		if(t+2>name.length()){
			int i=k;
			int j=t;
		for(int h=0;h<name.length();h++)
			word+=chars[i][j--];
		if(word.equalsIgnoreCase(name))
			return true;
			word="";
		}
		if(t+2>name.length()&&m-k+1>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i++][j--];
			if(word.equalsIgnoreCase(name))
				return true;
			word="";
		}
		if(k+2>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i--][j];
			if(word.equalsIgnoreCase(name))
				return true;
			word="";
		}
		if(k+2>name.length()&&t+2>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i--][j--];
			if(word.equalsIgnoreCase(name))
				return true;
			word="";
		}
		if(k+2>name.length()&&n-t+1>name.length()){
			int i =k;
			int j=t;
			for(int h=0;h<name.length();h++)
				word+=chars[i--][j++];
			if(word.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
}