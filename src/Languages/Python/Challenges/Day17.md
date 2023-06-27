# Criptografia por Substituição Aleatória


Desafio:

Você deve implementar um algoritmo de criptografia por substituição em que a chave de substituição é gerada aleatoriamente.
O algoritmo deve ser capaz de criptografar e descriptografar mensagens usando a chave de substituição gerada.

---

Entrada:

Escolha: Criptografar ou Descriptografar
Mensagem: Uma string contendo a mensagem a ser processada

---

Saída:

Se a escolha for "Criptografar":
Mensagem Criptografada: A mensagem criptografada resultante da substituição aleatória
Chave de Substituição: A chave de substituição gerada aleatoriamente


Se a escolha for "Descriptografar":
Mensagem Descriptografada: A mensagem original resultante da descriptografia usando a chave de substituição fornecida


---

Explicação:

Para criptografar a mensagem, você deve gerar aleatoriamente uma chave de substituição,
que mapeia cada letra do alfabeto para uma outra letra aleatória. Em seguida, substitua cada letra da mensagem
pela letra correspondente na chave de substituição gerada.
Para descriptografar a mensagem, use a mesma chave de substituição fornecida. Realize a substituição inversa,
ou seja, substitua cada letra da mensagem criptografada pela letra correspondente na chave de substituição.
Dessa forma, a chave de substituição será gerada aleatoriamente em cada execução do programa, tornando o processo de criptografia mais seguro.


Entrada:

Escolha: Criptografar

Mensagem: "Hello, World!"

Saída:
Mensagem Criptografada: "Jvuuf, Yqtnf!"

Chave de Substituição: {'H': 'J', 'e': 'v', 'l': 'u', 'o': 'f', ',': ',', ' ': ' ', 'W': 'Y', 'r': 'q', 'd': 't', '!': 'n'}

---

Explicação:

Neste exemplo, a mensagem "Hello, World!" foi criptografada usando uma chave de substituição aleatória gerada.
Cada letra da mensagem foi substituída pela letra correspondente na chave de substituição.
A chave de substituição foi gerada aleatoriamente e mapeia cada letra do alfabeto para outra letra.
A mensagem criptografada resultante foi "Jvuuf, Yqtnf!" e a chave de substituição utilizada
foi {'H': 'J', 'e': 'v', 'l': 'u', 'o': 'f', ',': ',', ' ': ' ', 'W': 'Y', 'r': 'q', 'd': 't', '!': 'n'}.

Na etapa de descriptografia, se a escolha fosse "Descriptografar" e a chave de substituição fornecida fosse
{'H': 'J', 'e': 'v', 'l': 'u', 'o': 'f', ',': ',', ' ': ' ', 'W': 'Y', 'r': 'q', 'd': 't', '!': 'n'},
a mensagem criptografada "Jvuuf, Yqtnf!" seria descriptografada para a mensagem original "Hello, World!".

Lembrando que a chave de substituição será gerada aleatoriamente em cada execução do programa, resultando em mensagens criptografadas diferentes a cada vez.