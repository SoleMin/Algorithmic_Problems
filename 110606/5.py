import sys;

numbers = []
def hanoi(n):
	return (2 ** n) - 1;

while(1):
	n = sys.stdin.readline().rstrip();
	if (len(n) == 0):
		break
	numbers.append(int(n))
	
N = max(numbers)
dp = [0] * (N + 1)
dp[1] = 1

for i in range(2, N + 1):
	arr = []
	for j in range(1, i):
		arr.append(hanoi(i - j) + 2 * dp[j])
	dp[i] = min(arr)
	
for num in numbers:
	print(dp[num])