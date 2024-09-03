idade = int(input("Digite sua idade: "))
while idade <= 0:
    print("Dados inválidos.")
    idade = int(input("Digite sua idade: "))
print(f"A idade é: {idade}")
