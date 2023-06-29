import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = input.nextInt();
		input.nextLine();
		
		for(int t=0; t<testcase;t++){
			
			input.nextLine();
			int n = input.nextInt();
			int m = input.nextInt();
			input.nextLine();
			
			String arr[] = new String[n];
			
			for(int i=0; i<n;i++){
				arr[i]=input.nextLine().toLowerCase();
			}
			
			int people = input.nextInt();
			input.nextLine();
			
			for(int p=0; p<people; p++){
				
				String name = input.nextLine().toLowerCase();
				
				int startn=-1;
				int startm=-1;
				
				for(int n2=0; n2<n; n2++){
					
					for(int m2=0; m2<m; m2++){
						
						if(startn != -1 && startm != -1){
							break;
						}
						
						int length = name.length();
						
						if(arr[n2].charAt(m2) == name.charAt(0)){
							int q=0;
							for(int k=0; k<length; k++){
								if(n2-k>=0 && name.charAt(k) == arr[n2-k].charAt(m2)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k =0; k<length; k++){
								if(n2+k<=n-1 && name.charAt(k) == arr[n2 +k].charAt(m2)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k=0; k<length;k++){
								if(m2-k>=0 && name.charAt(k) == arr[n2].charAt(m2-k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k=0;k<length;k++){
								if(m2+k<=m-1 && name.charAt(k) == arr[n2].charAt(m2+k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k=0;k<length;k++){
								if(n2-k>=0 && m2-k>=0 &&name.charAt(k) == arr[n2-k].charAt(m2-k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
									
								}
							}
							q=0;
							for(int k=0;k<length;k++){
								if(m2+k<=m-1 && n2+k<=n-1 && name.charAt(k)==arr[n2+k].charAt(m2+k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k=0;k<length;k++){
								if(n2-k>=0 && m2+k <=m-1 && name.charAt(k)==arr[n2-k].charAt(m2+k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							q=0;
							for(int k=0;k<length;k++){
								if(m2-k>=0 && n2+k<=n-1 && name.charAt(k)==arr[n2+k].charAt(m2-k)){
									q++;
								}
								if(q==length){
									startn=n2+1;
									startm=m2+1;
								}
							}
							
									
							
						}
						if(startn != -1 && startm != -1){
							break;
						}
						
					}

				}
				System.out.println(startn+" "+startm);
			}
			
			System.out.println();
		
		}
	
	}
}