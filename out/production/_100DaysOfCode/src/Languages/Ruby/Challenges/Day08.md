# Sequência Lógica

Desafio:

Desenvolva um programa capaz de ler um valor inteiro N. N * 2 linhas de saída vão ser apresentadas na execução do programa,
seguindo a lógica do exemplo mais abaixo. Para os valores com mais de seis dígitos,
todos os dígitos devem ser apresentados.

---

Entrada:

O arquivo de entrada contém um número inteiro positivo N (1 < N < 1000).

---

Saída:

Imprima a saída conforme o exemplo fornecido.


Exemplo de entrada:

5

Exemplo de saída:

1 1 1

1 2 2

2 4 8

2 5 9

3 9 27

3 10 28

4 16 64

4 17 65

5 25 125

5 26 126


Explicação do exemplo de saída:

A entrada é 5, então teremos 5 * 2 = 10 linhas de saída.

Cada linha possui três valores: o primeiro valor é o número sequencial começando de 1 e indo até N;
o segundo valor é o primeiro valor ao quadrado;
o terceiro valor é o primeiro valor ao cubo.

Portanto, a sequência de saída segue a lógica:

1 1 1 -> 1 ao quadrado é 1, 1 ao cubo é 1
1 2 2 -> 1 ao quadrado é 1, 2 ao cubo é 2
2 4 8 -> 2 ao quadrado é 4, 2 ao cubo é 8
2 5 9 -> 2 ao quadrado é 4, 2 ao cubo é 8
3 9 27 -> 3 ao quadrado é 9, 3 ao cubo é 27
3 10 28 -> 3 ao quadrado é 9, 3 ao cubo é 27
4 16 64 -> 4 ao quadrado é 16, 4 ao cubo é 64
4 17 65 -> 4 ao quadrado é 16, 4 ao cubo é 64
5 25 125 -> 5 ao quadrado é 25, 5 ao cubo é 125
5 26 126 -> 5 ao quadrado é 25, 5 ao cubo é 125
