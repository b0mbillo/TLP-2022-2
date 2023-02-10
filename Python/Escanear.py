class Escanear:
    def __init__(self,codigo = ""):
        self.codigo = codigo
        self.retorno = "Error código de barras no encontrado"
        if codigo == "12345":
            self.retorno = 7500
        elif codigo == "23456":
            self.retorno = 12400
        elif codigo == "":
            self.retorno = "Error: producto no encontrado"
    def mensaje(self):
        print("$",self.retorno) if isinstance(self.retorno, int) else print(self.retorno)

    def productos(self):
        cont = 0
        while True:
            cod = input("digite el codigo: ")
            prod = Escanear(cod)
            retorno = prod.retorno
            prod.mensaje()
            if isinstance(retorno, int):
                 cont += retorno
            op = input("desea ingresar otro codigo? 1.Si Otro.no \n")
            if op != "1":
                print("valor total a pagar: $",cont)
                return

""" Implementa un método que permita escanear múltiples productos y que retorne el valor total a
pagar """

#Escanear().productos() #Para correr el metodo