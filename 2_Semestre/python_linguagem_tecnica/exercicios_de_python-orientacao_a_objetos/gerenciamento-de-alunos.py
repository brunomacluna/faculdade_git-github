class Aluno:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
        self.notas = []

    def adicionar_nota(self,nota):
        self.notas.append(nota)

    def media_notas(self):
        if len(self.notas) > 0:
            return sum(self.notas) / len(self.notas) 
        else:
            return 0
        
    def exibir_informacoes(self):
        media = self.media_notas()
        print(f"Nome: {self.nome} - Idade: {self.idade} - Média: {media:.2f}")

lista_Alunos = []
contador = 3 # coloquei o contador em 3 porque vou precisar de somente 3 alunos

while contador > 0:
    nome = input("Digite o nome: ")
    idade = int(input("Digite a idade: "))
    obj_aluno = Aluno(nome, idade)    
    cont_notas = 1
   
    while cont_notas <= 4:
        nota = float(input(f"Digite {cont_notas}º nota: "))
        obj_aluno.adicionar_nota(nota)
        cont_notas += 1
         
    lista_Alunos.append(obj_aluno)
    contador -= 1
    print()
for aluno in lista_Alunos:
    aluno.exibir_informacoes()






    
        




    