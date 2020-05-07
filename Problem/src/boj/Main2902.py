str = input()
arr = str.split('-')
ans = ''

for i in arr:
    ans += i[0]
print(ans)