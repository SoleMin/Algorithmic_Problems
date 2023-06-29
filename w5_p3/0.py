# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# boyer - mooer 알고리즘
t = input()
p = input()

m = len(p)
q = [0] * m

k = 0

for i in range(1,m):
	while k > 0 and p[i] != p[k]:
		k = q[k-1]
	if p[i] == p[k]:
		k += 1
		q[i] = k

#print(q) #[0,0,0,0,1,2,0]
# p # ABCDABD
res = []

k = 0
for i in range(len(t)):
	
	while k > 0 and t[i] != p[k]:
		k = q[k-1]
		
	if t[i] == p[k]:
		if k == m - 1:
			res.append(i - m +2)
			k = q[k]
		else:
			k += 1

print(len(res))
print(*res)