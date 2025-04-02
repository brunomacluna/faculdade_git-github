# Projeto: Jogo da Velha
# Disciplina: Lógica de Programação
# Participantes:

# ----- Funções do usuário

# def - indica que estamos definindo uma nova função.
# criaMatriz() - é o nome dado a esta função. Ela não recebe nenhum parâmetro
# mat - é a varialvél que recebe cada sublista da matriz
# return mat - retorna a matriz criada para quem chamou a função criaMatriz
def criaMatriz():
    mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    return mat
# Final da rotina

# apresentaMatriz - é uma função que recebe o parâmetro "mat", que representa a matriz. 
# as linhas são impressas a partir dos print, de acordo com o número da coluna e linha dentro da matriz, ex: mat[1][2]
# o uso de "|" e "_" * 10, são para desenhar um tabuleiro
def apresentaMatriz(mat):
    print(mat[0][0], "|", mat[0][1], "|", mat[0][2])
    print("-" * 10)
    print(mat[1][0], "|", mat[1][1], "|", mat[1][2])
    print("-" * 10)
    print(mat[2][0], "|", mat[2][1], "|", mat[2][2])
# Final da rotina

# posicaoOcupada - é uma função que recebe dois parâmetros: 
# matriz, representando o tabuleiro
# posicao, representando a posição de um número, que queremos verificar se está ocupado
# "for linha in matriz" - inicia um loop for que percorre cada linha da matriz
# "linha" será cada sublista dentro da matriz
# "if posicao in linha" - verifica se a posicao especificada (número) está presente na linha atual
# o operador "in" verifica se o valor de "posicao" está contido na sublista "linha"
# se "posicao" for encontrado na linha, significa que a posição ainda está disponivél, sem X ou O
# "return False" - retorna falso quando a posição não está ocupada
# "return True" - retorna verdadeiro quando a posição está ocupada
def posicaoOcupada(matriz, posicao):
    for linha in matriz:
        if posicao in linha:
            return False
    return True
# Final da rotina

# registraJodada - tem objetivo de atualizar a matriz com a jogada de um jogadro, substituindo o valor numerico por X ou O
# parâmetro mat - é do tipo listas de listas (matriz)
# parâmetro posicao - é do tipo interio
# parâmetro jogador - é do tipo caractere. ex: X ou O
# a função utiliza 2 loops "for" anhinhados
# loop externo "for i in range(3)" percorre as linhas da matriz
# loop interno "for j in range(3)" percorre as colunas da matriz
# dentro do loop a função verifica se o elemento atual "mat[i][j]" é igual a "posicao" fornecida
# "if mat[i][j] == posicao:" compara o valor atual da matriz com a posião desejada
# se a condição if for verdadeira, a função substitui o valor da posição na matriz pelo simbolo do jogador "jogador"
# "mat[i][j] = jogador" atualiza a matriz
# após atualizar a matriz a função retorna a matriz modificada
# "return mat" garante que as mudanças sejam refletidas fora da função
def registraJogada(mat, posicao, jogador):
    for i in range(3):
        for j in range(3):
            if mat[i][j] == posicao:
                mat[i][j] = jogador
                return mat
# Final da rotina

# o objetivo é simples, alternar o jogador
# "return 'O' if jogador == 'X' else 'X'" se "jogador" é igual a "X", a expressão é verdadeira
# nesse caso a função retorna "O", else, se não for retorna, ou seja jogador é "O", a função retorna "X"
def trocaJogador(jogador):
    return 'O' if jogador == 'X' else 'X'
# Final da rotina

# parâmetros - mat do tipo matriz, jogador do tipo caractere
# o loop "for i in range(3)" percorre cada linha da matriz
# a condição "if mat[i][0] == mat[i][1] == mat[i][2] == jogador:" verifica se todos os elementos da linha "i" 
# são iguais ao simbolo do jogador
# o mesmo loop "for i in range(3)"" é usado para percorrer cada coluna.
# a condição "if mat[0][i] == mat[1][i] == mat[2][i] == jogador:" verifica se todos os elementos da coluna i 
# são iguais ao símbolo do jogador.
# para diagonais, a primeira condição "if mat[0][0] == mat[1][1] == mat[2][2] == jogador:" verifica a diagonal 
# principal (de cima à esquerda para baixo à direita).
# a segunda condição if mat[0][2] == mat[1][1] == mat[2][0] == jogador verifica a diagonal secundária 
# (de cima à direita para baixo à esquerda).
# se nenhuma condição for atendida a função retorna "False", indicando que nenhum jogador venceu.
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
c = 0 # inicializa a variável c com o valor 0. Esta variável será usada para contar o número de jogadas realizadas.
while c < 9: # Controla a quantidade máxima de Jogadas (Nove).
    print() # imprime uma linha em branco para espaçamento.
    apresentaMatriz(matriz) # chama a função apresentaMatriz(matriz) para exibir o tabuleiro atualizado.
    print() # imprime uma linha em branco para espaçamento.
    posicao = int(input("(Jogador " + jogador + ") Informe a posição desejada : "))
    if posicaoOcupada(matriz, posicao): # Verifica se a posição está livre
        print("\nVocê não pode escolher uma posição que já está ocupada. Tente novamente.") # se ocupada(True) da erro e volta para o loop
        continue
    else:
        matriz = registraJogada(matriz, posicao, jogador) # se livre(False) chama essa função para atualizar com o simbolo escolhido
        if verificaGanhador(matriz, jogador): # chama essa função para verificar se o jogador atual venceu, se True imprime msg de vitoria
            apresentaMatriz(matriz)
            print(f"\nParabéns! Jogador {jogador} venceu o jogo!")
            break # e interrompo o loop com o break
        jogador = trocaJogador(jogador) # se não tiver vencido chama essa função e troca o jogador, e incrementa +1 no "c"
        c += 1
else: # se acabar o loop while sem vencedor, exibe o tabuleiro final e a mensagem de fim de jogo
    apresentaMatriz(matriz)
    print("\nO jogo terminou empatado!")
# Final do while
# Final do programa
