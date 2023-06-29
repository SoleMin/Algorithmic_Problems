try:
	while True:
		A=input()
		print(len(A.strip().replace(' ','').replace('\t','')),len(A.split()))
except:
		print()