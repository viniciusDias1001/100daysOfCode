# Entrada da quantidade de lista
while True:
    try:
        nListaCompras = int(input('Digite a quantidade de listas de compras: '))
        if 1 <= nListaCompras <= 100:
            break
        else:
            print('Insira um valor entre 1 e 100.')
    except ValueError:
        print('Digite apenas números inteiros.')
# Loop usando split para criação de lista
todasListasCompras = []
for x in range(nListaCompras):
    listaCompras = input('Digite dados separados por espaço e com caracteres menores que 20: ')
    itens = listaCompras.split()
    
# Exclusão de itens duplicados por criação de nova lista
    itens_unicos = []
    for item in itens:  
        if item not in itens_unicos:
            itens_unicos.append(item)
            
# Ordenação em ordem alfabética            
    for i in range(len(itens_unicos)):
        menor_letra = i
        for j in range(i + 1, len(itens_unicos)):
            if itens_unicos[j] < itens_unicos[menor_letra]:
                menor_letra = j
        itens_unicos[menor_letra], itens_unicos[i] = itens_unicos[i], itens_unicos[menor_letra]
    
    todasListasCompras.append(itens_unicos)
    
for listaCompras in todasListasCompras:
    print(listaCompras)

        
        