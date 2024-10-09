def eh_par(valor):
    if valor % 2 == 0:
        return True
    else:
        return False
    
def eh_impar(valor):
    if valor % 2 == 1:
        return True
    else:
        return False
 
def percorrePares(limitante):
    if limitante <= 0:
        print("Não possui um range válido.")
    else:
        for i in range(1, limitante):
            if eh_par(i):
                print(f"{i} ")

percorrePares(20)

def percorreImpar(limitante):
    if limitante <= 0:
        print("Não é um range válido.")
    else:
        for i in range(1, limitante):
            if eh_impar(i):
                print(f"{i}", end=" ")

percorreImpar(20)                