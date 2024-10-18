class Turma:
    def __init__(self):
        self.alunos = {}

    def adicionar_alunos(self, chave, valor):
        if chave in self.alunos:
            print("Não foi possível inserir, já existe a chave!!!")
        else:
            self.alunos[chave] = valor

    def remover_aluno(self, chave):
        if chave in self.alunos:
            return self.alunos.pop(chave)
        else:
            return "Null"

    def listar_alunos(self):
        print("********Imprimindo Alunos********")
        for chave, valor in self.alunos.items():
            print (f"Nome: {chave}, Nota: {valor}")

turma = Turma()
turma.adicionar_alunos("Maria", 80)
turma.adicionar_alunos("João", 70)
turma.adicionar_alunos("Cecilia", 90)
turma.adicionar_alunos("Maria", 76)

turma.listar_alunos()

outPut = turma.remover_aluno("Maria")
if outPut != "Null":
    print(f"removi quem? {outPut}")
else:
    print("Não existe chave")


                    