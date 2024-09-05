min = 0.0
max = 0.0
for i in range(1, 6):
    altura = float(input(f"Digite a altura {i}: "))
    if i == 1:
        min = altura
        max = altura
    else:
        if min > altura:
            min = altura
        
        if max < altura:
            max = altura
print(f"O maior é: {max} e o menor é: {min}")



