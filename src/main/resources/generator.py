import random

file = open("test.txt", "w")
# matrix_size = random.randint(2, 20)
matrix_size = 3
file.write(f'{matrix_size}\n')
epsilon = '0,01'
file.write(f'{epsilon}\n')
max_iterations = 1000
file.write(f'{max_iterations}\n')
for i in range(matrix_size):
    for j in range(matrix_size):
        file.write(f"{random.randint(-10, 10)} ")
    file.write("\n")

for i in range(matrix_size):
    file.write(f"{random.randint(-10, 10)} ")
file.write("\n")

for i in range(matrix_size):
    file.write(f"{random.randint(-10, 10)} ")
