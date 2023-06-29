
import java.util.Scanner;

/**
 * 
 * 作者：张宇翔 创建日期：2017年6月16日 上午9:00:48 描述：写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱； 不见满街漂亮妹，哪个归得程序员？
 */

public class Main {

	private final static int Max = (int) (1e5 + 10);
	private static long n,s;

	public static void main(String[] args) {
		InitData();
		GetAns();
	}

	private static void InitData() {
		Scanner cin = new Scanner(System.in);
		n=cin.nextLong();
		s=cin.nextLong();
	};
	private static void GetAns() {
		long i;
		long ans=0;
		for(i=s;i<=n;i++){
			
			long k=i-sum(i);
			if(k>=s){
				if(i%10==9){
					break;
				}
				ans++;
			}
		}
		if(n>=s){
			System.out.println(ans-i+n+1);
		}else{
			System.out.println(0);
		}
	};
	private static long sum(long ans){
		long sum=0;
		while(ans>0){
			sum+=(ans%10);
			ans/=10;
		}
		return sum;
	}
}