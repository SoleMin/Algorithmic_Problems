import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		for(int r=0; r<repeat; r++) {
			if(r == 0)
				input.nextLine();
			String[] split = input.nextLine().split("\\s+");
			int f = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1]);
			boolean[] fireStation = new boolean[n+1];
			int[][] roadMatrix = new int[n+1][n+1];

			for(int i=0; i<f; i++)
				fireStation[Integer.parseInt(input.nextLine())] = true;

			while(input.hasNextLine()) {
				String[] sp = input.nextLine().split("\\s+");
				if(sp[0].equals(""))
					break;
				int a = Integer.parseInt(sp[0]);
				int b = Integer.parseInt(sp[1]);
				roadMatrix[a][b] = Integer.parseInt(sp[2]);
				roadMatrix[b][a] = Integer.parseInt(sp[2]);
			}

			for(int i=1; i<n+1; i++)
				for(int j=1; j<n+1; j++)
					if(roadMatrix[i][j] == 0 && i != j)
						roadMatrix[i][j] = -1;

			for(int k=1; k<n+1; k++)
				for(int i=1; i<n+1; i++)
					for(int j=1; j<n+1; j++)
						if(roadMatrix[i][k]!=-1 && roadMatrix[k][j]!=-1)
							if(roadMatrix[i][j]==-1 || roadMatrix[i][j] > roadMatrix[i][k] + roadMatrix[k][j])
								roadMatrix[i][j] = roadMatrix[i][k] + roadMatrix[k][j];

			int min = -1;
			int minNode = -1;
			for(int i=1; i<n+1; i++) {
				if(!fireStation[i]) {
					fireStation[i] = true;
					int maxDistance = 0;
					// 모든 true에서 모든 false까지의 가는 거리 중 최대값을 maxDistance에 저장.
					for(int j=1; j<n+1; j++)
						if(!fireStation[j]) {
							int minDistance = -1;
							for(int k=1; k<n+1; k++)
								if(fireStation[k])
									if(minDistance==-1 || minDistance > roadMatrix[j][k])
										minDistance = roadMatrix[j][k];
							if(maxDistance < minDistance)
								maxDistance = minDistance;
						}

					if(min==-1 || maxDistance < min) {
						min = maxDistance;
						minNode = i;
					}
					fireStation[i] = false;
				}
			}

			if(r>0)
				System.out.println();
			System.out.println(minNode);
		}
		input.close();
	}
}