def minhaFuncao():
    print("Sejam bem vindos!!")

def soma(a, b):
    return int(a) + int(b)

minhaFuncao()

v1 = input("Digite o primeiro valor: ")
v2 = input("Digite o segundo valor: ")
resultado_1 = soma(v1, v2)
resultado_2 = soma(2, 4)
print(f"O primeiro resultado é {resultado_1}")
print(f"O segundo resultado é {resultado_2}")

print(f"O primeiro resultado é {soma(v1, v2)}")

def area_retangulo(largura, altura):
    return largura * altura

larg = float(input("Digite a largura: "))
alt = float(input("Digite a altura: "))
area = area_retangulo(larg, alt)
print(f"A área do retângulo é {area}")
