# Projeto: Jogo da Velha
# Disciplina: Lógica de Programação
# Participantes:

# ----- Funções do usuário

def criaMatriz():
    mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
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
    for linha in matriz:
        if posicao in linha:
            return False
    return True
# Final da rotina

def registraJogada(mat, posicao, jogador):
    for i in range(3):
        for j in range(3):
            if mat[i][j] == posicao:
                mat[i][j] = jogador
                return mat
# Final da rotina

def trocaJogador(jogador):
    return 'O' if jogador == 'X' else 'X'
# Final da rotina

def verificaGanhador(mat, jogador):
    for i in range(3):
        # Verifica linhas
        if mat[i][0] == mat[i][1] == mat[i][2] == jogador:
            return True
        # Verifica colunas
        if mat[0][i] == mat[1][i] == mat[2][i] == jogador:
            return True
    # Verifica diagonais
    if mat[0][0] == mat[1][1] == mat[2][2] == jogador:
        return True
    if mat[0][2] == mat[1][1] == mat[2][0] == jogador:
        return True
    return False
# Final da rotina

# ----- Final das funções do usuário

# ----- Programa Principal
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
while c < 9: # Controla a quantidade máxima de Jogadas (Nove).
    print()
    apresentaMatriz(matriz)
    print()
    posicao = int(input("(Jogador " + jogador + ") Informe a posição desejada : "))
    if posicaoOcupada(matriz, posicao): # Verifica se a posição está livre
        print("\nVocê não pode escolher uma posição que já está ocupada. Tente novamente.")
        continue
    else:
        matriz = registraJogada(matriz, posicao, jogador)
        if verificaGanhador(matriz, jogador):
            apresentaMatriz(matriz)
            print(f"\nParabéns! Jogador {jogador} venceu o jogo!")
            break
        jogador = trocaJogador(jogador)
        c += 1
else:
    apresentaMatriz(matriz)
    print("\nO jogo terminou empatado!")
# Final do while
# Final do programa
