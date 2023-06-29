import sys
T = int(sys.stdin.readline())
idx =0
while(idx != T):
	n = int(sys.stdin.readline())
	p = int(sys.stdin.readline())
	lst = []
	for i in range(p):
		lst.append(int(sys.stdin.readline()))
	
	days = [0] * (n + 1)
	
	for i in range(1, n + 1):
		for h in lst:
			if (days[i] == 0):
				if ( i % h == 0):
					days[i] = 1
	
	for i in range(6, n + 1, 7):
		if (days[i] == 1):
			days[i] = 0
			
	for i in range(7, n+1, 7):
		if (days[i] == 1):
			days[i] = 0
			
	ans = 0;
	for i in range(n + 1):
		if (days[i] == 1):
			ans += 1
	
	print(ans)
	idx += 1