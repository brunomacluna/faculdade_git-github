import pandas as pd 

df = pd.read_excel("/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas/aula_30-10/dados_exemplo.xlsx"
    , sheet_name="Sheet1") 
#Calculando a média da Receita Total por Produto 
#as_index=False: impede que a coluna agrupada (Produto) vire o índice. 
#Em vez disso, Produto é mantido como uma coluna comum no novo DataFrame 
media_receita_por_produto = df.groupby('Produto', as_index=False)['Receita Total'].mean()

#Exibindo o DataFrame com a nova coluna 
print(media_receita_por_produto)