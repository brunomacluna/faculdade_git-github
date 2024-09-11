# 6. Crie um programa que gere e exiba todos os números ímpares situados entre 100 e
# 200. Explique como o programa decide se um número é ímpar e como ele percorre o
# intervalo especificado.

for i in range(100, 201):

    if i % 2 != 0:
        print(i, end=" ")

# O programa verifica se o número é impar com o operador % (MOD)
# se o resto da divisão por 2 for diferente de zero, significa que é impar
# Ele percorre o intervalo defino no loop for, que nesse caso comaça em 100
# e vai até 201