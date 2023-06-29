import java.math.BigInteger;
import java.util.Scanner;

public class d {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for(int n=0;n<N;n++){
			arr[n] = in.nextInt();
		}
		
		Wavelet waveyMcWaveFace = new Wavelet(arr);
		
		BigInteger bigSum = BigInteger.ZERO;
		for(int n=0;n<N;n++){
			// calculate the amount added for all j = n all at once
			// it's a[j] - a[i]
			
			// step one
			// positive part
			long amtPlus = arr[n] * (long)(waveyMcWaveFace.numValsBtwn(1, arr[n] - 2, 0, n)
										+ waveyMcWaveFace.numValsBtwn(arr[n] + 2, 2147483647, 0, n));
			
			// step two
			// negative part
			long amtMinus = waveyMcWaveFace.sumOfValsBtwn(1, arr[n] - 2, 0, n)
							+ waveyMcWaveFace.sumOfValsBtwn(arr[n] + 2, 2147483647, 0, n);
			
//			System.out.println(amtPlus+" "+amtMinus);
			bigSum = bigSum.add(new BigInteger(""+(amtPlus - amtMinus)));
		}
		
		System.out.println(bigSum);
	}
	static class Wavelet{
		int l = 2147483647, h = -2147483648;
		int[] arr, ldex, hdex;
		long[] sum;
		Wavelet low = null, high = null;
		Wavelet(int[] arr){
			this.arr = arr;
			for(int i : arr){
				l = Math.min(l, i);
				h = Math.max(h, i);
			}
			ldex = new int[arr.length + 1];
			hdex = new int[arr.length + 1];
			sum = new long[arr.length + 1];
			int mid = l + (h - l) / 2;
			for(int n = 0; n < arr.length; n++){
				sum[n+1] = sum[n] + arr[n];
				if(arr[n] > mid){
					ldex[n+1] = ldex[n];
					hdex[n+1] = hdex[n] + 1;
				}
				else{
					ldex[n+1] = ldex[n] + 1;
					hdex[n+1] = hdex[n];
				}
			}
			if(l == h) return;
			int[] larr = new int[ldex[arr.length]];
			int[] harr = new int[hdex[arr.length]];
			for(int n=0;n<arr.length;n++){
				if(hdex[n] == hdex[n+1]){
					larr[ldex[n]] = arr[n];
				}
				else{
					harr[hdex[n]] = arr[n];
				}
			}
			low = new Wavelet(larr);
			high = new Wavelet(harr);
		}
		// range [ll, rr)
		int kthLowest(int k, int ll, int rr){
			if(l == h){
				return arr[ll + k-1];
			}
			if(ldex[rr] - ldex[ll] >= k){
				return low.kthLowest(k, ldex[ll], ldex[rr]);
			}
			return high.kthLowest(k - ldex[rr] + ldex[ll], hdex[ll], hdex[rr]);
		}
		// number of values in between [lo, hi] in range [ll, rr)
		int numValsBtwn(int lo, int hi, int ll, int rr){
			if(hi < lo) return 0;
			if(lo <= l && h <= hi){
				return rr - ll;
			}
			if(l == h) return 0;
			if(hi < high.l){
				return low.numValsBtwn(lo, hi, ldex[ll], ldex[rr]);
			}
			if(low.h < lo){
				return high.numValsBtwn(lo, hi, hdex[ll], hdex[rr]);
			}
			return low.numValsBtwn(lo, hi, ldex[ll], ldex[rr])
					+ high.numValsBtwn(lo, hi, hdex[ll], hdex[rr]);
		}
		// sum of values between [lo, hi] in range [ll, rr)
		long sumOfValsBtwn(int lo, int hi, int ll, int rr){
			if(lo <= l && h <= hi){
				return sum[rr] - sum[ll];
			}
			if(l == h) return 0;
			if(hi < high.l){
				return low.sumOfValsBtwn(lo, hi, ldex[ll], ldex[rr]);
			}
			if(low.h < lo){
				return high.sumOfValsBtwn(lo, hi, hdex[ll], hdex[rr]);
			}
			return low.sumOfValsBtwn(lo, hi, ldex[ll], ldex[rr])
					+ high.sumOfValsBtwn(lo, hi, hdex[ll], hdex[rr]);
		}
	}
}
