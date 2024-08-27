# 1) Faça um programa que leia os valores A, B, C e imprima na tela se a
# soma de A + B é menor que C.
a = int(input("Digite A: "))
b = int(input("Digite B: "))
c = int(input("Digite C: "))
if a + b < c:
    print(f"{a + b} < {c}")
    print("Sim, a soma de A + B é menor que C.")
elif a + b > c:
    print(f"{a + b} > {c}")
    print("Não, a soma de A + B não é menor que C.")

else:
    print(f"{a + b} = {c}")
    print("Não, a soma de A + B não é menor a C.")
