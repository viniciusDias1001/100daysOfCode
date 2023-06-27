
# Coração das Cartas

Desafio:

Marcos decidiu abandonar o bar da faculdade onde jogava truco para dedicar-se ao
mundo da programação. Para que isso fosse mais fácil, decidiu criar um novo jogo
de cartas.

O coração das cartas, como Marcos apelidou o jogo, é individual e jogado com três
pilhas, inicialmente com o mesmo número de cartas. Cada carta tem um valor numérico
inteiro de 0 até 9. O jogador pode, a qualquer momento ver o valor de qualquer carta,
mas só pode jogar com as cartas que estão no topo das pilhas. Em cada rodada, o jogador
pode remover qualquer combinação de cartas que estejam no topo da pilha (pode escolher 1,
2 ou até 3 cartas) cuja soma dos valores seja múltiplo de 3. O jogo é ganho quando todas
as cartas forem removidas das pilhas. Se alguma carta não puder ser removida, perde-se o
jogo.

---

Entrada:

A entrada é composta por várias instâncias Cada instância é iniciada por um inteiro N
(0 ≤ N ≤ 100), que identifica o número de cartas em cada pilha. A entrada termina quando
N = 0. Cada uma das N linhas seguintes contém três inteiros A, B e C, que descrevem os
valores numéricos das cartas em um nível da pilha (0 ≤ A, B, C ≤  9). As pilhas são
descritas do topo até o fundo.

---

Saída:

Para cada instância, imprima uma linha contendo o número 1 se o jogador pode ganhar a
instância do jogo ou o número 0 se o jogo for impossível.

---

Exemplo de entrada:

3

1 1 1

2 2 2

1 1 1

6

0 0 0

0 0 1

0 0 2

0 0 3

0 0 4

0 0 5

0


exemplo de saida:

1

0

Explicação:

No primeiro caso de teste, temos três pilhas com cartas de valores (1, 1, 1), (2, 2, 2) e (0, 1, 1).
O jogador pode remover as cartas (1, 2) das duas primeiras pilhas, pois a soma desses valores é 3 (múltiplo de 3), 
deixando apenas a carta (1, 1, 1) na última pilha, que também pode ser removida. Portanto, o jogador pode ganhar o jogo.
No segundo caso de teste, temos seis pilhas com cartas de valores 
(0, 0, 0), (0, 0, 1), (0, 0, 2), (0, 0, 3), (0, 0, 4) e (0, 0, 5). 
Não é possível remover nenhuma combinação de cartas que resulte em uma soma múltipla de 3. Portanto, 
o jogador não pode ganhar o jogo.
No terceiro caso de teste, não há cartas nas pilhas (N = 0), o que indica o fim do jogo.