senha = input("Digite a senha: ")
contador = 0
while senha != "senha":
    contador += 1
    if contador == 2:
        print("Você só tem mais uma tentativa.")
    if contador == 3:
        print("Acesso bloqueado.")
        break
    print("Acesso negado.")
    senha = input("Digite a senha: ")
if contador != 3:
    print("Acesso concedido.")

