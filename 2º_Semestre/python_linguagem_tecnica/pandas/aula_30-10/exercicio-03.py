import pandas as pd 

df = pd.read_excel("/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas/aula_30-10/dados_exemplo.xlsx"
    , sheet_name="Sheet1")

#Filtrar vendas com Receita Total acima de 15 reais 
vendas = df[df['Receita Total'] > 15] 

#Exibir o resultado 
print(vendas)