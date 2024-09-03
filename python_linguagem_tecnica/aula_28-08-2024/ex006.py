for num in range(2,20):
    primo = True
    i = 2
    while i <= num // 2:
        if num % i == 0:
            primo = False
            break
        i += 1
    if primo:
        print(f"{num} é primo.")
        

