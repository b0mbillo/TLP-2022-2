import time as t
# 1. Definir una función filter que imprima los primos que existen en el rango de 1 a tope (i.e. range(1,tope+1)). 
#De esta forma, la función de orden superior filter debe utilizar una función booleana llamada “esprimo(n)” la cual devuelve True si el n es primo y False en caso contrario.
#La variable tope se obtiene como parametro de entrada de una función, asi:

def esprimo(num):
    for i in range(2,(num//2)+1):
        if num%i == 0:
            return False
    return True
    #aqui va su codigo:

def filterprimo(tope):
    #Aqui va su codigo, por favor no borrar la linea de abajo, esto ayuda a validar los resultados en minaslap
    listaprimo = filter(esprimo,range(2, tope+1),)
    listaprimos = [y for y in listaprimo]
    return listaprimos

#print(filterprimo(10))

#2. Utilizar la noción de generador para crear una función gen_primos(N) que devuelva una lista con los numeros primos hasta N. 
#La función gen_primos utiliza la función booleana esprimo(i) para determinar si i es primo (True) o no (False).
""" def esprimo(num):
    for i in range(2,(num//2)+1):
        if num%i == 0:
            return False
    return True
 """
def gen_primos(N):
    for i in range(2, N+1):
        if esprimo(i): yield i

#print([i for i in gen_primos(10)])

# 3. Programar Factorial Recursivo Cola (Tail).

def tailFactorial(n,acum = 1):
#Aqui va su codigo, tambien debe rellenar los parametros de la funcion y el retorno
    if n==1:
        return acum
    else:
        return tailFactorial(n-1,acum*n)

ti = t.time()
print("factorial cola:",tailFactorial(50))
tf = t.time()
print("elapsed time:",(tf-ti))

#comparacion de factorial normal

def factorial(n):
  if n<=0:
    return 1
  else:
    return n*factorial(n-1)

ti = t.time()
print("factorial:",factorial(50))
tf = t.time()
print("elapsed time:",(tf-ti))

# 4. Programar Fibonacci Simple (n) y Fibonacci Recursivo Cola (n).

def fibonacci(n):
    #aqui va su codigo, tambien debe rellenar los parametros de la funcion y el retorno
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibonacci(n-2) + fibonacci(n-1)

ti = t.time()
print("fibonacci",fibonacci(40))
tf = t.time()
print("elapsed time:",(tf-ti))


def tailfibonacci(n, a = 0, b = 1):
#aqui va su codigo, tambien debe rellenar los parametros de la funcion y el retorno
    if n == 0:
        return a
    if n == 1:
        return b
    return tailfibonacci(n - 1, b, a + b);

ti = t.time()
print("fibonacci cola",tailfibonacci(50))
tf = t.time()
print("elapsed time:",(tf-ti))

# 5. DarkSouls de los DarkSouls

def subconjunto(pesos):
    Lt=[]
    if not pesos:
        Lt.append(pesos)
    else:
        for i in subconjunto(pesos[1:]):
            Lt.append(i)
            Lt.append([pesos[0]] + i)
    return Lt

#print(subconjunto([3,2,5]))

def existe(peso,pesos):
    #aqui va su codigo, tambien debe rellenar los parametros de la funcion y el retorno
    #en esta funcion debe devolver los subconjuntos que cumplan con el enunciado 
    conjuntos = subconjunto(pesos)
    Lista = []
    for i in conjuntos:
        i.sort()
        Lista.append(i)
        if sum(i) == peso and i:
            Lista.append(i)
    Lista.sort(key=lambda x: (len(x), (x)))
    return Lista

#print(existe(5,[3,2,5]))
g = lambda c: f(c,i(c))
f = lambda a,b: a==b
i = lambda p: p[::-1]
