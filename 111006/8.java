import java.util.*;
class Main {
		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cityMapNum = 1;

		while(true) {
			String NT = input.nextLine();

			if(NT.equals("0")) {
				break;
			}

			int N = Integer.parseInt(NT);
			Map<String, Integer> cityMapCN = new HashMap<>();
			Map<Integer, String> cityMapNC = new HashMap<>();
			int cityN = 0;
			for(int i=0; i<N; i++) {
				String city = input.nextLine();
				cityMapCN.put(city, cityN);
				cityMapNC.put(cityN, city);
				cityN++;
			}

			String RT = input.nextLine();
			int R = Integer.parseInt(RT);

			int[][] M = new int[N][N];
			//길 있으면 1
			for(int i=0; i<R; i++) {
				String ssT = input.nextLine();
				String[] sT = ssT.split(" ");
				M[cityMapCN.get(sT[0])][cityMapCN.get(sT[1])] = 1;
				M[cityMapCN.get(sT[1])][cityMapCN.get(sT[0])] = 1;
			}

			int cameraNum = 0;
			ArrayList<String> citys = new ArrayList<>();

//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(M[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			for(int k=0; k<N; k++) {
				int[][] MM = new int[N-1][N-1];
				int a = 0;
				for(int i=0; i<N; i++) {
					int b = 0;
					if(k==i) {
						continue;
					}
					else {
						for(int j=0; j<N; j++) {
							if(k==j) {
								continue;
							}
							else {
								MM[a][b] = M[i][j];
								b++;
							}

						}
						a++;
					}

				}

//				System.out.println("k : " + k);
//				for(int i=0; i<N-1; i++) {
//					for(int j=0; j<N-1; j++) {
//						System.out.print(MM[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println();

				boolean isCamera = DFS(N-1, MM);
				if(isCamera == false) {
//					System.out.println(isCamera);
					cameraNum++;
					citys.add(cityMapNC.get(k));
				}
			}

			Collections.sort(citys);
			System.out.println("City map #" + cityMapNum + ": " + cameraNum + " camera(s) found");
			for(int i=0; i<citys.size(); i++) {
				System.out.println(citys.get(i));
			}
			System.out.println();
			cityMapNum++;
		}

	}

	public static boolean DFS(int n, int[][] M) {
		//깊이 우선 탐색(DFS)
		Stack<Integer> GraphStackDFS = new Stack<>();
		int [] checkDFS = new int[n];

		checkDFS[0] = 1;
		GraphStackDFS.push(0);

		while(GraphStackDFS.size() != 0) {
			int node = GraphStackDFS.pop();
			for(int i=0; i<n; i++) {
				if(M[node][i] == 1) {
					int adjacentNode = i;
					if(checkDFS[adjacentNode] != 1 || GraphStackDFS.contains(adjacentNode) ) {
						checkDFS[adjacentNode] = 1;
						GraphStackDFS.add(adjacentNode);
					}
				}
			}
		}
		
//		System.out.println("DFS result : ");
//		for(int i=0; i<n; i++) {
//			System.out.print(checkDFS[i]);
//		}
//		System.out.println();

		boolean isConnected = true;
		for(int i=0; i<n; i++) {
			if(checkDFS[i] == 0) {
				isConnected = false;
			}
		}

		return isConnected;
	}
}