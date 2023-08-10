Você deve implementar um programa em Java que informe, para uma sequência de números inteiros, se cada um deles é número primo ou não. O programa deve ser multi-thread: para cada número passado como entrada, deve ser criada pelo menos uma thread para verificar se esse número é primo.

A execução do programa deve ser feita em linha de comando, da seguinte forma:

> java VerificaNumerosPrimos <lista-de-numeros>

A saída deve imprimir uma linha para cada número da lista informando se ele é primo ou não.

Exemplo:
---
> java VerificaNumerosPrimos 13 507 991 809 1555

O número 13 é primo.
O número 507 não é primo.
O número 991 é primo.
O número 809 é primo.
O número 1555 não é primo.
---

Nesse exemplo, pelo menos 5 threads seriam criadas (pelo menos 1 thread para processar cada número da lista).