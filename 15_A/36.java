import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        double [] left = new double[n];
        double [] right = new double[n];
        for (int i = 0; i<n; i++){
            int x = sc.nextInt();
            int a = sc.nextInt();
            double l = x - (double)a/2;
            double r = x + (double)a/2;
            left[i] = l;
            right[i] = r;
        }
        int answer = 2;
        quickSort(left, right, 0, n-1);
        for (int i = 0; i<n-1; i++){
            if (left[i+1] - right[i] == t){
                answer++;   
            }
            if (left[i+1] - right[i] > t){
                answer += 2;
            }
        }
        System.out.println(answer);
    }
    
////////////////////////////////////////////////////////////////    
    int partition(double arr[], int left, int right)
    {
          int i = left, j = right;
          double tmp;
          double pivot = arr[(left + right) / 2];
          while (i <= j) {
                while (arr[i] < pivot)
                      i++;
                while (arr[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = tmp;
                      i++;
                      j--;
                }
          };
          return i;
    }
    void quickSort(double arr[], int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)
                quickSort(arr, left, index - 1);
          if (index < right)
                quickSort(arr,index, right);
    }
/////////////////////////////////////////////////////////////////////
    static int partition(double arr[], double arr2[], int left, int right)
    {
          int i = left, j = right;
          double tmp; double tmp2;
          double pivot = arr[(left + right) / 2];

          while (i <= j) {
                while (arr[i] < pivot)
                      i++;
                while (arr[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = tmp;
                      tmp2 = arr2[i];
                      arr2[i] = arr2[j];
                      arr2[j] = tmp2;
                      i++;
                      j--;
                }
          };
          return i;
    }
    static void quickSort(double arr[], double[]arr2, int left, int right) {
          int index = partition(arr, arr2, left, right);
          if (left < index - 1)
                quickSort(arr, arr2, left, index - 1);
          if (index < right)
                quickSort(arr, arr2, index, right);
    }
    ////////////////////////////////////////////////////////////////////////
}
