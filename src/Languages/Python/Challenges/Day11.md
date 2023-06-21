
# Agrupamento de Anagramas

Desafio:

Descrição: Dado um array de strings, implemente um programa  que agrupe as strings que 
são anagramas entre si. Um anagrama é uma palavra ou frase formada pela transposição das 
letras de outra palavra ou frase. Por exemplo, as palavras "roma" e "amor" são anagramas entre si.

---

Entrada: Um array de strings contendo palavras. O tamanho do array é N (1 ≤ N ≤ 10^4) e
o tamanho de cada string é M (1 ≤ M ≤ 100).

---

Saída: Um array de listas de strings, onde cada lista representa um grupo de palavras anagramas 
entre si.

---

Exemplo de entrada:

["roma", "amor", "gato", "toga", "tora", "arco", "cortar"]

Exemplo de saída:

[["roma", "amor"], ["gato", "toga"], ["tora", "arco"], ["cortar"]]


---

Explicação: No exemplo acima, temos os seguintes grupos de anagramas:

["roma", "amor"]

["gato", "toga"]

["tora", "arco"]

["cortar"]

Cada lista representa um grupo de palavras que são anagramas entre si.