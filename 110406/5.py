# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def tax_count(en_km,ex_km,tax):
	tax_c=abs(int(ex_km)-int(en_km))*tax+100
	return tax_c

def time_c(en_t,ex_t):
	en_t=list(map(int,en_t))
	ex_t=list(map(int,ex_t))
	tf=True
	
	for i in range(len(en_t)):
		if en_t[i]<ex_t[i]:
			break
		elif en_t[i]==ex_t[i]:
			if i==len(en_t)-1:
				tf=False
				break
			continue
		else:
			tf=False
			break
			
	return tf


n=int(input())
space_line=input()

for i in range(n):
	record={}
	tax_sum={}

	tax=list(map(int,input().split()))
	line=input()

	while line!='':
		try:
			line=line.split()

			name=line[0]
			time=line[1]
			rec=line[2]
			km=line[3]
			time=time.split(':')

			if name in record.keys():
				if rec=='enter' and record[name][1]=='exit':
					tf=time_c(time,record[name][0])
					if tf==True:
						tax_rec=tax[int(time[2])]
						tax_c=tax_count(km,record[name][2],tax_rec)
						if name in tax_sum.keys():
							tax_sum[name]+=tax_c
							del record[name]
						else:
							tax_sum[name]=tax_c+200
							del record[name]

					else:
						if tf==False and rec=='enter' and record[name][1]=='exit':
							record[name]=(time,rec,km)
						line=input()
						continue

				elif rec=='exit' and record[name][1]=='enter':
					tf=time_c(record[name][0],time)
					if tf==True:
						tax_rec=tax[int(record[name][0][2])]
						tax_c=tax_count(record[name][2],km,tax_rec)
						if name in tax_sum.keys():
							tax_sum[name]+=tax_c
							del record[name]
						else:
							tax_sum[name]=tax_c+200
							del record[name]

					else:
						if tf==False and rec=='enter' and record[name][1]=='exit':
							record[name]=(time,rec,km)
						line=input()
						continue

				elif rec=='enter' and record[name][1]=='enter':
					record[name]=(time,rec,km)
					
			else:
				record[name]=(time,rec,km)

			line=input()
		except EOFError:break
	
	if tax_sum.keys():
		ans=sorted(tax_sum.items())
		for an in ans:
			print(f'{an[0]} ${an[1]/100:.2f}')

	print()
