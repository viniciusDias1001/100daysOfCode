# Fila do Banco

Desafio:

O banco onde você trabalha está enfrentando problemas para organizar 
a fila de atendimento dos clientes. Após uma reunião com a gerência, 
foi decidido que os clientes receberão uma senha numérica via SMS em seus celulares 
assim que chegarem à agência. A ordem de atendimento será determinada pelo número
recebido via SMS, onde os clientes com números maiores serão atendidos primeiro.
A sua tarefa é reordenar a fila de acordo com os números recebidos via SMS,
mantendo a ordem de chegada dos clientes. 
Então, dada a ordem de chegada dos clientes reordene a fila de
acordo com o número recebido via sms, e diga quantos clientes não
precisaram trocar de lugar nessa reordenação.

---

Entrada:

A entrada começa com um inteiro M (1 ≤ M ≤ 1000), indicando o número de clientes. 
Em seguida, haverá M inteiros distintos Pi (1 ≤ Pi ≤ 1000), 
representando os números recebidos via SMS pelos clientes. 
Os inteiros são dados na ordem de chegada, ou seja, 
o primeiro inteiro corresponde ao primeiro cliente a chegar na fila, 
o segundo inteiro corresponde ao segundo cliente, e assim por diante.
 Os inteiros acima são dados em ordem de chegada, ou seja, o primeiro
inteiro diz respeito ao primeiro cliente a chegar na fila, o segundo
inteiro diz respeito ao segundo cliente, e assim sucessivamente.

---

Saída:

Para cada caso de teste, imprima uma linha contendo um inteiro, 
indicando o número de clientes que não precisaram trocar de lugar mesmo após a fila 
ser reordenada. e crie uma lista com a lista ordenada de forma correta.


Exemplo de Entrada:
5
10 8 15 3 12

Exemplo de Saída:
2
15 12 10 8 3 