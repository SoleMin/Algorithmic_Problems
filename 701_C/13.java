
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
	int n=in.nextInt();
	char b[]=in.next().toCharArray();
	int bb[]=new int [b.length];

	int Mark[]=new int [26*2+1];
	int Mark1[]=new int [26*2+1];

	int ans=0;
	for(int i=0;i<b.length;i++){
		char f=b[i];
		int a;
		if(f>='a'&&f<='z')
			a=f-'a';
		else  a=f-'A'+26;
		bb[i]=a;
		if(Mark1[a] == 0){
			ans++;
			Mark1[a]=1;}
	 
}
//	System.out.println(ans);
	int i;
    // int L ,R ,nowsum ,Ans;
   int  L = 0 ,nowsum = 0 ,Ans = n,R = 0;
     //找到LR
     for(i = 0 ;i < n ;i ++)
     {
         if(Mark[bb[i]]==0) nowsum ++;
           Mark[bb[i]] ++;
           if(nowsum == ans) 
           {
              R = i;
              break;
           }
        
     }
//     System.out.println("r"+R);
     Ans = R - L + 1; 
     for(i = L ;i < n ;i ++)
     {
       
        if((--Mark[bb[i]])==0)
        {
           int ok = 0;
           for(int j = R + 1 ;j < n ;j ++)
           {
              
          
                 Mark[bb[j]] ++;
                 if(bb[j] == bb[i])
                 {
                    ok = 1;
                    R = j;
                    break;
                 }
              
           }
           if(ok==0) break;
        }
        if(Ans > R - i) Ans = R - i;
     }
    	 System.out.println(Ans);
	 


	}

}
