import numpy as np
import matplotlib.pyplot as plt

def interpolate_quadratic(x, y, t):
    u = 1 - t
    tt = t * t
    uu = u * u

    result = uu * y[0] + 2 * u * t * y[1] + tt * y[2]
    return result

# Pontos conhecidos
x = [1, 3, 6]
y = [4, 8, 3]

# Pontos interpolados
interpolated_x = np.linspace(x[0], x[2], num=100)
interpolated_y = [interpolate_quadratic(x, y, t) for t in np.linspace(0, 1, num=100)]

# Plotar gráfico
plt.plot(x, y, 'bo', label='Pontos Conhecidos')
plt.plot(interpolated_x, interpolated_y, 'r-', label='Interpolação Quadrática')
plt.xlabel('x')
plt.ylabel('y')
plt.title('Interpolação Quadrática')
plt.legend()
plt.grid(True)
plt.show()