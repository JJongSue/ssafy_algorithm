def change(str):
    str = str.replace('k','c')
    
    
    str = str.replace('p','q')
    str = str.replace('o','p')
    
    
    str = str.replace("ng",'o')
    # str = str.replace('g','f')
    # str = str.replace('h','g')
    # str = str.replace('i','h')
    # str = str.replace('l','i')
    # str = str.replace('m','j')
    # str = str.replace('n','k')

    # str = str.replace('r','o')
    # str = str.replace('s','p')
    # str = str.replace('t','q')
    # str = str.replace('u','r')
    # str = str.replace('w','s')
    return str
    
n = int(input())
list = []
sort_list = []
for i in range(n):
    str = input()
    list.append(str)
    str = change(str)
    sort_list.append((str,i))
    # print(i, str)
    # print((i, str))

sort_list.sort()

for (i,i2) in sort_list:
    # print(i2)
    print(list[i2])
