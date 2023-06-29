def self_describing(n):
	seq = [0] * (n + 1)
	seq[1] = 1
	for i in range(2, n+1):
		seq[i] = 1 + seq[i - seq[seq[i-1]]]
	print(seq[-1])
	
while True:
	n = int(input())
	if n == 0:
		break
	self_describing(n)