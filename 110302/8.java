import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for(int i=0; i<n ; i++){
			scanner.nextLine();
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			scanner.nextLine();
			
			String [] line = new String[rows];
			
			for(int j=0; j<rows; j++){
				line[j]=scanner.nextLine().toLowerCase();
			}
			
			int output = scanner.nextInt();
			scanner.nextLine();
			
			for(int j=0; j<output;j++){
				String name= scanner.nextLine().toLowerCase();
	
				
				int output_r=-1;
				int output_c=-1;
				
				for(int row=0; row<rows;row++){
					for(int column=0; column< columns; column++){
						
						if(line[row].charAt(column) == name.charAt(0)){
							//System.out.print((row+1)+" "+(column+1)+"->");
							int leng = name.length();
							boolean up    = (row+1)  >= leng;
							boolean left  = (column+1) >= leng;
							boolean right = (columns-column) >= leng;
							boolean down  = (rows-row) >= leng;
							
							if(up){
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row-k].charAt(column)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
								
							}
							if(left){
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row].charAt(column-k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
								
							}
							if(right){
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row].charAt(column+k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
							}
							if(down){
								
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row+k].charAt(column)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
								
							}
							if(up && left){
								
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row-k].charAt(column-k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
								
							}
							if(up&&right){
								
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row-k].charAt(column+k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
								
							}
							if(down&&left){
								
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row+k].charAt(column-k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
							
							}
							if(down && right){
								
								boolean is_found = true;
								for(int k=0; k<leng;k++){
									if(name.charAt(k)!=line[row+k].charAt(column+k)){
									 	is_found = false; break;
									}
								}
								if(is_found){
									output_r= row +1;
									output_c =column+1;
									break;
								}
							
							}
							
							
						}
						
					}
					if(output_r!=-1 && output_c!=-1)
						break;				 
										 
				}
				
				System.out.println(output_r +" "+ output_c);
				
				
				
				
			}
			
			
			System.out.println("");
			
		}
		
		
	}
}