# 7) Faça um programa que leia uma variável e some 5 caso seja par ou
# some 8 caso seja ímpar, imprimir o resultado desta operação.

n = int(input("Digite um número: "))
if n % 2 == 0:
    n = n + 5
else:
    n = n + 8
print(f"O resultado da operação é: {n}.")
