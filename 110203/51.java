import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int caseCount = Integer.parseInt(br.readLine());
		for (int caseNumber= 0; caseNumber < caseCount; caseNumber++) {
			int period = Integer.parseInt(br.readLine());
			int companyCount = Integer.parseInt(br.readLine());
			int cycle[] = new int[companyCount];
			
			int allCount = 0;
			
			for (int companyNumber = 0; companyNumber < companyCount; companyNumber++) {
				cycle[companyNumber] = Integer.parseInt(br.readLine());
			}
			
			for (int companyNumber = 0; companyNumber < companyCount; companyNumber++) {
				int n = 1;
				while (true) {
					int day = cycle[companyNumber] * n;
					if (day > period) {
						break;
					}

					if (companyNumber == 0) {
						if (!(day % 7 == 6 || day % 7 == 0)) {
							allCount++;
						}
					}
					else {
						if (!(day % 7 == 6 || day % 7 == 0)) {
							boolean tf = true;
							for (int companyTempNumber = 0; companyTempNumber < companyNumber; companyTempNumber++) {
								if (day % cycle[companyTempNumber] == 0) {
									tf = false;
									break;
								}
							}
							if (tf) {
								allCount++;
							}
						}
					}
					n++;
				}
			}
			System.out.println(allCount);
		}
			
		
	}
}