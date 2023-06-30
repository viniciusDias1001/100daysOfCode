
# Teorema da Divisão Euclidiana

Desafio:

Você recebeu desafio de desenvolver um programa que calcule o quociente e o resto da divisão de dois números inteiros.
Não se esqueça que o quociente e o resto da divisão de um inteiro a por um inteiro não-nulo b são respectivamente os únicos inteiros q e r tais que:

0 ≤ r < |b| Se r < 0: r = r - |b| a = b × q + r q = ( a - r ) / b

Caso você não saiba, o teorema que garante a existência e a unicidade dos inteiros q e r é conhecido como ‘Teorema da Divisão Euclidiana’ ou ‘Algoritmo da Divisão’.

** |b| (Módulo / Valor absoluto): É o valor representado de forma positiva;

---

Entrada:

A entrada é composta por dois números inteiros a e b (-1.000 ≤ a, b < 1.000).

---

Saída:

Imprima o quociente q seguido pelo resto r da divisão de a por b, considerando as regras apresentadas a cima.


Entrada:

a = 27

b = 4

---

Saída:

Quociente: 6

Resto: 3

---

Neste exemplo, temos a = 27 e b = 4. Aplicando o Teorema da Divisão Euclidiana, encontramos que o quociente q é igual a (a - r) / b, onde r é o resto da divisão.

Passo 1: Calculando o quociente q:

q = (27 - r) / 4
Passo 2: Encontrando o resto r:

Como 0 ≤ r < |b|, começamos com r = 27 e decrementamos r por |b| até obtermos 0 ≤ r < |b|.
r = 27 - 4 = 23
r = 23 - 4 = 19
r = 19 - 4 = 15
r = 15 - 4 = 11
r = 11 - 4 = 7
r = 7 - 4 = 3
Portanto, o resultado final é Quociente: 6 e Resto: 3.

Você pode utilizar esse exemplo como base para implementar sua solução em qualquer linguagem de programação de sua preferência.