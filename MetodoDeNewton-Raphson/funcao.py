import math

def funcao(x):

    """
    Aqui você define a função a ser Calculada, para demonstrar o exemplo
    utilizaremos a função [ f(x) = x^2 - 4 ]
    """

    return x**2  - 4

def derivada(x):

    """
    Este Método faz a derivação da função de (x) que neste 
    caso é f(x) = x^2 - 4, logo sua derivada será: f(x) = 2x.
    """

    return 2*x

def motedo_newton_raphson(x0, tolerancia, iteracoes_maximas):

    """
    x0 = valor inicial
    tolerancia = tolerancia do erro
    iteracoes_maximas = número máximo de iterações
    """

    x0: float
    tolerancia: float
    iteracoes_maximas: int

    iteracao = 1
    x0 = 2
    tolerancia = 1e-6
    iteracoes_maximas = 100

    while abs(funcao(x)) > tolerancia and iteracao < iteracoes_maximas:
        x = x - funcao(x) / derivada(x)
        iteracao = 1

    if iteracao == iteracoes_maximas:
        print("Atingimos o número máximos de Iterações")
    else:
        print("A raiz aproximada é de: ", x)

    return x, iteracao