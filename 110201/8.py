try:
	while True:
		input_list=list(map(int,input().split()))
		number_list=[i for i in range(1,input_list[0])]
		
		Jully=True
		for i in range(2,input_list[0]+1):
			Num=input_list[i]-input_list[i-1]
			if Num<0:
				Num*=-1
			if not (Num in number_list):
				Jully=False
			else:
				number_list.remove(Num)
				
		if Jully==True:
			print('Jolly')
		else:
			print('Not jolly')
			
except:
	print()