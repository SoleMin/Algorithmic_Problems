import sys
inp=sys.stdin.readlines()
full_text=''
for line in inp:
	if line == '\n':
		first=''
		j=0
		full_list=list(full_text)
		if len(full_list)==0:
			print()
			continue

		while full_list[j]==' ':
			first+=full_list[j]
			j+=1

		ans_line=''
		ans_line+=first

		full_text=full_text.strip()

		full_split=full_text.split(' ')
		if len(full_split)==1:
			print(full_text)
		else:
			for i in range(len(full_split)):
				if len(ans_line+full_split[i])+1 > 72 and i==len(full_split)-1:
					print(ans_line)
					print(full_split[i])

				elif len(ans_line+full_split[i])+1 > 72 and i==0:
					ans_line=full_split[i]

				elif i==len(full_split)-1:
					ans_line += ' '+full_split[i]
					print(ans_line)

				elif len(ans_line+full_split[i])+1 <= 72 and i==0:
					ans_line += full_split[i]

				elif len(ans_line+full_split[i])+1 <= 72:
					ans_line += ' '+full_split[i]

				else:
					print(ans_line)
					ans_line=full_split[i]

		full_text=''
		print()
	else:
		line=line.rstrip()
		full_text+=line+' '

first=''
j=0
full_list=list(full_text)
if len(full_list)==0:
	print()
else:
	while full_list[j]==' ':
		first+=full_list[j]
		j+=1

	ans_line=''
	ans_line+=first

	full_split=full_text.split(' ')
	if len(full_split)==1:
		print(full_text)
	else:
		for i in range(len(full_split)):
			if len(ans_line+full_split[i])+1 > 72 and i==len(full_split)-1:
				print(ans_line)
				print(full_split[i])

			elif len(ans_line+full_split[i])+1 > 72 and i==0:
				ans_line=full_split[i]

			elif i==len(full_split)-1:
				ans_line+=' '+full_split[i]
				print(ans_line)

			elif len(ans_line+full_split[i])+1 <= 72 and i==0:
				ans_line+=full_split[i]

			elif len(ans_line+full_split[i])+1 <= 72:
				ans_line+=' '+full_split[i]

			else:
				print(ans_line)
				ans_line=full_split[i]
	