import math
while True:
	n = int(input())
	if n == 0:
		break
	moneys = []
	total = 0
	answer = 0
	for _ in range(n):
		money = float(input())
		moneys.append(money)
		total += money
	total /= n
	for m in moneys:
		if m < total:
			answer += (total - m)

	print(f'${math.trunc(answer*100)/100:.2f}')