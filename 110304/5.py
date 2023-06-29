# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

pas=['the','quick','brown','fox','jumps','over','the','lazy','dog']
pas_char=set(list(''.join(pas)))
pas_leng=[len(x) for x in pas]

num=int(input())
space_line=input()

for n in range(num):
	ch=[]
	lines=[]
	line=input()
	no_sol=True
	while line != "":
		try:
			lines.append(line)
			line=input()
		except EOFError: break
	
	for line in lines:
		check=[len(x) for x in line.split()]
		if check==pas_leng:
			ch=line.split()
			
			if not ch[0]==ch[6]: continue
			if not ch[2][2]==ch[3][1]==ch[5][0]==ch[8][1]: continue
			if not ch[0][2]==ch[5][2]: continue
			if not ch[2][1]==ch[5][3]: continue
			if not len(pas_char)==len(set(list(''.join(ch)))): continue
			
			no_sol=False
			break
	
	if n>0: print()
	
	if no_sol==True:
		print("No solution.")
		continue
		
	key=list("".join(ch))
	value=list("".join(pas))
	
	dic={}
	
	for i in range(len(key)):
		if key[i] in dic.keys():
			continue
		else:
			dic[key[i]]=value[i]
	dic[" "]=" "
	
	for line in lines:
		print("".join([dic[x] for x in line]))
	
	