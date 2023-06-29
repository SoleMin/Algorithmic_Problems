try:
	while True:
		N=int(input())
		if N==0:
			break
		int_list=[]
		float_list=[]
		Sum_int=0
		Sum_float=0
		for _ in range(N):
			A=float(input())

			int_list.append(A)
		
		
		for i in int_list:
			Sum_int+=i
			
		average_int=round(Sum_int/N*100)/100


			
		divided_int1=0
		divided_int2=0
		for i in int_list:
			if average_int > i:
				divided_int1+=average_int-i
			else:
				divided_int2+=i-average_int

		print(f'${min(divided_int1,divided_int2):.2f}')
except EOFError:
			print('EofError')
except:
			print()