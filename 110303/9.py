while True:
	try:
		string_a = list(input())
		string_b = list(input())
		
		i = 0
		common = []
		
		while i < len(string_a):
			if string_a[i] in string_b:
				common.append(string_a[i])
				seq = int(string_b.index(string_a[i]))
				string_b.pop(seq)
			i += 1
		common.sort()
		print(''.join(common))
	
	except:
		break