try:
	while True:
		A=input()
		B=A.split('0x')
		if len(B)==2:
			var=0
			Sum=0
			total_length=len(B[1])-1
			for i in B[1]:
				if i=='F':
					var=15
				elif i=='E':
					var=14
				elif i=='D':
					var=13
				elif i=='C':
					var=12
				elif i=='B':
					var=11
				elif i=='A':
					var=10
				else:
					var=int(i)
				Sum+=(16**total_length)*var
				total_length-=1
			print(Sum)
		else:
			answer=str(hex(int(A))).split('0x')
			answer[1]=answer[1].upper()
			print('0x'+answer[1])
except:
	print()
		