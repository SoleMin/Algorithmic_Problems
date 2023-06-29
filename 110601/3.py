from collections import deque
from bisect import bisect_left, bisect_right

def fibo(n):
	a,b= 1,1
	while b < n:
		yield b
		a, b = b, a+b

fibonacci = deque(fibo(pow(10, 100)))
	
def countFibo(a,b,fibo):
	right = bisect_right(fibo, b)
	left = bisect_left(fibo, a)
	return right - left

while True:
	x, y = map(int, input().split())
	if x == 0 and y == 0:
		break
	print(countFibo(x,y,fibonacci))
