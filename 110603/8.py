Inputlist=[]
try:
	while True:
		Inputlist.append(int(input()))
except:
	Max=1000
	dp=[0 for _ in range(Max)]
	dp[0]=1
	dp[1]=2
	dp[2]=5
	for i in range(3,Max):
		dp[i]=dp[i-1]*2+dp[i-2]+dp[i-3]
		
	for N in Inputlist:
		print(dp[N])