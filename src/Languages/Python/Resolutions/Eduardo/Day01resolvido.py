# Inicialização das listas
lista_num = []
lista_par = []
lista_impar = []

# Setando o número de componentes e valores da entrada
while True:
    qtde_num = int(input('Selecione quantos números deseja adicionar: '))
    i = 1
    if qtde_num < 0:
        print('Por favor, insira um número inteiro, não negativo. ')
        continue
    while i <= qtde_num:
        num = int(input('Insira o número a ser adicionado: '))
        lista_num.append(num)
        i += 1
        
# Construção das listas pares e ímpares
    for numero in lista_num:
        if numero % 2 == 0:
            lista_par.append(numero)
        else:
            lista_impar.append(numero)
            
# Loop para ordenação da lista par              
    for x in range(len(lista_par)):
        for y in range(x + 1, len(lista_par)):
            if lista_par[x] > lista_par[y]:
                lista_par[x], lista_par[y] = lista_par[y], lista_par[x]
    lista_par_ordenada = lista_par

# Loop para ordenação da lista ímpar   
    for a in range(len(lista_impar)):
        for b in range(a + 1, len(lista_impar)):
            if lista_impar[a] < lista_impar[b]:
                lista_impar[a], lista_impar[b] = lista_impar[b], lista_impar[a]
    lista_impar_ordenada = lista_impar

# Junção da lista par e ímpar 
    lista_par_ordenada.extend(lista_impar_ordenada)
    lista_final = lista_par_ordenada
    
    print(f'A lista gerada é {lista_final}')
    
# Desafio:
# Crie um programa onde você receberá valores inteiros
# não negativos como entrada.

# Ordene estes valores de acordo com o seguinte critério:

# Primeiro os Pares
# Depois os Ímpares

# Você deve exibir os pares em ordem crescente e na sequência
# os ímpares em ordem decrescente.
# ---
# Entrada:


# A primeira linha de entrada contém um único inteiro positivo
# N (1 < N < 10000) Este é o número de linhas de entrada que vem
# logo a seguir. As próximas N linhas terão, cada uma delas, um
# valor inteiro não negativo.
# ---
# Saída:


# Exiba todos os valores lidos na entrada segundo a ordem apresentada
# acima. Cada número deve ser impresso em uma linha, conforme exemplo de
# saída abaixo.

# ---

# Exemplo de entrada:

# How many numbers do you want to add to the Array ?

# 5

# enter a numbers:

# 4 3 3 6 7

# Exemplo de saida:

# [4, 6, 7, 3, 3]