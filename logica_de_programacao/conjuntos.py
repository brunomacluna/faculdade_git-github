
libertadores = {"Vasco", "Botafogo", "Palmeiras", "Flamengo", "Santos", "Bragantino"}
brasilirao = {"Goias", "Santos", "Vasco", "Gama", "Flamengo"}

a = libertadores.intersection(brasilirao)
b = libertadores.difference(brasilirao)
c = brasilirao.difference(libertadores)
d = libertadores.union(brasilirao)

print("a) ",a)
print("b) ",b)
print("c) ",c)
print("d) ",d)
