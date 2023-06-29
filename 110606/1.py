import sys

hn = [0] * 10000
hn[0] = 1
for i in range(1,10000):
	hn[i] = 2 * hn[i-1] + 1

res = [0] * 1001
res[0] = 1
res[1] = 3
res[2] = 5

for i in range(3, 1000):
	a = []
	j = 0
	while j < i:
		a.append(hn[i-j-1] + 2*res[j])
		j += 1
		
	res[i] = min(a)
	
#print(res)	

for i in sys.stdin:
	n = int(i.rstrip('\n'))
	print(res[n-1])

	
	
	