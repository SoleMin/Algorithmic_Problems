import sys;


while(1):
	a, b = map(int, sys.stdin.readline().split());
	if (a == 0 and b == 0):
		break
		
	dp = [];
	dp.append(1);
	dp.append(2);
	
	cnt = 0
	if (a == 1):
		cnt = 2
	if (a == 2):
		cnt = 1
	
	idx = 2
	while(1):
		fibo = dp[-1] + dp[-2]
		
		if (fibo > b):
			break
		
		if (fibo >= a):
			cnt += 1
		
		dp.append(fibo)
		idx += 1
		
	print(cnt)