# 1. Desenvolva um algoritmo que, dentro de um intervalo específico de números (de 1
# a 500), selecione e some os números que atendam a dois critérios: serem ímpares e
# também múltiplos de três. Além disso, exiba o total de números que atenderam a
# esses critérios.

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


        
