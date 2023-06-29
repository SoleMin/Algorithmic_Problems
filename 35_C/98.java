import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		Scanner in = new Scanner(new FileInputStream("input.txt"));
		//Scanner in = new Scanner(System.in);
		File file = new File("output.txt");
		FileOutputStream fos = new FileOutputStream(file);
		if (!file.exists()) {
		     file.createNewFile();
		}
		
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		int [][] fireTime = new int[N][M];
		for (int i=0; i<K; i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			fireTime[x][y] = -1;
			
			for (int j=1; j<=x+y; j++){
				for (int p=0; p<=j; p++){
					if (x-j+p >= 0 && y-p >=0 && (fireTime[x-j+p][y-p] == 0 || fireTime[x-j+p][y-p] > j)){
						fireTime[x-j+p][y-p] = j;
					}
				}
			}
			
			for (int j=1; j<=x+M-1-y; j++){
				for (int p=0; p<=j; p++){
					if (x-j+p >= 0 && y+p < M && (fireTime[x-j+p][y+p] == 0 || fireTime[x-j+p][y+p] > j)){
						fireTime[x-j+p][y+p] = j;
					}
				}
			}
			
			for (int j=1; j<=N-1-x+y; j++){
				for (int p=0; p<j; p++){
					if (x+j-p < N && y-p >= 0 && (fireTime[x+j-p][y-p] == 0 || fireTime[x+j-p][y-p] > j)){
						fireTime[x+j-p][y-p] = j;
					}
				}
			}
			
			for (int j=1; j<=N-1-x+M-1-y; j++){
				for (int p=0; p<=j; p++){
					//System.out.println(j+" "+p);
					if (x+j-p < N && y+p < M && (fireTime[x+j-p][y+p] == 0 || fireTime[x+j-p][y+p] > j)){
						//System.out.println(j);
						fireTime[x+j-p][y+p] = j;
					}
				}
			}
		}
		
		int max = -1;
		int tx = 1;
		int ty = 1;
		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				//System.out.print(fireTime[i][j]+" ");
				if (fireTime[i][j] > max){
					max = fireTime[i][j];
					tx = i+1;
					ty = j+1;
				}
			}
			//System.out.println();
		}
		//System.out.println(tx+" "+ty);
		String output = tx+" "+ty;
		
		byte[] bA = output.getBytes();
		fos.write(bA);
		fos.flush();
	}
}

		      	 			   		 	 		 	 	