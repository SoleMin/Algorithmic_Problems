seq=list()
seq.append(int(0))
seq.append(int(1))
	
for i in range(1,5000000):
	seq.append(int(1+seq[i+1-seq[seq[i]]]))
	
while(1):
	test_case=input()
	test_case=int(test_case)
	
	if test_case==0:
		break
	
	print(seq[test_case])