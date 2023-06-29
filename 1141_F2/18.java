import java.util.*;
import java.math.*;
public class Main{
	static HashMap<Integer,ArrayList<seg>> ma;
	static class seg{
		seg(int a,int b){
			l=a;r=b;
		}
		int l,r;
	}
	static int n,sum,dex;
	static int arr[]=new int[1600];
	public static void main(String argas[]){
		Scanner cin=new Scanner(System.in);
		ma=new HashMap();
		n=cin.nextInt();
		for(int i=1;i<=n;i++){
			arr[i]=cin.nextInt();
			sum=0;
			for(int j=i;j>0;j--){
				sum+=arr[j];
				if(ma.containsKey(sum)) ma.get(sum).add(new seg(j,i));
				else {
					ma.put(sum, new ArrayList<seg>());
					ma.get(sum).add(new seg(j,i));
				}
			}
		}
		int ans=0,te;
		ArrayList<seg> best=new ArrayList(),now,temp;
		Iterator it=ma.entrySet().iterator();
		while(it.hasNext()){
			now=new ArrayList();
			te=0;
			Map.Entry entry=(Map.Entry) it.next();
			temp=(ArrayList<seg>) entry.getValue();
			dex=0;
			for(int i=0;i<temp.size();i++){
				if(temp.get(i).l>dex){
					dex=temp.get(i).r;
					te++;
					now.add(new seg(temp.get(i).l,temp.get(i).r));
				}
			}
			if(te>ans){
				ans=te;
				best=now;
			}
		}
		System.out.println(ans);
		for(int i=0;i<best.size();i++){
			System.out.println(best.get(i).l+" "+best.get(i).r);
		}
	}
}