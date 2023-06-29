import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n= scanner.nextInt();
		scanner.nextLine();
		for(int i=0; i<n;i++){
			scanner.nextLine();
			int result=0;
			int len= Integer.parseInt(scanner.nextLine());
		
			int [] dis = new int[len];
			for(int j=0; j<len; j++){
				dis[j]=Integer.parseInt(scanner.nextLine());
			}
			Arrays.sort(dis);
			if(len==0)
				result+=dis[0];
			else if(len == 1 )
				result+=dis[1];
			else if(len== 2)
				result+=dis[1]+dis[0]+dis[2];		
			else if( len>2){
				int j;
				for(j=len-1; j>=3; j= j-2){
					if(dis[1]*2+ dis[0]+dis[j]<2*dis[0]+dis[j]+dis[j-1])
						result= result+dis[1]+dis[0]+dis[j]+dis[1];
					else
						result= result+dis[j]+dis[0]+dis[j-1]+dis[0];
				}
				if(j==2)
					result= result+dis[1]+dis[0]+dis[2];
				else
					result= result+dis[1];
			}
			System.out.println(result);
			System.out.println("");
		}
		
	}
}