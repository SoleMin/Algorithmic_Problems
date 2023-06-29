import sys;
numbers = [];
while(1):
	n = int(sys.stdin.readline().rstrip())
	if (n == 0):
		break
	numbers.append(n)
		
N = max(numbers)
dp = [0] * (N+1)
dp[1] = 1
	
for i in range(2, N + 1):
	dp[i] = 1 + dp[i - dp[dp[i-1]]]
	
for num in numbers:
	print(dp[num])


