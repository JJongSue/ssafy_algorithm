str = input()

ans = True
# print(len(str))
# print(len(str)/2)
for i in range(0, int(len(str)/2)):
    # print(i,str[i], str[-i-1])
    if str[i] != str[-i-1]:
        ans = False
        break
if ans:
    print(1)
else:
    print(0)