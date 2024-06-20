# Programa ITBI
valor = float(input("Digite o valor de compra do imóvel: "))
itbi = valor * 3 / 100
print(f"O valor do ITBI a pagar é: R$ {itbi:.2f}")

# Programa Venda
pc = float(input("Digite o preço de custo unitário: "))
pv = float(input("Digite o preço de venda unitário: "))
qe = int(input("Digite a quantidade em estoque: "))
lu = pv - pc
le = lu * qe
print(f"Lucro unitário = {lu:.2f}")
print(f"Lucro de estoque = {le:.2f}")
