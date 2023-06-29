KeyBoard = ['1','2','3','4','5','6','7','8','9','0','-','=','Q','W','E','R','T','Y','U','I','O','P','[',']','A','S','D','F','G','H','J','K','L',';',"'",'Z','X','C','V','B','N','M',',','.','/']

while True:
	try:
		A = input()
		A = list(A)
		for i in range(len(A)):
			for j in range(len(KeyBoard)):
				if A[i] == KeyBoard[j]:
					A[i] = KeyBoard[j-1]
		
		print(''.join(A))
		
	except:
		break