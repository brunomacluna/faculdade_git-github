# 2) Faça um programa que leia o nome, o sexo e o estado civil de uma
# pessoa. Caso sexo seja “F” e estado civil seja “CASADA”, solicitar o tempo
# de casada (anos).

nome = str(input("Qual o seu nome: "))
print("Digite [H] para homem ou [F] para mulher.")
sexo = str(input("[H] ou [F]: ")).lower()
print("Digite [C] para casado/a ou [S] para solteiro/a.")
estado_civil = str(input("[C] ou [S]: ")).lower()

if sexo == "f" and estado_civil == "c":
    anos_casada = int(input(f"{nome}, quanto tempo você tem de casada? "))
    print(f"Parabéns {nome}, pelos seus {anos_casada} anos de casamento!")
print(f"Obrigado {nome}, pela participação.")
