class Aluno:
    def __init__(self, nome, idade, nota):
        self.nome = nome
        self.idade = idade
        self.nota = nota
        self.notas = []

    def adicionar_nota(self,nota):
        self.notas.append(nota)

    def media_notas(self):
        return sum(self.notas) / len(self.notas) 
    
    def exibir_informacoes(self):
        media = self.media_notas()
        print(f"Nome: {self.nome} Idade: {self.idade} Média: {media}")

obj_Aluno = []
while True:
    nome = input("Digite o nome: ")
    idade = int(input("Digite a idade: "))
    contador = int(input("Quantas notas serão inseridas: "))
    notas = []
    

    aluno = Aluno(nome, idade, notas)
    obj_Aluno.append(aluno)

    continuar = input("Deseja adicionar outro aluno? [S/N] ").upper()
    if continuar == "N":
        break

for aluno in obj_Aluno:
    aluno.exibir_informacoes()








    
        




    