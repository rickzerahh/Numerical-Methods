import math

def funcao(x):

    """
    Aqui você define a função a ser Calculada, para demonstrar o exemplo
    utilizaremos a função [ f(x) = x^2 - 4 ]
    """

    return x**2  - 4

def motedo_falsa_posicao(x0, tolerancia, iteracoes_maximas):

    """
    x0 = valor inicial
    tolerancia = tolerancia do erro
    iteracoes_maximas = número máximo de iterações
    """

    x0 = 2
    tolerancia = 1e-6
    iteracoes_maximas = 100
    iteracao += 1

    while abs(funcao(x)) > tolerancia and iteracao < iteracoes_maximas:
        x = funcao(x)
        iteracao += 1

    if iteracao == iteracoes_maximas:
        print("Atingimos o número máximos de Iterações")
    else:
        print("A raiz aproximada é de: ", x)

    return x, iteracao