class Aluno:
    def __init__(self, nome, nota):
        self.nome = nome
        self.nota = nota

    def exibir_informacoes(self):
        print(f"Nome: {self.nome} - Nota: {self.nota}")

class Turma:
    def __init__(self):
        self.alunos = []

    def adicionar_aluno(self, aluno):
        self.alunos.append(aluno)

    def remover_aluno(self, aluno):
        self.alunos.remove(aluno)

    def ordenar_nota(self):
        self.alunos.sort(key = lambda aluno:aluno.nota)

    def ordenar_nome(self):
        self.alunos.sort(key = lambda aluno:aluno.nome)

    def listar_alunos(self):
        print("\n\n******Imprimindo Alunos******")
        for aluno in self.alunos:
            aluno.exibir_informacoes()

obj_turma = Turma()

obj_turma.adicionar_aluno(Aluno("Paulo", 7.89))
obj_turma.adicionar_aluno(Aluno("Mariana", 8.9))
obj_turma.adicionar_aluno(Aluno("Pedro", 5.8))
obj_turma.adicionar_aluno(Aluno("Maria", 9.7))

obj_turma.listar_alunos()

obj_turma.remover_aluno(obj_turma.alunos[0])

obj_turma.listar_alunos()

obj_turma.ordenar_nome()

obj_turma.listar_alunos()