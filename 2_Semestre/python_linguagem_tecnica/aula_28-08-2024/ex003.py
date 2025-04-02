multiplicacao_quadrados = 1
soma_quadrados = 0
for i in range(1,11):
    soma_quadrados = soma_quadrados + i ** 2
    multiplicacao_quadrados = multiplicacao_quadrados * (i ** 2)
print(f"A soma dos quadrados é: {soma_quadrados}")
print(f"A multiplicação dos quadrados é: {multiplicacao_quadrados}")
