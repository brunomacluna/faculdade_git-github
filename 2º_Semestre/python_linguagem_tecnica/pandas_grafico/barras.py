import pandas as pandas
import matplotlib.pyplot as plt

dados_vendas = pandas.read_excel('/home/bruno/faculdade_git-github/2º_Semestre/python_linguagem_tecnica/pandas_grafico/dados_vendas.xlsx')

dados_vendas["Data"] = pandas.to_datetime(dados_vendas["Data"], format="%d/%m/%Y")