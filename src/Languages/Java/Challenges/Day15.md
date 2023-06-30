# Cifra de César

Desafio:

A Cifra de César é um tipo de criptografia por substituição, onde cada letra do texto original é substituída 
por outra letra que se encontra a um número fixo de posições à sua frente no alfabeto. Por exemplo, com uma troca de 3 posições, 
A' seria substituído por 'D', 'B' se tornaria 'E', e assim por diante.

Seu objetivo é implementar um programa que receba uma string criptografada usando a Cifra de César com um deslocamento e retorne a string original.

---

Entrada:

A entrada consiste em uma única linha contendo a string criptografada. 
A string possui apenas letras maiúsculas do alfabeto inglês e nenhum caractere especial.

---

Saída:

Imprima a string original descriptografada.

---

Exemplo de entrada:

defghijklmnopqrstuvwxyzabc

Exemplo de saída:

ABCDEFGHIJKLMNOPQRSTUVWXYZ


Neste exemplo, a string criptografada é "defghijklmnopqrstuvwxyzabc". Através da Cifra de César, 
sabemos que cada letra foi deslocada 3 posições para frente no alfabeto para obter a string criptografada.
Portanto, ao desfazer o deslocamento, a string original é "ABCDEFGHIJKLMNOPQRSTUVWXYZ".

Dica:

Char ch = 65;
System.out.println(ch);

SAIDA:
Z

