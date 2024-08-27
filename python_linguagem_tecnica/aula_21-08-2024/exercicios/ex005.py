# 5) Encontrar o dobro de um número caso ele seja positivo e o seu triplo
# caso seja negativo, imprimindo o resultado.

n = int(input("Digite um número: "))
if n > 0:
    t = n * 2
    print(f"O resultado da operação é: {t}.")
elif n < 0:
    t = n * 3
    print(f"O resultado da operação é: {t}.")
else:
    print("O resultado da operação é: Zero.")