
# Criptografia Twofish - Criptografar e Descriptografar

Desafio: 

O Twofish é um algoritmo de criptografia simétrica forte que opera com blocos de dados. Neste desafio, 
você deverá implementar um programa que seja capaz de criptografar e descriptografar uma mensagem utilizando o algoritmo Twofish.

---

Entrada:

A entrada consiste em três linhas:

A primeira linha contém a opção "C" ou "D", indicando se a operação é de criptografia (C) ou descriptografia (D).
A segunda linha contém a mensagem a ser processada, composta apenas por caracteres alfanuméricos e espaços.
A terceira linha contém a chave de criptografia, composta apenas por caracteres alfanuméricos.

---

Saída:

O programa deve imprimir a mensagem processada de acordo com a operação escolhida:

Se a opção for "C" (criptografia), deve ser impressa a mensagem criptografada.
Se a opção for "D" (descriptografia), deve ser impressa a mensagem descriptografada.

---


Exemplo de Entrada:
C
Mensagem: "Hello, World!"
Chave de Criptografia: "SecretKey123"

Exemplo de Saída:
Mensagem Criptografada: "FJ94Xm3R56HVwa8lB/KIEw=="

Exemplo de Entrada:
D
Mensagem Criptografada: "FJ94Xm3R56HVwa8lB/KIEw=="
Chave de Criptografia: "SecretKey123"

Exemplo de Saída:

Mensagem Descriptografada: "Hello, World!"

Neste exemplo, o programa deve ser capaz de criptografar a mensagem "Hello, World!" utilizando a chave "SecretKey123" e produzir a mensagem criptografada "FJ94Xm3R56HVwa8lB/KIEw==". Além disso, o programa deve ser capaz de descriptografar a mensagem criptografada de volta para a mensagem original.