# 6) Escreva um programa que lê dois valores booleanos (lógicos) e então
# determina se ambos são VERDADEIROS ou FALSOS.

print("Digite se [A] é verdadeiro ou falso:")
a = input("[V] ou [F]: ").lower()
print("Digite se [B] é verdadeiro ou falso:")
b = input("[V] ou [F]: ").lower()

if a == "v":
    a = True
    print("A => é verdadeiro")
else:
    a = False
    print("A => é falso")

if b == "v":
    b = True
    print("B => é verdadeiro")
else:
    b = False
    print("B => é falso")

if a == True and b == True or a == False and b == False:
    print("Lógica => Verdadeiro")
else:
    print("Lógica => Falso")