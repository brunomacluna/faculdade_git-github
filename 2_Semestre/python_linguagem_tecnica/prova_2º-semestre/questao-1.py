# QUESTÃO 1 • valor: 4,0 pontos
# Você recebeu uma planilha Excel chamada "notas.xlsx" com as seguintes colunas: Nome,
# Curso, Aluno, Nota1, Nota2 e Nota3. Sua tarefa é calcular a média das notas para cada aluno
# e criar uma nova coluna chamada "Média" na planilha. Após isso, salve o arquivo atualizado
# como "ProvaALunoxxx.xlsx".
# Observação: Escreva o código em Python para realizar esta tarefa usando a biblioteca
# pandas.

import pandas as pandas

df = pandas.read_excel("/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/prova_2º-semestre/notas.xlsx", sheet_name="Sheet1")


media_notas = df.groupby('Nota1', 'Nota2', 'Nota3', as_index=False) ['Média Notas'].mean() 


media_notas.rename(columns={'Nota final': 'Média Notas'}, inplace=True)


print(media_notas)