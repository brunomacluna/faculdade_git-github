## -----------------------------------------------------
# Projeto: Jogo da Velha
# Disciplina: Lógica de Programação
# Participantes:
## -----------------------------------------------------
## ----- Funções do usuário

def criaMatriz():
 mat = [ [1, 2, 3] , [4, 5, 6] , [7, 8, 9] ]
 return mat
# Final da rotina

def apresentaMatriz(mat):
 print(mat[0][0], "|", mat[0][1], "|", mat[0][2])
 print("-" * 10)
 print(mat[1][0], "|", mat[1][1], "|", mat[1][2])
 print("-" * 10)
 print(mat[2][0], "|", mat[2][1], "|", mat[2][2])
# Final da rotina

def posicaoOcupada(matriz, posicao):
 # verifica se a posição escolhida pelo jogador está ocupada. Deve retornar True ou False
     
# Final da rotina

def registraJogada(mat, posicao, jogador):
 # Esta função deve inserir a marcação do jogador na posição informada.
 # a função deve retornar a matriz preenchida
        
# Final da rotina

def trocaJogador(jogador):
 # A função deve retornar o símbolo do próximo jogador. Se o jogador atual for X, deve
 # retornar O e se for O deve retornar X
    
 # Final da rotina

def verificaGanhador(mat, jogador):
 # A função deve verificar se o jogador atual venceu a partida. Se existir uma linha, uma coluna ou
 # uma diagonal preenchida com o símbolo do jogador, a rotina deverá retornar True, caso
 # contrário False
 return
# Final da rotina

## ----- Final das funções do usuário

## ----- Programa Principal
print("*** JOGO DA VELHA *** \n")
print("Desafie o seu colega no jogo da velha.\n")
print("Regras:")
print(" a) O primeiro jogador participará com a letra X e o segundo com a letra O.")
print(" b) Os números de 1 a 9 representam os espaços que estão livres.")
print(" Você só poderá escolher as posições livres.")
print(" c) O vencedor será o primeiro Jogador a preencher uma linha, uma coluna ou uma diagonal.")

matriz = criaMatriz() # Cria a Matriz do Jogo
jogador = "X" # Define o Jogador Inicial
c = 0
while c < 10: # Controla a quantidade máxima de Jogadas (Nove).
 print()
 apresentaMatriz(matriz)
 print()
 posicao = int(input("(Jogador " + jogador + ") Informe a posição desejada : "))
 if posicaoOcupada(matriz, posicao): # Verifica se a posição está livre
    print("\nVocê não pode escolher uma posição que já está ocupada. Tente novamente.")
 continue
else:
 # Completar o código
 print("Opção válida!")
 # Final do if
 c = c + 1
# Final do while
# Final do programa