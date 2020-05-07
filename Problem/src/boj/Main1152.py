str = input()
str = str.strip()
a = str.split(' ')
# print(a)
if (len(a) == 1) & (a[0] == ''):
    print(0)
else:
    print(len(a))
