import java.util.Scanner;

public class D2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int array[] =new int[n];
		for(int i=0; i<=n-1; i++) {
			array[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int result = count(array);
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result += (b-a)*(b-a+1)/2;
			result=result%2;
			if(result%2==1)
				System.out.println("odd");
			else
				System.out.println("even");
		}
	}
	
	public static int count(int[] arr) {
		int[] array = arr.clone();
		return sort(array,0,array.length-1);
	}
	
	public static int sort(int[] arr, int i, int j) {
		if(i>=j) return 0;
		int mid = (i+j)/2;
		int a = sort(arr,i,mid);
		int b = sort(arr,mid+1,j);
		int addition = 0;
		int r1 = mid+1;
		int[] tmp = new int[arr.length];
		int tIndex = i;
        int cIndex=i;
		while(i<=mid&&r1<=j) {
			if (arr[i] <= arr[r1]) 
                tmp[tIndex++] = arr[i++];
            else {
                      tmp[tIndex++] = arr[r1++];
                      addition+=mid+1-i;
            }
		}
		while (i <=mid) {
            tmp[tIndex++] = arr[i++];
        }
        while ( r1 <= j ) {
            tmp[tIndex++] = arr[r1++];
        }
        while(cIndex<=j){
            arr[cIndex]=tmp[cIndex];
            cIndex++;
        }
        return a+b+addition;
	}
}
