import math

def funcao(x):

    """
    Aqui você define a função a ser Calculada, para demonstrar o exemplo
    utilizaremos a função [ f(x) = x^3 - 4x - 9 ]
    """

    return x**3  - 4*x - 9

def metodo_bisseccao(a, b, tolerancia, iteracoes_maximas):

    """
    a = menor valor do intervalo [(a),b]
    b = maior valor do intervalo [a,(b)]
    tolerancia = tolerancia do erro
    iteracoes_maximas = número máximo de iterações
    """

    a: float              
    b: float
    tolerancia: float  
    iteracoes_maximas: int  

    a = 1
    b = 3
    tolerancia = 1e-6
    iteracoes_maximas = 100

    if funcao(a) * funcao(b) >= 0:
        raise ValueError("A função precisa possuir sinais diferentes tanto em a quanto em b")

    x = (a + b) / 2
    iteracao = 1

    while abs(funcao(x)) > tolerancia and iteracao < iteracoes_maximas:
        if funcao(a) * funcao(x) < 0:
            b = x
        else:
            a = x
        
        x = ( a + b) / 2
        iteracao += 1

        if iteracao == iteracoes_maximas:
            print("Atingimos o número máximos de Iterações")
        else:
            ("A raiz aproximada é de: ", x)

            return x, iteracao