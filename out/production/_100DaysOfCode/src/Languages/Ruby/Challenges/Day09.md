 # Validador de Sudoku

Descrição:

Um Sudoku é um jogo de lógica em que você precisa preencher uma grade 9x9 com dígitos de 1 a 9,
de forma que cada linha, cada coluna e cada uma das nove subgrades 3x3 contenha todos os dígitos de 1 a 9,
sem repetições. Sua tarefa é escrever um programa em Ruby que valide se uma grade preenchida 
representa corretamente um Sudoku.

---

Entrada:

A entrada consiste em uma matriz 9x9, onde cada posição contém um número inteiro de 1 a 9.

---

Saída:

Imprima "Válido" se a grade representar corretamente um Sudoku e "Inválido" caso contrário.


---

Exemplo de entrada:

[5, 3, 4, 6, 7, 8, 9, 1, 2],
[6, 7, 2, 1, 9, 5, 3, 4, 8],
[1, 9, 8, 3, 4, 2, 5, 6, 7],
[8, 5, 9, 7, 6, 1, 4, 2, 3],
[4, 2, 6, 8, 5, 3, 7, 9, 1],
[7, 1, 3, 9, 2, 4, 8, 5, 6],
[9, 6, 1, 5, 3, 7, 2, 8, 4],
[2, 8, 7, 4, 1, 9, 6, 3, 5],
[3, 4, 5, 2, 8, 6, 1, 7, 9]


Exemplo de Saída:
Válido

---

Explicação:

A matriz de entrada representa um Sudoku válido, pois todas as linhas,
colunas e subgrades 3x3 contêm todos os dígitos de 1 a 9 sem repetições.