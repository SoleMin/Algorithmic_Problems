import sys

f = [0] * (10**6)
f[1] = 1 #1
f[2] = 3 #2
f[3] = 5 #3

# 1 2 3 4  5  6  7  8
# 1 3 5 8 11 15 19 23
re = 1
for i in range(4,10**6):
	x = 0
	for j in range(re,i):
		if f[j] < i:
			continue
		else:
			x = j
			re = x
			break
	
	f[i] = f[i-1] + x

for i in sys.stdin:
	n = int(i.rstrip('\n'))
	
	if n == 0:
		break
		
	for j in range(1,10**6):
		if f[j] >= n:
			print(j)
			break
