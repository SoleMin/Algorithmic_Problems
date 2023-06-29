import sys

res = [0] * 1000
res[0] = 2
res[1] = 5
res[2] = 13
for i in range(3,1000):
	res[i] = 2*res[i-1] + res[i-2] + res[i-3]



for i in sys.stdin:
	n = int(i.rstrip('\n'))
	print(res[n-1])
