while True:
	try:
		a= int(input())
		b=1
		cnt =0
		hanoi =0
		for i in range (1,a+1):
			if (cnt + i) >= a:
				hanoi = hanoi + (a-cnt)*b
				break
			else:
				hanoi += b * i
				cnt += i
				b *= 2
		print(hanoi)
	except:
		break
