A = int(input("Digite o valor de A: "))
resultado = 1
sequencia = ""
for i in range(A, 0, -1):
    resultado *= i
    if i == A:
        sequencia = sequencia + str(i)
    else:
        sequencia = sequencia + "*" + str(i)

print(f"Resultado do fatorial de {A} é: {resultado}")
print(sequencia)