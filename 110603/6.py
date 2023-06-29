import sys;
numbers = []

while(1):
	n = sys.stdin.readline().rstrip();
	if (len(n) == 0):
		break
	numbers.append(int(n))

	
N = max(numbers)	
dp = [0] * (N + 1)
dp[0]= 1
dp[1]= 2
dp[2]= 5

for i in range(3, N+1):
	dp[i] = dp[i-1] * 2 + dp[i-2] + dp[i-3]

for num in numbers:
	print(dp[num])
