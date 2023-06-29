import java.util.*;
import java.io.*;
 

 public class SolutionC{
       public static void main(String[] args) throws Exception{
               Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
       int t=sc.nextInt();
       int[] arr=new int[10000002];
       for(int i=0;i<arr.length;i++){
           arr[i]=i;
       }
       for(int i=2;i*i<arr.length;i++){
           int b=i*i;
          for(int j=b;j<arr.length;j+=b){
              arr[j]=j/b;
          }
       }
      int[] pp = new int[10000001]; Arrays.fill(pp, -1);
       while(t-->0){
           
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] aa=new int[n];
         for(int i=0;i<n;i++){
             int a=sc.nextInt();
             aa[i]=arr[a];
         }
        
         int[] mp = new int[k + 1];
			int[] ip = new int[k + 1];
			for (int i = 0; i < n; i++) {
				int a = aa[i];
				for (int h = k; h >= 0; h--) {
					if (pp[a] >= ip[h]) {
						mp[h]++;
						ip[h] = i;
					}
					if (h > 0 && (mp[h - 1] < mp[h] || mp[h - 1] == mp[h] && ip[h - 1] > ip[h])) {
						mp[h] = mp[h - 1];
						ip[h] = ip[h - 1];
					}
				}
				pp[a] = i;
			}
         
       
        out.println(mp[k]+1);
        
       for (int i = 0; i < n; i++) {
				pp[aa[i]] = -1;
			}
        
       }
           
           out.close();
}

}