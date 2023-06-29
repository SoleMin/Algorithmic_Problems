import sys;
import math
T = int(sys.stdin.readline());
idx = 0
while(idx < T):
	array = list(map(int, sys.stdin.readline().split()))
	r = array[0];
	s = array[1:];
	
	n = len(s)
	if (n % 2 == 0):
		home = (s[math.floor(n/2)] + s[math.floor(n/2) - 1]) / 2 
	else:
		home = s[math.floor(n/2)]
	
	
	home = int(home)
	ans = 0;
	for i in s:
		ans += abs(home - i)
		
	print(ans)
	idx += 1