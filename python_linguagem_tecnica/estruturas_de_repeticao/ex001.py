cont = 0
soma = 0
sequencia = " "
for c in range(1, 501):
    if c % 3 == 0 and c % 2 == 1:
        cont += 1
        soma = soma + c
        sequencia += " " + str(c)
print(f"Quantos foram? {cont}")
print(f"Quais foram? {sequencia}")
print(f"O somatório? {soma}")    


        
