# Torre de Hanoi


Desafio:
Você deve implementar um algoritmo para resolver o quebra-cabeça da Torre de Hanoi.
A Torre de Hanoi consiste em três pilhas verticais de discos de diferentes tamanhos, sendo que os discos maiores estão na parte inferior. 
O objetivo é mover todos os discos da primeira pilha para a terceira pilha, respeitando as seguintes regras:

Apenas um disco pode ser movido de cada vez.
Um disco maior nunca pode ficar em cima de um disco menor.
Seu algoritmo deve receber como entrada o número de discos na primeira pilha e imprimir os passos necessários para mover todos os discos para a terceira pilha.

---

Entrada:

Número de discos na primeira pilha (um número inteiro positivo)

---

Saída:

Os passos necessários para resolver a Torre de Hanoi, indicando a movimentação de cada disco de uma pilha para outra.

---

Explicação:

A Torre de Hanoi é um desafio clássico de recursão. Dada uma pilha de discos na primeira pilha, 
devemos movê-los para a terceira pilha seguindo as regras mencionadas acima.

Por exemplo, se o número de discos na primeira pilha for 3, a solução seria a seguinte:

- Mover o disco 1 da pilha A para a pilha C.
- Mover o disco 2 da pilha A para a pilha B.
- Mover o disco 1 da pilha C para a pilha B.
- Mover o disco 3 da pilha A para a pilha C.
- Mover o disco 1 da pilha B para a pilha A.
- Mover o disco 2 da pilha B para a pilha C.
- Mover o disco 1 da pilha A para a pilha C.

O resultado final é que todos os discos foram movidos da primeira pilha para a terceira pilha.

Seu algoritmo deve ser capaz de lidar com diferentes números de discos na primeira pilha e imprimir os passos necessários para resolver o quebra-cabeça da Torre de Hanoi.