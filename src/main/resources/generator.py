import random

file = open("input.txt", "w")
matrix_size = random.randint(2, 20)
file.write(f'{matrix_size}\n')

"""
    Генерация коэффициентов матрицы
"""
for i in range(matrix_size):
    for j in range(matrix_size):
        file.write(f"{random.randint(-matrix_size, matrix_size)} ")
    file.write("\n")

"""
    Генерация свободных членов матрицы
"""
for i in range(matrix_size):
    file.write(f"{random.randint(-matrix_size, matrix_size)} ")
file.write("\n")


