# 8) Escreva um programa que peça ao usuário um número de 1 a 7 e
# exiba o dia da semana correspondente (1 = Domingo, 2 = Segunda, etc.).

n = str(input("Digite um número de 1 a 7: "))
if n == "1":
    print("1 = Domingo")
elif n == "2":
    print("2 = Segunda")
elif n == "3":
    print("3 = Terça")
elif n == "4":
    print("4 = Quarta")
elif n == "5":
    print("5 = Quinta")
elif n == "6":
    print("6 = Sexta")
elif n == "7":
    print("7 = Sábado")
else:
    print("Código inválido. Tente novamente.")