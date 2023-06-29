import sys
input = sys.stdin.readline

t = input().rstrip()
p = input().rstrip()

pp = [0] * len(p)

j=0
for i in range(1,len(p)):
	while j > 0 and p[i] != p[j]:
		j = pp[j-1]
	if p[i] == p[j]:
		j+=1
		pp[i]=j

j=0
find = []
for i in range(len(t)):
	while j > 0 and t[i] != p[j]:
		j = pp[j-1]
	if t[i] == p[j]:
		if j == len(p) -1 :
			find. append(i - len(p)+2)
			j = pp[j]
		else:
			j +=1

print(len(find))
print(' '.join(map(str,find)))